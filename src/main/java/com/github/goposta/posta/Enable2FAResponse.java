package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Enable2FAResponse carries the TOTP secret to enrol an authenticator app.
 * URL is an otpauth:// URI, usually rendered as a QR code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Enable2FAResponse {

    private String secret;

    private String url;

    public String getSecret() { return secret; }
    public String getUrl() { return url; }
}
