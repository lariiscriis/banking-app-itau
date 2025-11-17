package com.itau.desafiotecnico.larissa.banking.service;

import com.itau.desafiotecnico.larissa.banking.entity.Client;
import com.itau.desafiotecnico.larissa.banking.exception.ClientNotFoundException;
import com.itau.desafiotecnico.larissa.banking.repository.ClientRepository;
import com.itau.desafiotecnico.larissa.banking.validation.ClientValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientValidation clientValidation;

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }
    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client deposit(String accountNumber, BigDecimal amount) {
        clientValidation.validateBalanceTransfer(amount);
        Client client = findByAccountNumber(accountNumber);
        client.setBalance(client.getBalance().add(amount));
        return clientRepository.save(client);

    }

    @Transactional(readOnly = true)
    protected Client findByAccountNumber(String accountNumber) {
        return clientRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new ClientNotFoundException("Conta não encontrada: " + accountNumber));
    }

    public Client withdraw(String accountNumber, BigDecimal amount) {
        clientValidation.validateBalanceTransfer(amount);
        Client client = findByAccountNumber(accountNumber);
        client.setBalance(client.getBalance().subtract(amount));

        return clientRepository.save(client);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        clientValidation.validateBalanceTransfer(amount);

        Client originalFromClient = withdraw(fromAccountNumber, amount);
        Client originalToClient = deposit(toAccountNumber, amount);

    }
}
