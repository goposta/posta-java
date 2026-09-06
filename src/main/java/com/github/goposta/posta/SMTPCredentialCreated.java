package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SMTPCredentialCreated is the one-time result of creating a relay credential.
 * Password is shown only here and cannot be retrieved again. Host and Port
 * point at Posta's relay listener, ready to paste into an SMTP client.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SMTPCredentialCreated {

    private long id;

    private String name;

    private String username;

    private String password;

    private String host;

    private int port;

    private String message;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getMessage() { return message; }
    public String getCreatedAt() { return createdAt; }
}
