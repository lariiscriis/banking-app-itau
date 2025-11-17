package com.itau.desafiotecnico.larissa.banking.exception;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(String message) {
        super(message);
    }

}
