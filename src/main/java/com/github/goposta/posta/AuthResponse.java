package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AuthResponse is a successful sign-in: the session token and who it belongs
 * to. Pass Token to [NewWithToken] to reach account-level endpoints.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {

    private String token;

    private AuthUser user;

    public String getToken() { return token; }
    public AuthUser getUser() { return user; }
}
