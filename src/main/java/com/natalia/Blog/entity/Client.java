package com.natalia.Blog.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document(collection = "user")
public class Client {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 11, max = 11)
    private String cell;
    @Email
    private String email;
    @CreatedDate
    private LocalDateTime createAt;

    private List<Pedido> pedidos;

}
