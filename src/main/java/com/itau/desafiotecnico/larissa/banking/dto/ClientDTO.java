package com.itau.desafiotecnico.larissa.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String accountNumber;
    private String agencyNumber;
    private BigDecimal balance;
}
