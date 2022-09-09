package com.natalia.Blog.controller;

import com.natalia.Blog.domain.Client;
import com.natalia.Blog.request.ClientRequest;
import com.natalia.Blog.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable String id) {
        var optionalClient = service.findById(id);
        if (optionalClient.isPresent()) {
         return ResponseEntity.ok().body(optionalClient.get());
        }
        return ResponseEntity.notFound().build();
        //ajustar para retornar notfound em vez de erro 500
    }

    @PostMapping("/new")
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        var client = service.createNewClient(clientRequest);
        return ResponseEntity.ok(client);
    }

}