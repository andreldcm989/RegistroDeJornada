package com.controledejornada.registrodeponto.model.dtos.registro;

import java.io.Serializable;
import java.time.LocalTime;

import com.controledejornada.registrodeponto.model.Registro;

public class RegistroDtoListar implements Serializable {

    private int id;
    private int idJornada;
    private LocalTime horarioRegistro;
    private String tipoRegistro;

    public RegistroDtoListar() {
    }

    public RegistroDtoListar(int id, int idJornada, LocalTime horarioRegistro, String tipoRegistro) {
        this.id = id;
        this.idJornada = idJornada;
        this.horarioRegistro = horarioRegistro;
        this.tipoRegistro = tipoRegistro;
    }

    public RegistroDtoListar(Registro registro) {
        id = registro.getId();
        idJornada = registro.getJornada().getId();
        horarioRegistro = registro.getHorarioRegistro();
        tipoRegistro = registro.getTipoRegistro();
    }

    public int getId() {
        return id;
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
