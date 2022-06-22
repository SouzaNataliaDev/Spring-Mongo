package com.natalia.Blog.persistence.entity;

import java.time.LocalDateTime;

public class Comments {
    private String text;
    private LocalDateTime date;
    private User author;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return author;
    }

    public void setUser(User user) {
        this.author = author;
    }
}
