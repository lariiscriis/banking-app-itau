package com.itau.desafiotecnico.larissa.banking.exception;

public class DuplicateClientException extends RuntimeException {
    public DuplicateClientException(String message) {
        super(message);
    }
}
