package com.example.librarymanagementsystem;

public class User {
    private String fullName;
    private String username;
    private String email;

    public User(String fullName, String username, String email) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

