package com.controledejornada.registrodeponto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controledejornada.registrodeponto.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    public List<Registro> findAllByUsuario(int id);

}
