package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User is an account on the platform.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private long id;

    private String email;

    private String name;

    private String role;

    private boolean active;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("auth_method")
    private String authMethod;

    @JsonProperty("two_factor_enabled")
    private boolean twoFactorEnabled;

    @JsonProperty("require_verified_domain")
    private boolean requireVerifiedDomain;

    @JsonProperty("email_verified_at")
    private String emailVerifiedAt;

    @JsonProperty("last_login_at")
    private String lastLoginAt;

    @JsonProperty("scheduled_deletion_at")
    private String scheduledDeletionAt;

    @JsonProperty("default_workspace_id")
    private Long defaultWorkspaceId;

    @JsonProperty("plan_id")
    private Long planId;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public boolean isActive() { return active; }
    public String getAvatarUrl() { return avatarUrl; }
    public String getAuthMethod() { return authMethod; }
    public boolean isTwoFactorEnabled() { return twoFactorEnabled; }
    public boolean isRequireVerifiedDomain() { return requireVerifiedDomain; }
    public String getEmailVerifiedAt() { return emailVerifiedAt; }
    public String getLastLoginAt() { return lastLoginAt; }
    public String getScheduledDeletionAt() { return scheduledDeletionAt; }
    public Long getDefaultWorkspaceId() { return defaultWorkspaceId; }
    public Long getPlanId() { return planId; }
    public String getCreatedAt() { return createdAt; }
}
