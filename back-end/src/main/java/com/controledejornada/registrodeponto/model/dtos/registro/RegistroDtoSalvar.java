package com.controledejornada.registrodeponto.model.dtos.registro;

import java.io.Serializable;
import java.time.LocalTime;

public class RegistroDtoSalvar implements Serializable {

    private int idJornada;
    private LocalTime horarioRegistro;
    private String tipoRegistro;

    public RegistroDtoSalvar() {
    }

    public RegistroDtoSalvar(int idJornada, LocalTime horarioRegistro, String tipoRegistro) {
        this.idJornada = idJornada;
        this.horarioRegistro = horarioRegistro;
        this.tipoRegistro = tipoRegistro;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public LocalTime getHorarioRegistro() {
        return horarioRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

}
