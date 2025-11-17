package com.itau.desafiotecnico.larissa.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    @CPF(message = "Invalid CPF")
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String agencyNumber;
    private BigDecimal balance = BigDecimal.ZERO;
}
