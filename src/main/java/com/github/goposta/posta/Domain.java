package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Domain is a sending domain and the state of its DNS verification. Posta will
 * only send from a domain whose ownership has been verified when the workspace
 * requires it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Domain {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String domain;

    @JsonProperty("verification_token")
    private String verificationToken;

    @JsonProperty("ownership_verified")
    private boolean ownershipVerified;

    @JsonProperty("spf_verified")
    private boolean spfVerified;

    @JsonProperty("dkim_verified")
    private boolean dkimVerified;

    @JsonProperty("dmarc_verified")
    private boolean dmarcVerified;

    @JsonProperty("created_at")
    private String createdAt;

    public Domain id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Domain userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public Domain workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Domain domain(String domain) { this.domain = domain; return this; }
    public String getDomain() { return domain; }
    public Domain verificationToken(String verificationToken) { this.verificationToken = verificationToken; return this; }
    public String getVerificationToken() { return verificationToken; }
    public Domain ownershipVerified(boolean ownershipVerified) { this.ownershipVerified = ownershipVerified; return this; }
    public boolean isOwnershipVerified() { return ownershipVerified; }
    public Domain spfVerified(boolean spfVerified) { this.spfVerified = spfVerified; return this; }
    public boolean isSpfVerified() { return spfVerified; }
    public Domain dkimVerified(boolean dkimVerified) { this.dkimVerified = dkimVerified; return this; }
    public boolean isDkimVerified() { return dkimVerified; }
    public Domain dmarcVerified(boolean dmarcVerified) { this.dmarcVerified = dmarcVerified; return this; }
    public boolean isDmarcVerified() { return dmarcVerified; }
    public Domain createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
}
