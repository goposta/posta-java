package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * WorkspaceSettings holds the workspace's sending defaults and policy.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceSettings {

    @JsonProperty("workspace_id")
    private long workspaceId;

    /**
     * DefaultSenderEmail and DefaultSenderName fill in a send's From when it
     * omits one.
     */
    @JsonProperty("default_sender_email")
    private String defaultSenderEmail;

    @JsonProperty("default_sender_name")
    private String defaultSenderName;

    /**
     * RequireVerifiedDomain refuses sends from a domain that has not passed
     * DNS verification.
     */
    @JsonProperty("require_verified_domain")
    private boolean requireVerifiedDomain;

    /**
     * BounceAutoSuppress adds a hard-bounced address to the suppression list
     * automatically.
     */
    @JsonProperty("bounce_auto_suppress")
    private boolean bounceAutoSuppress;

    @JsonProperty("webhook_retry_count")
    private int webhookRetryCount;

    @JsonProperty("api_key_expiry_days")
    private int apiKeyExpiryDays;

    private String timezone;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getWorkspaceId() { return workspaceId; }
    public String getDefaultSenderEmail() { return defaultSenderEmail; }
    public String getDefaultSenderName() { return defaultSenderName; }
    public boolean isRequireVerifiedDomain() { return requireVerifiedDomain; }
    public boolean isBounceAutoSuppress() { return bounceAutoSuppress; }
    public int getWebhookRetryCount() { return webhookRetryCount; }
    public int getApiKeyExpiryDays() { return apiKeyExpiryDays; }
    public String getTimezone() { return timezone; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
