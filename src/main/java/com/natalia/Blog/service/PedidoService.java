package com.natalia.Blog.service;

import com.natalia.Blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PostRepository repository;

    List<String> sabores = new ArrayList<>(List.of("Mussarela", "Calabresa", "Bacon", "Frango com catupiry"));



}

