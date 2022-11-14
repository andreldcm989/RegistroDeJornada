package com.controledejornada.registrodeponto.model.dtos.registro;

import java.io.Serializable;
import java.time.LocalTime;

public class RegistroDtoSalvar implements Serializable {

    private LocalTime horarioRegistro;
    private String tipoRegistro;

    public RegistroDtoSalvar() {
    }

    public RegistroDtoSalvar(LocalTime horarioRegistro, String tipoRegistro) {
        this.horarioRegistro = horarioRegistro;
        this.tipoRegistro = tipoRegistro;
    }

    public LocalTime getHorarioRegistro() {
        return horarioRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

}
