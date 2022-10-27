package com.natalia.Blog.service;

import com.natalia.Blog.entity.Client;
import com.natalia.Blog.exception.ClientException;
import com.natalia.Blog.exception.NotFoundException;
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


    public Client createNewClient(ClientRequest clientRequest) throws ClientException {

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

    public Client findById(String id){

        var client = repository.findById(id);

        if (client.isEmpty()) {
            throw new NotFoundException("Cliente nao encontrado");
        }
        return client.get();
    }

    public List<Client> getAll() {
        return repository.findAll();
    }


    public void  deleteById(String id) {
       var client =  repository.findById(id);
       if(client.isEmpty()){
           throw new NotFoundException("Cliente nao encontrado, nao é possivel excluir");
       }
        repository.deleteById(id);
    }

}
