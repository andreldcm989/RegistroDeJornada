package com.controledejornada.registrodeponto.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(int id) {
        super("Não encontramos nenhum registro com o id " + id + ".");
    }

}
