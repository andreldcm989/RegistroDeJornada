package com.controledejornada.registrodeponto.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.repository.RegistroRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public Registro salvarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public Registro editarRegistro(Registro registro) {
        Registro r = registroRepository.getReferenceById(registro.getId());
        BeanUtils.copyProperties(registro, r);
        return registroRepository.save(r);
    }

    public void excluirRegistro(int id) {
        Registro registro = registroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        if (registro != null) {
            registroRepository.deleteById(id);
        }
    }
}
