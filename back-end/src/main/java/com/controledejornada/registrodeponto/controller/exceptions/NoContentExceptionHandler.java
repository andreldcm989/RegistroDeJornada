package com.controledejornada.registrodeponto.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.controledejornada.registrodeponto.services.exceptions.NoContentException;

@ControllerAdvice
public class NoContentExceptionHandler {

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<StandardError> noContent(NoContentException exception, HttpServletRequest request) {
        String mensagem = "Nenhum resultado foi retornado";
        HttpStatus status = HttpStatus.NO_CONTENT;
        StandardError standardError = new StandardError(Instant.now(), status.value(), mensagem, exception.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
