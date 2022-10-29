package com.controledejornada.registrodeponto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledejornada.registrodeponto.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, UUID> {

}
