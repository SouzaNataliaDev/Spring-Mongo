package com.natalia.Blog.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document(collection = "user")
public class Client {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String cell;
    private String email;
    @CreatedDate
    private LocalDateTime createAt;

    private List<Pedido> pedidos;

}
