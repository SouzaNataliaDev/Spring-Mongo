package com.natalia.Blog.service;

import com.natalia.Blog.model.UserRequest;
import com.natalia.Blog.model.UserResponse;
import com.natalia.Blog.persistence.entity.User;
import com.natalia.Blog.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponse create(UserRequest request);

    List<UserResponse> getAll();

    Optional<User> findById(String id);

    User save(User user);

    Optional <User>  deleteById(String id);
}
