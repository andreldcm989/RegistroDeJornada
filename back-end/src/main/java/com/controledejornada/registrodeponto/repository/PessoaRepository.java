package com.controledejornada.registrodeponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledejornada.registrodeponto.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
