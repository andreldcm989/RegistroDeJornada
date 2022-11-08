package com.controledejornada.registrodeponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{idPessoa}")
    public ResponseEntity<UsuarioDtoRegistros> buscarUsuarioPorPessoa(@PathVariable int idPessoa) {
        return ResponseEntity.ok().body(usuarioService.buscarUsuarioPorPessoa(idPessoa));
    }

    @GetMapping("/{idPessoa}/registros")
    public ResponseEntity<UsuarioDtoRegistros> registrosDiarioPorUsuario(
            @PathVariable int idPessoa, @RequestParam(value = "data") String data) {
        return ResponseEntity.ok().body(usuarioService.registrosDiarioPorUsuario(idPessoa, data));
    }

}
