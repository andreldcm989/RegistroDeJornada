package com.controledejornada.registrodeponto.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jornada implements Serializable {

    private int id;
    private LocalDate data;
    private Usuario usuario;
    private List<Registro> registros = new ArrayList<>();

    public Jornada() {
    }

    public Jornada(LocalDate data, Usuario usuario) {
        this.data = data;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void addRegistro(Registro registro) {
        registros.add(registro);
    }

    public void removeRegistro(Registro registro) {
        registros.remove(registro);
    }

}
