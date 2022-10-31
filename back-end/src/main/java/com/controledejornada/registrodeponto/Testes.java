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
        Pessoa p2 = new Pessoa("André", "01234567890", "teste@gmail.com");
        Usuario u2 = new Usuario(p1, "andreldc", "suporte");

        pessoaRepository.saveAll(Arrays.asList(p1, p2));
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        Registro registro1 = new Registro(u1, LocalDateTime.now(), "entrada");
        Registro registro2 = new Registro(u2, LocalDateTime.now(), "entrada");
        Registro registro3 = new Registro(u1, LocalDateTime.now(), "saida");
        Registro registro4 = new Registro(u2, LocalDateTime.now(), "saida");
        u1.registrarPonto(registro1);
        u2.registrarPonto(registro2);
        u1.registrarPonto(registro3);
        u2.registrarPonto(registro4);

        registroRepository.saveAll(Arrays.asList(registro1, registro2, registro3, registro4));

        List<Registro> registros = registroRepository.findByUsuario(u1.getId());

        for (Registro r : registros) {
            System.out.println(r.getHorarioRegistro() + ", usuário: " + r.getUsuario().getId());
        }
    }

}
