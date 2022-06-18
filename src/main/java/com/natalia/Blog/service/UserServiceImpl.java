package com.natalia.Blog.service;

import com.natalia.Blog.model.UserRequest;
import com.natalia.Blog.model.UserResponse;
import com.natalia.Blog.persistence.entity.User;
import com.natalia.Blog.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserResponse create(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setBirthDate(request.getBirthDate());
        user.setSecondKey(UUID.randomUUID().toString());

        repository.save(user);
        return createResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        List<UserResponse> responses = new ArrayList<>();

        List<User> users = repository.findAll();
        if (!users.isEmpty()) {
            users.forEach(user -> responses.add(createResponse(user)));
        }

        return responses;
    }

    @Override
    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    private UserResponse createResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setSecondKey(user.getSecondKey());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setBirthDate(user.getBirthDate());

        return response;
    }

    private Optional<User> getById(String id) {
        return repository.findById(id);
    }
    public User save(User user){
        return repository.save(user);
}

    @Override
    public Optional<User> deleteById(String id) {
        repository.deleteById(id);
        return Optional.empty();
    }


}
