package com.example.capacitacaospring.controllers;

import com.example.capacitacaospring.entities.Client;
import com.example.capacitacaospring.entities.ClientDto;
import com.example.capacitacaospring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{clientId}")
    public Client findByClientId(@PathVariable Integer clientId) {
        return clientService
                .findByClientId(clientId)
                .orElse(null);

    }

    @PutMapping
    public void update(@RequestBody final Client client) {
        this.clientService.save(client);
    }

    @PostMapping
    public void save(@RequestBody final Client client) {
        this.clientService.save(client);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable Integer clientId) {
        this.clientService.delete(clientId);
    }
}
