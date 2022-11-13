package com.controledejornada.registrodeponto.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.dtos.jornada.JornadaDtoListar;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoSalvar;
import com.controledejornada.registrodeponto.repository.JornadaRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

@Service
public class JornadaService {

    @Autowired
    private JornadaRepository jornadaRepository;

    @Autowired
    private RegistroService registroService;

    public List<JornadaDtoListar> listarJornadasPorUsuarioEData(int usuarioId, String inicio, String fim) {
        LocalDate i = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate f = LocalDate.parse(fim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return jornadaRepository.findByUsuarioIdAndDataBetween(usuarioId, i, f).stream()
                .map(j -> new JornadaDtoListar(j)).collect(Collectors.toList());
    }

    public List<JornadaDtoListar> listarJornadasPorUsuario(int id) {
        return jornadaRepository.findByUsuarioId(id).stream().map(j -> new JornadaDtoListar(j))
                .collect(Collectors.toList());
    }

    public List<JornadaDtoListar> listarJornadas() {
        return jornadaRepository.findAll().stream().map(j -> new JornadaDtoListar(j)).collect(Collectors.toList());
    }

    public Jornada buscarJornadaPorIdEUsuario(int jornadaId, int usuarioId) {
        return jornadaRepository.findByIdAndUsuarioId(jornadaId, usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException(jornadaId));
    }

    public JornadaDtoListar adicionarRegistro(int idJornada, RegistroDtoSalvar registro) {
        Jornada j = jornadaRepository.getReferenceById(idJornada);
        if (j != null) {
            registroService
                    .salvarRegistro(new Registro(j, registro.getHorarioRegistro(), registro.getTipoRegistro()));
            j.calcularHorasTrabalhadas();
            jornadaRepository.save(j);
            JornadaDtoListar dto = new JornadaDtoListar(j);
            return dto;
        }
        throw new ResourceNotFoundException(idJornada);
    }

}
