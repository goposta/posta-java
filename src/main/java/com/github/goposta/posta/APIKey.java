package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * APIKey is a machine credential. The secret itself is returned only once, by
 * [APIKeysService.Create]; afterwards only KeyPrefix identifies it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIKey {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    @JsonProperty("key_prefix")
    private String keyPrefix;

    private List<String> scopes;

    @JsonProperty("allowed_ips")
    private List<String> allowedIps;

    private boolean revoked;

    @JsonProperty("last_used_at")
    private String lastUsedAt;

    @JsonProperty("expires_at")
    private String expiresAt;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public String getName() { return name; }
    public String getKeyPrefix() { return keyPrefix; }
    public List<String> getScopes() { return scopes; }
    public List<String> getAllowedIps() { return allowedIps; }
    public boolean isRevoked() { return revoked; }
    public String getLastUsedAt() { return lastUsedAt; }
    public String getExpiresAt() { return expiresAt; }
    public String getCreatedAt() { return createdAt; }
}
