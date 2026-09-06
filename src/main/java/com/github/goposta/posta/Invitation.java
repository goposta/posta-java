package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Invitation is a pending offer of workspace membership.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invitation {

    private long id;

    @JsonProperty("workspace_id")
    private long workspaceId;

    /**
     * Workspace is the workspace's name, for showing an invitee what they
     * are being asked to join.
     */
    private String workspace;

    private String email;

    private String role;

    private String status;

    @JsonProperty("expires_at")
    private String expiresAt;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getWorkspaceId() { return workspaceId; }
    public String getWorkspace() { return workspace; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
    public String getExpiresAt() { return expiresAt; }
    public String getCreatedAt() { return createdAt; }
}
