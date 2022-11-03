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
import org.springframework.web.bind.annotation.RestController;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoListar;
import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoSalvar;
import com.controledejornada.registrodeponto.services.PessoaService;

@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDtoListar>> listarPessoas() {
        return ResponseEntity.ok().body(pessoaService.listarPessoas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable int id) {
        return ResponseEntity.ok().body(pessoaService.buscarPessoaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPessoa(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(pessoaService.excluirPessoa(id));
    }

    @PostMapping
    public ResponseEntity<PessoaDtoListar> salvarPessoa(@RequestBody PessoaDtoSalvar pessoa) {
        return ResponseEntity.ok().body(pessoaService.salvarPessoa(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDtoListar> editarPessoa(@PathVariable int id, @RequestBody PessoaDtoListar pessoa) {
        return ResponseEntity.ok().body(pessoaService.editarPessoa(id, pessoa));
    }
}
