package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * FormNonce is a short-lived, single-use token for a form that requires one.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormNonce {

    private String nonce;

    @JsonProperty("issued_at")
    private long issuedAt;

    @JsonProperty("expires_at")
    private long expiresAt;

    public String getNonce() { return nonce; }
    public long getIssuedAt() { return issuedAt; }
    public long getExpiresAt() { return expiresAt; }
}
