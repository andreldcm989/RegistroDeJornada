package com.controledejornada.registrodeponto.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoListar;
import com.controledejornada.registrodeponto.repository.RegistroRepository;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository repository;

    public List<RegistroDtoListar> listarRegistrosPorUsuario(int id) {
        List<Registro> registros = repository.findByUsuarioId(id);
        return registros.stream().map(r -> new RegistroDtoListar(r)).collect(Collectors.toList());
    }

    public List<RegistroDtoListar> listarRegistrosComFiltro(int id, String inicio, String fim) {
        LocalDateTime i = LocalDateTime.parse(inicio, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime f = LocalDateTime.parse(fim, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return repository.findByUsuarioIdAndHorarioRegistroBetween(id, i, f).stream()
                .map(r -> new RegistroDtoListar(r)).collect(Collectors.toList());
    }

    public void excluirRegistro(int idRegistro) {
        Registro reg = repository.getReferenceById(idRegistro);
        if (reg != null) {
            repository.deleteById(idRegistro);
        }
    }

}
