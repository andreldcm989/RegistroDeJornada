package com.controledejornada.registrodeponto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.controledejornada.registrodeponto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_usuario WHERE pessoa_id = :id")
    Optional<Usuario> findUsuarioByPessoa(int id);

}
