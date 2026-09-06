package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * UpdateSMTPServerRequest changes an SMTP relay. Omit Password to keep the
 * stored one.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateSMTPServerRequest {

    private String name;

    private String host;

    private int port;

    private String username;

    private String password;

    private String encryption;

    private String status;

    @JsonProperty("allowed_emails")
    private List<String> allowedEmails;

    @JsonProperty("max_retries")
    private Integer maxRetries;

    public UpdateSMTPServerRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateSMTPServerRequest host(String host) { this.host = host; return this; }
    public String getHost() { return host; }
    public UpdateSMTPServerRequest port(int port) { this.port = port; return this; }
    public int getPort() { return port; }
    public UpdateSMTPServerRequest username(String username) { this.username = username; return this; }
    public String getUsername() { return username; }
    public UpdateSMTPServerRequest password(String password) { this.password = password; return this; }
    public String getPassword() { return password; }
    public UpdateSMTPServerRequest encryption(String encryption) { this.encryption = encryption; return this; }
    public String getEncryption() { return encryption; }
    public UpdateSMTPServerRequest status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public UpdateSMTPServerRequest allowedEmails(List<String> allowedEmails) { this.allowedEmails = allowedEmails; return this; }
    public List<String> getAllowedEmails() { return allowedEmails; }
    public UpdateSMTPServerRequest maxRetries(Integer maxRetries) { this.maxRetries = maxRetries; return this; }
    public Integer getMaxRetries() { return maxRetries; }
}
