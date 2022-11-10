package com.controledejornada.registrodeponto.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.repository.JornadaRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

@Service
public class JornadaService {

    @Autowired
    private JornadaRepository jornadaRepository;

    public List<Jornada> listarJornadasPorUsuarioEData(int usuarioId, String inicio, String fim) {
        LocalDate i = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate f = LocalDate.parse(fim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
}
