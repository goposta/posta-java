package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateUserRequest creates an account directly, bypassing self-registration.
 * Role is "admin" or "user".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest {

    private String email;

    private String name;

    private String password;

    private String role;

    public CreateUserRequest email(String email) { this.email = email; return this; }
    public String getEmail() { return email; }
    public CreateUserRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateUserRequest password(String password) { this.password = password; return this; }
    public String getPassword() { return password; }
    public CreateUserRequest role(String role) { this.role = role; return this; }
    public String getRole() { return role; }
}
