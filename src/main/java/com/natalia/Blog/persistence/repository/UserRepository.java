package com.natalia.Blog.persistence.repository;

import com.natalia.Blog.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
