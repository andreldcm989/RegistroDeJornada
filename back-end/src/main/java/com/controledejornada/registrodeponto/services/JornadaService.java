package com.controledejornada.registrodeponto.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoSalvar;
import com.controledejornada.registrodeponto.repository.JornadaRepository;
import com.controledejornada.registrodeponto.repository.RegistroRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

@Service
public class JornadaService {

    @Autowired
    private JornadaRepository jornadaRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Jornada> listarJornadasPorUsuarioEData(int usuarioId, String inicio, String fim) {
        LocalDate i = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate f = LocalDate.parse(fim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return jornadaRepository.findByUsuarioIdAndDataBetween(usuarioId, i, f);
    }

    public List<Jornada> listarJornadasPorUsuario(int id) {
        return jornadaRepository.findByUsuarioId(id);
    }

    public List<Jornada> listarJornadas() {
        return jornadaRepository.findAll();
    }

    public Jornada buscarJornadaPorIdEUsuario(int jornadaId, int usuarioId) {
        return jornadaRepository.findByIdAndUsuarioId(jornadaId, usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException(jornadaId));
    }

    // public Registro adicionarRegistro(int usuarioId, int idJornada,
    // RegistroDtoSalvar registro) {
    // Jornada j = jornadaRepository.getReferenceById(idJornada);
    // if (j == null) {
    // j = new Jornada(LocalDate.now(),
    // usuarioService.buscarUsuarioPorId(usuarioId));
    // }
    // Registro r = new Registro(j, registro.getHorarioRegistro(),
    // registro.getTipoRegistro());
    // registroRepository.save(r);
    // j.calcularHorasTrabalhadas();
    // jornadaRepository.save(j);
    // return r;
    // }
}
