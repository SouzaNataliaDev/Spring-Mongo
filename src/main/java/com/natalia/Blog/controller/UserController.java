package com.natalia.Blog.controller;

import com.natalia.Blog.model.UserRequest;
import com.natalia.Blog.model.UserResponse;
import com.natalia.Blog.persistence.entity.User;
import com.natalia.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        return service.findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        Optional<User> op = service.findById(id);
        if (op.isPresent()) {
            service.findById(id);
            return ResponseEntity.ok(op.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
    @PutMapping
    public ResponseEntity<User> update (@RequestBody User user){
        return ResponseEntity.ok(service.save(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        Optional<User> op = service.findById(id);
        if (op.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}