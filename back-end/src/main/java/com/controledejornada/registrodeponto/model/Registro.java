package com.controledejornada.registrodeponto.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_registro")
public class Registro implements Serializable, Comparable<Registro> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JsonIgnore
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

    public void setHorarioRegistro(LocalTime horarioRegistro) {
        this.horarioRegistro = horarioRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Override
    public int compareTo(Registro r) {
        return this.getHorarioRegistro().compareTo(r.getHorarioRegistro());
    }

}
