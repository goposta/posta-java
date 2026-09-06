package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AdminDomain is a domain as seen across every workspace, with its owner.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminDomain {

    private long id;

    private String domain;

    @JsonProperty("owner_id")
    private long ownerId;

    @JsonProperty("owner_email")
    private String ownerEmail;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("workspace_name")
    private String workspaceName;

    @JsonProperty("ownership_verified")
    private boolean ownershipVerified;

    @JsonProperty("spf_verified")
    private boolean spfVerified;

    @JsonProperty("dkim_verified")
    private boolean dkimVerified;

    @JsonProperty("dmarc_verified")
    private boolean dmarcVerified;

    @JsonProperty("fully_verified")
    private boolean fullyVerified;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getDomain() { return domain; }
    public long getOwnerId() { return ownerId; }
    public String getOwnerEmail() { return ownerEmail; }
    public Long getWorkspaceId() { return workspaceId; }
    public String getWorkspaceName() { return workspaceName; }
    public boolean isOwnershipVerified() { return ownershipVerified; }
    public boolean isSpfVerified() { return spfVerified; }
    public boolean isDkimVerified() { return dkimVerified; }
    public boolean isDmarcVerified() { return dmarcVerified; }
    public boolean isFullyVerified() { return fullyVerified; }
    public String getCreatedAt() { return createdAt; }
}
