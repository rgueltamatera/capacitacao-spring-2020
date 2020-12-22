package com.example.capacitacaospring.services;

import com.example.capacitacaospring.entities.Client;
import com.example.capacitacaospring.entities.ClientDto;
import com.example.capacitacaospring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void save(final Client client) {
        this.clientRepository.save(client);
    }

    public void delete(Integer clientId) {
        this.clientRepository.deleteById(clientId);
    }

    public List<ClientDto> findAll() {
        return clientRepository
                .findAll()
                .stream()
                .filter(client -> client.getFirstName().equals("Gabriel"))
                .map(client -> new ClientDto(client.getClientId(), client.getFirstName()))
                .collect(Collectors.toList());
    }

    public Optional<Client> findByClientId(Integer clientId){
        return this.clientRepository.findById(clientId);
    }
}
