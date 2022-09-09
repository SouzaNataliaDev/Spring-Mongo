package com.natalia.Blog.service;

import com.natalia.Blog.domain.Client;
import com.natalia.Blog.exception.ClientException;
import com.natalia.Blog.repository.ClientRepository;
import com.natalia.Blog.request.ClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;


    public Client createNewClient(ClientRequest clientRequest) {

        var newClient = repository.findByEmail(clientRequest.getEmail());

        if (newClient.isEmpty()) {

            Client client = Client.builder()
                    .name(clientRequest.getName())
                    .cell(clientRequest.getCell())
                    .email(clientRequest.getEmail())
                    .pedidos(new ArrayList<>())
                    .createAt(LocalDateTime.now())
                    .build();
            repository.save(client);
            return client;
        }
        throw new ClientException("Cliente já esta cadastrado");

    }

    public Optional<Client> findById(String id) {
        return repository.findById(id);

    }

    public List<Client> getAll(){
        return repository.findAll();
    }


    public Optional<Client> deleteById(String id) {
        repository.deleteById(id);
        return Optional.empty();
    }
}
