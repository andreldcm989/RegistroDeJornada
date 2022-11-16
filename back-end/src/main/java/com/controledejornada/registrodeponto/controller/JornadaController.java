package com.controledejornada.registrodeponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(value = "inicio", required = false) String inicio,
            @RequestParam(value = "fim", required = false) String fim) {
        return ResponseEntity.ok().body(jornadaService.listarJornadasPorUsuarioEData(usuarioId, inicio, fim));
    }

    @GetMapping("/{usuarioId}/{jornadaId}")
    public ResponseEntity<JornadaDtoListar> listarJornadaPorId(@PathVariable int usuarioId,
            @PathVariable int jornadaId) {
        return ResponseEntity.ok().body(jornadaService.buscarJornadaPorIdEUsuario(jornadaId, usuarioId));
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity<Object> adicionarRegistro(@PathVariable int idUsuario, @RequestParam String data,
            @RequestBody RegistroDtoSalvar registro) {
        jornadaService.adicionarRegistro(data, idUsuario, registro);
        return ResponseEntity.ok().body("Registro inserido com sucesso!");
    }

    @PutMapping("/{usuarioId}/{jornadaId}")
    public ResponseEntity<JornadaDtoListar> editarRegistro(@PathVariable int usuarioId, @PathVariable int jornadaId,
            @RequestParam int idRegistro,
            @RequestBody RegistroDtoSalvar registro) {
        return ResponseEntity.ok().body(jornadaService.editarRegistro(jornadaId, idRegistro, registro));
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity<Object> excluirJornada(@PathVariable int idJornada) {
        jornadaService.excluirJornada(idJornada);
        return ResponseEntity.ok().body("Jornada excluída com sucesso!");
    }

}
