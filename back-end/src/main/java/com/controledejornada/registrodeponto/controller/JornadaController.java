package com.controledejornada.registrodeponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.dtos.jornada.JornadaDtoListar;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoSalvar;
import com.controledejornada.registrodeponto.services.JornadaService;

@RestController
@RequestMapping(value = "api/jornadas")
public class JornadaController {

    @Autowired
    private JornadaService jornadaService;

    @GetMapping
    public ResponseEntity<List<JornadaDtoListar>> listarJornadas() {
        return ResponseEntity.ok().body(jornadaService.listarJornadas());
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<JornadaDtoListar>> listarJornadasPorUsuarioEData(@PathVariable int usuarioId,
            @RequestParam(value = "inicio") String inicio, @RequestParam(value = "fim") String fim) {
        return ResponseEntity.ok().body(jornadaService.listarJornadasPorUsuarioEData(usuarioId, inicio, fim));
    }

    @GetMapping("/{usuarioId}/{jornadaId}")
    public ResponseEntity<Jornada> listarJornadaPorId(@PathVariable int usuarioId, @PathVariable int jornadaId) {
        return ResponseEntity.ok().body(jornadaService.buscarJornadaPorIdEUsuario(jornadaId, usuarioId));
    }

    // @PostMapping("/{usuarioId}/{jornadaId}/addRegistro")
    // public ResponseEntity<Registro> adicionarRegistro(@PathVariable int
    // usuarioId, @PathVariable int jornadaId,
    // @RequestBody RegistroDtoSalvar registro) {
    // return ResponseEntity.ok().body(jornadaService.adicionarRegistro(usuarioId,
    // jornadaId, registro));
    // }
}
