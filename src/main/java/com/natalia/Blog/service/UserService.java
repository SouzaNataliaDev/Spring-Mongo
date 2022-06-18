package com.natalia.Blog.service;

import com.natalia.Blog.model.UserRequest;
import com.natalia.Blog.model.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);

    List<UserResponse> getAll();

}
