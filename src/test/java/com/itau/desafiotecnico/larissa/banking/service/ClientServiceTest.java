package com.itau.desafiotecnico.larissa.banking.service;

import com.itau.desafiotecnico.larissa.banking.entity.Client;
import com.itau.desafiotecnico.larissa.banking.repository.ClientRepository;
import com.itau.desafiotecnico.larissa.banking.validation.ClientValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientValidation clientValidation;

    @InjectMocks
    private ClientService clientService;

    @Test
    void registerClient() {
        Client client = new Client(
                1L,
                "Larissa Cristina",
                "39053344705",
                "larissa@example.com",
                "senha123",
                "123456",
                "0001",
                new BigDecimal("1000.00")
        );
        when(clientRepository.save(any(Client.class)))
                .thenReturn(client);
        assertDoesNotThrow(() -> clientService.registerClient(client));

        verify(clientRepository).save(client);

    }

}