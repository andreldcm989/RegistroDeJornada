package com.controledejornada.registrodeponto.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_jornada")
public class Jornada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private LocalTime horasTrabalhadas;

    @OneToMany(mappedBy = "jornada", cascade = CascadeType.ALL)
    private List<Registro> registros = new ArrayList<>();

    public Jornada() {
    }

    public Jornada(LocalDate data, Usuario usuario) {
        this.data = data;
        this.usuario = usuario;
        calcularHorasTrabalhadas();
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

    public LocalTime getHorasTrabalhadas() {
        return horasTrabalhadas;
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

    public LocalTime calcularHorasTrabalhadas() {
        LocalTime total = LocalTime.of(0, 0, 0);
        Collections.sort(registros);
        for (int i = 0; i < registros.size(); i++) {
            if (i % 2 != 0) {
                total = total.plus(
                        ChronoUnit.MILLIS.between(registros.get(i - 1).getHorarioRegistro(),
                                registros.get(i).getHorarioRegistro()),
                        ChronoUnit.MILLIS);
            }
        }
        horasTrabalhadas = total;
        return total;
    }

}
