package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateWorkspaceSettingsRequest changes workspace settings. Nil fields are
 * left unchanged.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateWorkspaceSettingsRequest {

    @JsonProperty("default_sender_email")
    private String defaultSenderEmail;

    @JsonProperty("default_sender_name")
    private String defaultSenderName;

    @JsonProperty("require_verified_domain")
    private Boolean requireVerifiedDomain;

    @JsonProperty("bounce_auto_suppress")
    private Boolean bounceAutoSuppress;

    @JsonProperty("webhook_retry_count")
    private Integer webhookRetryCount;

    @JsonProperty("api_key_expiry_days")
    private Integer apiKeyExpiryDays;

    private String timezone;

    public UpdateWorkspaceSettingsRequest defaultSenderEmail(String defaultSenderEmail) { this.defaultSenderEmail = defaultSenderEmail; return this; }
    public String getDefaultSenderEmail() { return defaultSenderEmail; }
    public UpdateWorkspaceSettingsRequest defaultSenderName(String defaultSenderName) { this.defaultSenderName = defaultSenderName; return this; }
    public String getDefaultSenderName() { return defaultSenderName; }
    public UpdateWorkspaceSettingsRequest requireVerifiedDomain(Boolean requireVerifiedDomain) { this.requireVerifiedDomain = requireVerifiedDomain; return this; }
    public Boolean getRequireVerifiedDomain() { return requireVerifiedDomain; }
    public UpdateWorkspaceSettingsRequest bounceAutoSuppress(Boolean bounceAutoSuppress) { this.bounceAutoSuppress = bounceAutoSuppress; return this; }
    public Boolean getBounceAutoSuppress() { return bounceAutoSuppress; }
    public UpdateWorkspaceSettingsRequest webhookRetryCount(Integer webhookRetryCount) { this.webhookRetryCount = webhookRetryCount; return this; }
    public Integer getWebhookRetryCount() { return webhookRetryCount; }
    public UpdateWorkspaceSettingsRequest apiKeyExpiryDays(Integer apiKeyExpiryDays) { this.apiKeyExpiryDays = apiKeyExpiryDays; return this; }
    public Integer getApiKeyExpiryDays() { return apiKeyExpiryDays; }
    public UpdateWorkspaceSettingsRequest timezone(String timezone) { this.timezone = timezone; return this; }
    public String getTimezone() { return timezone; }
}
