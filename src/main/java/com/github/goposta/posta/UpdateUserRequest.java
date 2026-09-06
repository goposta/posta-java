package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateUserRequest changes an account's role or standing. Nil fields are left
 * unchanged.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest {

    private String role;

    private Boolean active;

    @JsonProperty("email_verified")
    private Boolean emailVerified;

    public UpdateUserRequest role(String role) { this.role = role; return this; }
    public String getRole() { return role; }
    public UpdateUserRequest active(Boolean active) { this.active = active; return this; }
    public Boolean getActive() { return active; }
    public UpdateUserRequest emailVerified(Boolean emailVerified) { this.emailVerified = emailVerified; return this; }
    public Boolean getEmailVerified() { return emailVerified; }
}
