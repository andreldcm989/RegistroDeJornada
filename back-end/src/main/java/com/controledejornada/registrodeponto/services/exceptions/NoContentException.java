package com.controledejornada.registrodeponto.services.exceptions;

public class NoContentException extends RuntimeException {

    public NoContentException() {
    }

    public NoContentException(int id) {
        super("A busca não retornou nenhum item.");
    }

}
