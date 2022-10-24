package com.natalia.Blog.controller;

import com.natalia.Blog.entity.Client;
import com.natalia.Blog.exception.ClientException;
import com.natalia.Blog.request.ClientRequest;
import com.natalia.Blog.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientRequest clientRequest) throws ClientException {
        return new ResponseEntity<>(service.createNewClient(clientRequest), HttpStatus.CREATED);}

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
