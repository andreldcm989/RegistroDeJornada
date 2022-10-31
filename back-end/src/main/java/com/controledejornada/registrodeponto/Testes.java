package com.controledejornada.registrodeponto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.repository.PessoaRepository;
import com.controledejornada.registrodeponto.repository.RegistroRepository;
import com.controledejornada.registrodeponto.repository.UsuarioRepository;

@Configuration
public class Testes implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa("André", "01234567890", "teste@gmail.com");
        Usuario u1 = new Usuario(p1, "andreldc", "suporte");

        pessoaRepository.save(p1);
        usuarioRepository.save(u1);

        Registro registro1 = new Registro(u1, LocalDateTime.now(), "entrada");
        Registro registro2 = new Registro(u1, LocalDateTime.now(), "entrada");
        Registro registro3 = new Registro(u1, LocalDateTime.now(), "entrada");
        Registro registro4 = new Registro(u1, LocalDateTime.now(), "entrada");
        u1.registrarPonto(registro1);
        u1.registrarPonto(registro2);
        u1.registrarPonto(registro3);
        u1.registrarPonto(registro4);

        registroRepository.saveAll(Arrays.asList(registro1, registro2, registro3, registro4));

        List<Registro> registros = registroRepository.findAllByUsuario(u1.getId());
        System.out.println(registros);
    }

}
