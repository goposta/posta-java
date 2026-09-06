package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AuthUser is the account summary returned alongside a session token.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthUser {

    private long id;

    private String email;

    private String name;

    private String role;

    public long getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getRole() { return role; }
}
