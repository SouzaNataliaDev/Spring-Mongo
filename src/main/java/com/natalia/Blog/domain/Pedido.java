package com.natalia.Blog.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "posts")
public class Pedido {

    @Id
    private String id;

    private List<String> sabores;

}