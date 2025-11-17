package com.itau.desafiotecnico.larissa.banking.controller;

import com.itau.desafiotecnico.larissa.banking.entity.Client;
import com.itau.desafiotecnico.larissa.banking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> registerClient(@RequestBody Client client){
        Client registeredClient = clientService.registerClient(client);
        return ResponseEntity.ok((registeredClient));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Client> deposit(
            @PathVariable String accountNumber,
            @RequestParam BigDecimal amount ){

        Client client = clientService.deposit(accountNumber, amount);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long id){
        BigDecimal balance = clientService.getBalance(id);
        return ResponseEntity.ok(balance);
    }


    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Client> withdraw(
            @PathVariable String accountNumber,
            @RequestParam BigDecimal amount
    ){
        Client client = clientService.withdraw(accountNumber, amount);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestParam String fromAccountNumber,
            @RequestParam String toAccountNumber,
            @RequestParam BigDecimal amount
    ){
        clientService.transfer(fromAccountNumber, toAccountNumber, amount);
        return ResponseEntity.ok("Transferência realizada com sucesso!");
    }

}
