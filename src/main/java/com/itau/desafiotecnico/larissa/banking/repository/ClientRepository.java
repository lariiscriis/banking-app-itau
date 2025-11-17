package com.itau.desafiotecnico.larissa.banking.repository;

import com.itau.desafiotecnico.larissa.banking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByAccountNumber(String accountNumber);
    Optional<Client> findByEmail(String email);
    boolean existsByAccountNumber(String accountNumber);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

}
