package com.controledejornada.registrodeponto.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.dtos.jornada.JornadaDtoListar;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoSalvar;
import com.controledejornada.registrodeponto.repository.JornadaRepository;
import com.controledejornada.registrodeponto.repository.UsuarioRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

@Service
public class JornadaService {

    @Autowired
    private JornadaRepository jornadaRepository;

    @Autowired
    private RegistroService registroService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<JornadaDtoListar> listarJornadasPorUsuarioEData(int usuarioId, String inicio, String fim) {
        if (!usuarioRepository.existsById(usuarioId))
            throw new ResourceNotFoundException(usuarioId);
        LocalDate i = inicio != null ? LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                : LocalDate.now().minusDays(30);
        LocalDate f = fim != null ? LocalDate.parse(fim, DateTimeFormatter.ofPattern("dd/MM/yyyy")) : LocalDate.now();
        return jornadaRepository.findByUsuarioIdAndDataBetween(usuarioId, i, f).stream()
                .map(JornadaDtoListar::new).toList();
    }

    public Jornada salvarJornada(String data, int usuarioId) {
        LocalDate dt = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return jornadaRepository.save(new Jornada(dt, usuarioRepository.findById(usuarioId).get()));
    }

    public List<JornadaDtoListar> listarJornadasPorUsuario(int id) {
        return jornadaRepository.findByUsuarioId(id).stream().map(j -> new JornadaDtoListar(j))
                .collect(Collectors.toList());
    }

    public List<JornadaDtoListar> listarJornadas() {
        return jornadaRepository.findAll().stream().map(j -> new JornadaDtoListar(j)).collect(Collectors.toList());
    }

    public JornadaDtoListar buscarJornadaPorId(int id) {
        return new JornadaDtoListar(jornadaRepository.findById(id).get());
    }

    public JornadaDtoListar buscarJornadaPorIdEUsuario(int jornadaId, int usuarioId) {
        Jornada jornada = jornadaRepository.findByIdAndUsuarioId(jornadaId, usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException(jornadaId));
        return new JornadaDtoListar(jornada);
    }

    public void adicionarRegistro(String data, int idUsuario, RegistroDtoSalvar registro) {
        try {
            LocalDate dt = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Jornada j = jornadaRepository.getReferenceByDataAndUsuarioId(dt, idUsuario);
            if (j == null) {
                salvarJornada(data, idUsuario);
                j = jornadaRepository.getReferenceByDataAndUsuarioId(dt, idUsuario);
            }
            Registro reg = new Registro(j, registro.getHorarioRegistro(), registro.getTipoRegistro());
            registroService.salvarRegistro(reg);
            j.calcularHorasTrabalhadas();
            jornadaRepository.save(j);
        } catch (EntityNotFoundException | NoSuchElementException e) {
            throw new ResourceNotFoundException(idUsuario);
        }
    }

    public JornadaDtoListar editarRegistro(int idJornada, int idRegistro, RegistroDtoSalvar registro) {
        try {
            Jornada j = jornadaRepository.getReferenceById(idJornada);
            registroService.editarRegistro(idRegistro, registro);
            j.calcularHorasTrabalhadas();
            jornadaRepository.save(j);
            return new JornadaDtoListar(j);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(idJornada);
        }
    }

    public void excluirJornada(int idJornada) {
        try {
            jornadaRepository.deleteById(idJornada);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(idJornada);
        }
    }

}
