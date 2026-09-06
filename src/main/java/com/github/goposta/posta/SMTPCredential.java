package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * SMTPCredential authenticates a client against Posta's own SMTP relay
 * listener. The password is returned once, at creation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SMTPCredential {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private long workspaceId;

    private String name;

    private String username;

    @JsonProperty("allowed_ips")
    private List<String> allowedIps;

    private boolean revoked;

    @JsonProperty("last_used_at")
    private String lastUsedAt;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getUserId() { return userId; }
    public long getWorkspaceId() { return workspaceId; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public List<String> getAllowedIps() { return allowedIps; }
    public boolean isRevoked() { return revoked; }
    public String getLastUsedAt() { return lastUsedAt; }
    public String getCreatedAt() { return createdAt; }
}
