package com.controledejornada.registrodeponto.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledejornada.registrodeponto.model.Jornada;

public interface JornadaRepository extends JpaRepository<Jornada, Integer> {

    List<Jornada> findByUsuarioIdAndDataBetween(int usuarioId, LocalDate inicio, LocalDate fim);

    List<Jornada> findByUsuarioId(int id);

    Optional<Jornada> findByIdAndUsuarioId(int id, int usuarioId);
}
