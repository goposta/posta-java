package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UnsubscribeList is a named opt-out list referenced by List-Unsubscribe
 * headers. A recipient who unsubscribes is suppressed on this list alone.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsubscribeList {

    private long id;

    private String uuid;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    @JsonProperty("public_name")
    private String publicName;

    private String description;

    private boolean active;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public UnsubscribeList id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public UnsubscribeList uuid(String uuid) { this.uuid = uuid; return this; }
    public String getUuid() { return uuid; }
    public UnsubscribeList userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public UnsubscribeList workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public UnsubscribeList name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UnsubscribeList publicName(String publicName) { this.publicName = publicName; return this; }
    public String getPublicName() { return publicName; }
    public UnsubscribeList description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public UnsubscribeList active(boolean active) { this.active = active; return this; }
    public boolean isActive() { return active; }
    public UnsubscribeList createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public UnsubscribeList updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
