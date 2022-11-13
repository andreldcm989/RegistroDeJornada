package com.controledejornada.registrodeponto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoSalvar;
import com.controledejornada.registrodeponto.repository.RegistroRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public Registro salvarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public Registro editarRegistro(int idRegistro, RegistroDtoSalvar registro) {
        Registro r = registroRepository.getReferenceById(idRegistro);
        if (r != null) {
            r.setHorarioRegistro(registro.getHorarioRegistro());
            r.setTipoRegistro(registro.getTipoRegistro());
            return registroRepository.save(r);
        }
        throw new ResourceNotFoundException(idRegistro);
    }

    public void excluirRegistro(int id) {
        Registro registro = registroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        if (registro != null) {
            registroRepository.deleteById(id);
        }
    }
}
