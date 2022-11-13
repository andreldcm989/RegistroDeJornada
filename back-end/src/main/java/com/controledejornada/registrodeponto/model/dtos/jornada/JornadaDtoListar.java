package com.controledejornada.registrodeponto.model.dtos.jornada;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoListar;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoListar;

public class JornadaDtoListar implements Serializable {

    private int id;
    private LocalDate data;
    private UsuarioDtoListar usuario;
    private LocalTime horasTrabalhadas;
    private List<RegistroDtoListar> registros;

    public JornadaDtoListar() {
    }

    public JornadaDtoListar(int id, LocalDate data, UsuarioDtoListar usuario, LocalTime horasTrabalhadas) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public JornadaDtoListar(Jornada jornada) {
        id = jornada.getId();
        data = jornada.getData();
        usuario = new UsuarioDtoListar(jornada.getUsuario());
        horasTrabalhadas = jornada.getHorasTrabalhadas();
        registros = jornada.getRegistros().stream().map(r -> new RegistroDtoListar(r)).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public UsuarioDtoListar getUsuario() {
        return usuario;
    }

    public LocalTime getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public List<RegistroDtoListar> getRegistros() {
        return registros;
    }
}
