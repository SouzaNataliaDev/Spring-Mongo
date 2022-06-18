package com.natalia.Blog.controller;

import com.natalia.Blog.model.UserRequest;
import com.natalia.Blog.model.UserResponse;
import com.natalia.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @Autowired
        private UserService service;

        @PostMapping
        public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
            return ResponseEntity.ok(service.create(request));
        }

        @GetMapping
        public ResponseEntity<List<UserResponse>> getAll(){
            return ResponseEntity.ok(service.getAll());
        }
    }
