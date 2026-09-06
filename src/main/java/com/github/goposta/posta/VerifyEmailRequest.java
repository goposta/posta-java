package com.github.goposta.posta;

/**
 * Request body for {@code POST /emails/verify}.
 */
public class VerifyEmailRequest {

    private String email;

    public VerifyEmailRequest() {
    }

    public VerifyEmailRequest(String email) {
        this.email = email;
    }

    public VerifyEmailRequest email(String email) { this.email = email; return this; }

    public String getEmail() { return email; }
}
