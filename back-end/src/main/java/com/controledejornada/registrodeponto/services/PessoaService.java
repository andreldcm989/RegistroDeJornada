package com.controledejornada.registrodeponto.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listarPessoas() {
        return repository.findAll();
    }

    public Pessoa buscarPessoaPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe pessoa com este id na base de dados."));
    }

    public Pessoa editarPessoa(Pessoa pessoa) {
        Pessoa p = repository.getReferenceById(pessoa.getId());
        BeanUtils.copyProperties(pessoa, p);
        repository.save(p);
        return p;
    }

    public void deletePessoa(int id) {
        Pessoa pessoa = buscarPessoaPorId(id);
        if (pessoa != null) {
            repository.deleteById(id);
        }
    }
}
