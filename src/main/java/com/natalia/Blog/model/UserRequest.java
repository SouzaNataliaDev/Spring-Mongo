package com.natalia.Blog.model;

import com.natalia.Blog.persistence.entity.Comments;
import com.natalia.Blog.persistence.entity.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRequest {
    private String name;
    private LocalDate birthDate;

    private String email;

    private List<Post> posts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
