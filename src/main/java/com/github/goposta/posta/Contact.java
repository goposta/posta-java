package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Contact is the derived record of an address Posta has mailed, with its
 * delivery counters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String email;

    private String name;

    @JsonProperty("sent_count")
    private long sentCount;

    @JsonProperty("fail_count")
    private long failCount;

    @JsonProperty("last_sent_at")
    private String lastSentAt;

    @JsonProperty("created_at")
    private String createdAt;

    public Contact id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Contact userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public Contact workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Contact email(String email) { this.email = email; return this; }
    public String getEmail() { return email; }
    public Contact name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public Contact sentCount(long sentCount) { this.sentCount = sentCount; return this; }
    public long getSentCount() { return sentCount; }
    public Contact failCount(long failCount) { this.failCount = failCount; return this; }
    public long getFailCount() { return failCount; }
    public Contact lastSentAt(String lastSentAt) { this.lastSentAt = lastSentAt; return this; }
    public String getLastSentAt() { return lastSentAt; }
    public Contact createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
}
