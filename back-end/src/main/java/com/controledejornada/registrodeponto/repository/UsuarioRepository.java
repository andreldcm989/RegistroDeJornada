package com.controledejornada.registrodeponto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledejornada.registrodeponto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByPessoaId(int id);

}
