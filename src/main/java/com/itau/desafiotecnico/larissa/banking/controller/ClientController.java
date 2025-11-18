package com.itau.desafiotecnico.larissa.banking.controller;

import com.itau.desafiotecnico.larissa.banking.dto.ClientDTO;
import com.itau.desafiotecnico.larissa.banking.dto.LoginDTO;
import com.itau.desafiotecnico.larissa.banking.entity.Client;
import com.itau.desafiotecnico.larissa.banking.service.ClientService;
import com.itau.desafiotecnico.larissa.banking.service.JwtService;
import io.jsonwebtoken.Jwt;
import io.swagger.v3.oas.annotations.Operation;
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
    private final JwtService jwtService;

    @Operation(summary = "Cadastrar um novo cliente")
    @PostMapping("/register")
    public ResponseEntity<ClientDTO> registerClient(@RequestBody Client client){
        Client registeredClient = clientService.registerClient(client);
        ClientDTO clientDTO = new ClientDTO(
                registeredClient.getId(),
                registeredClient.getName(),
                registeredClient.getCpf(),
                registeredClient.getEmail(),
                registeredClient.getAccountNumber(),
                registeredClient.getAgencyNumber(),
                registeredClient.getBalance()
        );
        return ResponseEntity.ok((clientDTO));
    }

    @Operation(summary = "Login do cliente")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        String token = clientService.login(loginDTO.getEmail(), loginDTO.getPassword(), jwtService);
        return ResponseEntity.ok(token);
    }

    @Operation(summary = "Obter dados do cliente logado")
    @GetMapping("/me")
    public ResponseEntity<ClientDTO> getLoggedClient(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.substring(7);
        String email = jwtService.extractEmail(token);
        Client client = clientService.findByEmail(email);
        ClientDTO clientDTO = new ClientDTO(
                client.getId(),
                client.getName(),
                client.getCpf(),
                client.getEmail(),
                client.getAccountNumber(),
                client.getAgencyNumber(),
                client.getBalance()
        );
        return ResponseEntity.ok(clientDTO);
    }

    @Operation(summary = "Obter todos os clientes")
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @Operation(summary = "Depositar valor na conta do cliente")
    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<ClientDTO> deposit(@PathVariable String accountNumber, @RequestParam BigDecimal amount ){
        Client client = clientService.deposit(accountNumber, amount);
        return ResponseEntity.ok(new ClientDTO(
                client.getId(),
                client.getName(),
                client.getCpf(),
                client.getEmail(),
                client.getAccountNumber(),
                client.getAgencyNumber(),
                client.getBalance()
        ));
    }

    @Operation(summary = "Obter saldo da conta do cliente")
    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long id){
        BigDecimal balance = clientService.getBalance(id);
        return ResponseEntity.ok(balance);
    }


    @Operation(summary = "Sacar valor da conta do cliente")
    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<ClientDTO> withdraw(@PathVariable String accountNumber, @RequestParam BigDecimal amount
    ){
        Client client = clientService.withdraw(accountNumber, amount);
        return ResponseEntity.ok(new ClientDTO(
                client.getId(),
                client.getName(),
                client.getCpf(),
                client.getEmail(),
                client.getAccountNumber(),
                client.getAgencyNumber(),
                client.getBalance()
        ));
    }

    @Operation(summary = "Transferir valor entre contas")
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam String fromAccountNumber, @RequestParam String toAccountNumber, @RequestParam BigDecimal amount
    ){
        clientService.transfer(fromAccountNumber, toAccountNumber, amount);
        return ResponseEntity.ok("Transferência realizada com sucesso!");
    }

}
