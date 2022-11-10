package com.controledejornada.registrodeponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledejornada.registrodeponto.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {

}
