package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CreateSMTPServerRequest registers an SMTP relay. Encryption is one of
 * "none", "tls", or "starttls".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSMTPServerRequest {

    private String name;

    private String host;

    private int port;

    private String username;

    private String password;

    private String encryption;

    /**
     * AllowedEmails restricts which From addresses may use this server.
     */
    @JsonProperty("allowed_emails")
    private List<String> allowedEmails;

    @JsonProperty("max_retries")
    private int maxRetries;

    public CreateSMTPServerRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateSMTPServerRequest host(String host) { this.host = host; return this; }
    public String getHost() { return host; }
    public CreateSMTPServerRequest port(int port) { this.port = port; return this; }
    public int getPort() { return port; }
    public CreateSMTPServerRequest username(String username) { this.username = username; return this; }
    public String getUsername() { return username; }
    public CreateSMTPServerRequest password(String password) { this.password = password; return this; }
    public String getPassword() { return password; }
    public CreateSMTPServerRequest encryption(String encryption) { this.encryption = encryption; return this; }
    public String getEncryption() { return encryption; }
    public CreateSMTPServerRequest allowedEmails(List<String> allowedEmails) { this.allowedEmails = allowedEmails; return this; }
    public List<String> getAllowedEmails() { return allowedEmails; }
    public CreateSMTPServerRequest maxRetries(int maxRetries) { this.maxRetries = maxRetries; return this; }
    public int getMaxRetries() { return maxRetries; }
}
