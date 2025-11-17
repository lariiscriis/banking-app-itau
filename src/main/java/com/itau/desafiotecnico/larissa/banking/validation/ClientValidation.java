package com.itau.desafiotecnico.larissa.banking.validation;

import com.itau.desafiotecnico.larissa.banking.exception.InvalidAmountException;
import com.itau.desafiotecnico.larissa.banking.exception.InvalidCpfException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ClientValidation {

    public void validateBalanceTransfer(BigDecimal amount){
        if(amount.compareTo((BigDecimal.ZERO) ) <= 0){
            throw new InvalidAmountException("Você não pode transferir um valor menor ou igual a zero.");
        }
    }
    public void validateCpf(String cpf){
        if (cpf == null || cpf.length() != 11){
            throw new InvalidCpfException("O CPF deve ter 11 dígitos.");
        }
    }


}
