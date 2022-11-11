package com.controledejornada.registrodeponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoEditar;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoListar;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoRegistros;
import com.controledejornada.registrodeponto.services.UsuarioService;

@RestController
@RequestMapping(value = "api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDtoListar>> listarUsuarios() {
        return ResponseEntity.ok().body(usuarioService.buscarUsuarios());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDtoRegistros> buscarUsuarioPorPessoa(@PathVariable int idUsuario) {
        return ResponseEntity.ok().body(usuarioService.buscarUsuarioPorId(idUsuario));
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDtoListar> editarUsuario(@PathVariable int idUsuario,
            @RequestBody UsuarioDtoEditar usuario) {
        return ResponseEntity.ok().body(usuarioService.editarUsuario(idUsuario, usuario));
    }

}
