package com.itau.desafiotecnico.larissa.banking.controller;

import com.itau.desafiotecnico.larissa.banking.entity.Client;
import com.itau.desafiotecnico.larissa.banking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
