package com.controledejornada.registrodeponto.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "jornada_id")
    private Jornada jornada;
    private LocalTime horarioRegistro;
    private String tipoRegistro;

    public Registro() {
    }

    public Registro(Jornada jornada, LocalTime horarioRegistro, String tipoRegistro) {
        this.jornada = jornada;
        this.horarioRegistro = horarioRegistro;
        this.tipoRegistro = tipoRegistro;
    }

    public int getId() {
        return id;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public LocalTime getHorarioRegistro() {
        return horarioRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

}
