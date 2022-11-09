package com.controledejornada.registrodeponto.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledejornada.registrodeponto.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    public List<Registro> findByUsuarioId(int id);

    public List<Registro> findByUsuarioIdAndHorarioRegistroBetween(int id, LocalDateTime inicio, LocalDateTime fim);

}
