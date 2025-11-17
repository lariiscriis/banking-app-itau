package com.itau.desafiotecnico.larissa.banking.repository;

import com.itau.desafiotecnico.larissa.banking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
