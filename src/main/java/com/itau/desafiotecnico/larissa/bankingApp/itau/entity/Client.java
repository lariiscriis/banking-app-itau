package com.itau.desafiotecnico.larissa.bankingApp.itau.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @CPF(message = "Invalid CPF")
    @NotBlank
    private String cpf;
    private String  email;
    private String  password;
    private String  accountNumber;
    private String branch;
    private BigDecimal balance = BigDecimal.ZERO;

}
