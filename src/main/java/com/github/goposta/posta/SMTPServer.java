package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * SMTPServer is an SMTP relay Posta delivers through. Passwords are never
 * returned by the API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SMTPServer {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    private String host;

    private int port;

    private String username;

    private String encryption;

    @JsonProperty("allowed_emails")
    private List<String> allowedEmails;

    @JsonProperty("max_retries")
    private int maxRetries;

    private String status;

    @JsonProperty("is_system")
    private boolean isSystem;

    @JsonProperty("validated_at")
    private String validatedAt;

    @JsonProperty("validation_error")
    private String validationError;

    @JsonProperty("created_at")
    private String createdAt;

    public SMTPServer id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public SMTPServer userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public SMTPServer workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public SMTPServer name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public SMTPServer host(String host) { this.host = host; return this; }
    public String getHost() { return host; }
    public SMTPServer port(int port) { this.port = port; return this; }
    public int getPort() { return port; }
    public SMTPServer username(String username) { this.username = username; return this; }
    public String getUsername() { return username; }
    public SMTPServer encryption(String encryption) { this.encryption = encryption; return this; }
    public String getEncryption() { return encryption; }
    public SMTPServer allowedEmails(List<String> allowedEmails) { this.allowedEmails = allowedEmails; return this; }
    public List<String> getAllowedEmails() { return allowedEmails; }
    public SMTPServer maxRetries(int maxRetries) { this.maxRetries = maxRetries; return this; }
    public int getMaxRetries() { return maxRetries; }
    public SMTPServer status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public SMTPServer isSystem(boolean isSystem) { this.isSystem = isSystem; return this; }
    public boolean isIsSystem() { return isSystem; }
    public SMTPServer validatedAt(String validatedAt) { this.validatedAt = validatedAt; return this; }
    public String getValidatedAt() { return validatedAt; }
    public SMTPServer validationError(String validationError) { this.validationError = validationError; return this; }
    public String getValidationError() { return validationError; }
    public SMTPServer createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
}
