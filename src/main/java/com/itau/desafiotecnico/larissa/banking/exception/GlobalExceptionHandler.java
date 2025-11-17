package com.itau.desafiotecnico.larissa.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Object> handleClientNotFound(ClientNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildError(ex.getMessage(), 404));
    }

    @ExceptionHandler(DuplicateClientException.class)
    public ResponseEntity<Object> handleDuplicate(DuplicateClientException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(buildError(ex.getMessage(), 409));
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<Object> handleInvalidAmount(InvalidAmountException ex){
        return ResponseEntity.badRequest()
                .body(buildError(ex.getMessage(), 400));
    }

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<Object> handleInvalidCpf(InvalidCpfException ex){
        return ResponseEntity.badRequest()
                .body(buildError(ex.getMessage(), 400));
    }

    private Map<String, Object> buildError(String msg, int status){
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("status", status);
        error.put("error", msg);
        error.put("timestamp", LocalDateTime.now());
        return error;
    }
}

