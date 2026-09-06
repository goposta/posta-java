package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Suppression blocks delivery to an address. Kind is one of "bounce",
 * "complaint", "unsubscribe", "manual".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Suppression {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String email;

    private String kind;

    private String reason;

    @JsonProperty("list_id")
    private Long listId;

    @JsonProperty("created_at")
    private String createdAt;

    public Suppression id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Suppression userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public Suppression workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Suppression email(String email) { this.email = email; return this; }
    public String getEmail() { return email; }
    public Suppression kind(String kind) { this.kind = kind; return this; }
    public String getKind() { return kind; }
    public Suppression reason(String reason) { this.reason = reason; return this; }
    public String getReason() { return reason; }
    public Suppression listId(Long listId) { this.listId = listId; return this; }
    public Long getListId() { return listId; }
    public Suppression createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
}
