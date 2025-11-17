package com.itau.desafiotecnico.larissa.banking.service;

import com.itau.desafiotecnico.larissa.banking.entity.Client;
import com.itau.desafiotecnico.larissa.banking.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }
    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
