package com.controledejornada.registrodeponto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

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

        Pessoa p1 = new Pessoa("André", "01234567890", LocalDate.of(2000, 1, 20), "andre@gmail.com");
        Usuario u1 = new Usuario(p1, "andreldc", "suporte");
        Pessoa p2 = new Pessoa("Marilia", "990876654433", LocalDate.of(1998, 7, 30), "marilia@gmail.com");
        Usuario u2 = new Usuario(p2, "mariliafc", "teste");

        pessoaRepository.saveAll(Arrays.asList(p1, p2));
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        Registro registrou1r1 = new Registro(u1, LocalDateTime.now().minusDays(1).minusHours(6), "entrada");
        Registro registrou1r2 = new Registro(u1, LocalDateTime.now().minusDays(1).minusHours(2), "entrada");
        Registro registrou1r3 = new Registro(u1, LocalDateTime.now().minusHours(6), "entrada");
        Registro registrou1r4 = new Registro(u1, LocalDateTime.now().minusHours(2), "entrada");
        Registro registro2 = new Registro(u2, LocalDateTime.now(), "entrada");
        Registro registro4 = new Registro(u2, LocalDateTime.now(), "saida");
        u1.registrarPonto(registrou1r1);
        u1.registrarPonto(registrou1r2);
        u1.registrarPonto(registrou1r3);
        u1.registrarPonto(registrou1r4);
        u2.registrarPonto(registro2);
        u2.registrarPonto(registro4);

        registroRepository
                .saveAll(Arrays.asList(registrou1r1, registrou1r2, registrou1r3, registrou1r4, registro2, registro4));

        // List<Registro> registros = registroRepository.findByUsuario(u1.getId());

        // for (Registro r : registros) {
        // System.out.println(r.getHorarioRegistro() + ", usuário: " +
        // r.getUsuario().getId());
        // }
    }

}
