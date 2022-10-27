package com.natalia.Blog.repository;


import com.natalia.Blog.entity.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Pedido, String>{

}