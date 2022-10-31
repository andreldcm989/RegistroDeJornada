package com.controledejornada.registrodeponto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.controledejornada.registrodeponto.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_registro WHERE usuario_id = :id")
    public List<Registro> findByUsuario(int id);

}
