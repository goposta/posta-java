package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Server is a shared SMTP server administered at the platform level and
 * offered to workspaces that have none of their own.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Server {

    private long id;

    private String name;

    private String host;

    private int port;

    private String username;

    private String encryption;

    @JsonProperty("security_mode")
    private String securityMode;

    @JsonProperty("allowed_domains")
    private List<String> allowedDomains;

    @JsonProperty("max_retries")
    private int maxRetries;

    private String status;

    @JsonProperty("sent_count")
    private long sentCount;

    @JsonProperty("failed_count")
    private long failedCount;

    @JsonProperty("validated_at")
    private String validatedAt;

    @JsonProperty("validation_error")
    private String validationError;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getId() { return id; }
    public String getName() { return name; }
    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getUsername() { return username; }
    public String getEncryption() { return encryption; }
    public String getSecurityMode() { return securityMode; }
    public List<String> getAllowedDomains() { return allowedDomains; }
    public int getMaxRetries() { return maxRetries; }
    public String getStatus() { return status; }
    public long getSentCount() { return sentCount; }
    public long getFailedCount() { return failedCount; }
    public String getValidatedAt() { return validatedAt; }
    public String getValidationError() { return validationError; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
