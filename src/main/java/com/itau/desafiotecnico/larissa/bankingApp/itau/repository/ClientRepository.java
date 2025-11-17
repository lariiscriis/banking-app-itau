package com.itau.desafiotecnico.larissa.bankingApp.itau.repository;

import com.itau.desafiotecnico.larissa.bankingApp.itau.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
