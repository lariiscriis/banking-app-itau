package com.itau.desafiotecnico.larissa.banking.exception;

import org.aspectj.bridge.IMessage;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
