package com.controledejornada.registrodeponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoListar;
import com.controledejornada.registrodeponto.services.RegistroService;

@RestController
@RequestMapping("api/registros")
public class RegistrosController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/{id}")
    public ResponseEntity<List<RegistroDtoListar>> listarRegistrosPorUsuario(@PathVariable int id) {
        return ResponseEntity.ok().body(registroService.listarRegistrosPorUsuario(id));
    }

    @GetMapping("/{id}/filtro")
    public ResponseEntity<List<RegistroDtoListar>> listarRegistrosComFiltro(@PathVariable int id,
            @RequestParam(value = "inicio") String inicio, @RequestParam(value = "fim") String fim) {
        return ResponseEntity.ok().body(registroService.listarRegistrosComFiltro(id, inicio, fim));
    }
}
