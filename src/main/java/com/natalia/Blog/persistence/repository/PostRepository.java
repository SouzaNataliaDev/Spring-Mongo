package com.natalia.Blog.persistence.repository;

import com.natalia.Blog.persistence.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
