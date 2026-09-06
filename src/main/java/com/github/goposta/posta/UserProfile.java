package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UserProfile is the signed-in account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {

    private long id;

    private String email;

    private String name;

    private String role;

    @JsonProperty("two_factor_enabled")
    private boolean twoFactorEnabled;

    @JsonProperty("email_verified_at")
    private String emailVerifiedAt;

    @JsonProperty("email_verification_required")
    private boolean emailVerificationRequired;

    @JsonProperty("require_verified_domain")
    private boolean requireVerifiedDomain;

    @JsonProperty("default_workspace_id")
    private Long defaultWorkspaceId;

    @JsonProperty("personal_workspace_id")
    private Long personalWorkspaceId;

    /**
     * ScheduledDeletionAt is set once deletion has been requested, and
     * cleared by [UsersService.CancelDeletion].
     */
    @JsonProperty("scheduled_deletion_at")
    private String scheduledDeletionAt;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public boolean isTwoFactorEnabled() { return twoFactorEnabled; }
    public String getEmailVerifiedAt() { return emailVerifiedAt; }
    public boolean isEmailVerificationRequired() { return emailVerificationRequired; }
    public boolean isRequireVerifiedDomain() { return requireVerifiedDomain; }
    public Long getDefaultWorkspaceId() { return defaultWorkspaceId; }
    public Long getPersonalWorkspaceId() { return personalWorkspaceId; }
    public String getScheduledDeletionAt() { return scheduledDeletionAt; }
    public String getCreatedAt() { return createdAt; }
}
