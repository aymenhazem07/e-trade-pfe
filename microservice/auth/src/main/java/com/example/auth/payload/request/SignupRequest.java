package com.example.auth.payload.request;

import java.util.Set;

public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> role;

    // Default constructor
    public SignupRequest() {}

    // Constructor with parameters
    public SignupRequest(String username, String email, String password, Set<String> role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for role
    public Set<String> getRole() {
        return role;
    }

    // Setter for role
    public void setRole(Set<String> role) {
        this.role = role;
    }
}