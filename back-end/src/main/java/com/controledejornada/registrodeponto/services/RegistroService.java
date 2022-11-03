package com.controledejornada.registrodeponto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.repository.RegistroRepository;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository repository;

    public List<Registro> listarRegistrosPorUsuario(int id) {
        return repository.findByUsuario(id);
    }

    public void excluirRegistro(int idRegistro) {
        Registro reg = repository.getReferenceById(idRegistro);
        if (reg != null) {
            repository.deleteById(idRegistro);
        }
    }

}