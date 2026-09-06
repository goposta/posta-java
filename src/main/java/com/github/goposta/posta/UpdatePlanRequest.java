package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdatePlanRequest changes a plan's quotas. Nil fields are left unchanged.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePlanRequest {

    private String name;

    private String description;

    @JsonProperty("is_default")
    private Boolean isDefault;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("daily_rate_limit")
    private Integer dailyRateLimit;

    @JsonProperty("hourly_rate_limit")
    private Integer hourlyRateLimit;

    @JsonProperty("max_batch_size")
    private Integer maxBatchSize;

    @JsonProperty("max_attachment_size_mb")
    private Integer maxAttachmentSizeMb;

    @JsonProperty("max_api_keys")
    private Integer maxApiKeys;

    @JsonProperty("max_domains")
    private Integer maxDomains;

    @JsonProperty("max_smtp_servers")
    private Integer maxSmtpServers;

    @JsonProperty("max_workspaces")
    private Integer maxWorkspaces;

    @JsonProperty("email_log_retention_days")
    private Integer emailLogRetentionDays;

    public UpdatePlanRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdatePlanRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public UpdatePlanRequest isDefault(Boolean isDefault) { this.isDefault = isDefault; return this; }
    public Boolean getIsDefault() { return isDefault; }
    public UpdatePlanRequest isActive(Boolean isActive) { this.isActive = isActive; return this; }
    public Boolean getIsActive() { return isActive; }
    public UpdatePlanRequest dailyRateLimit(Integer dailyRateLimit) { this.dailyRateLimit = dailyRateLimit; return this; }
    public Integer getDailyRateLimit() { return dailyRateLimit; }
    public UpdatePlanRequest hourlyRateLimit(Integer hourlyRateLimit) { this.hourlyRateLimit = hourlyRateLimit; return this; }
    public Integer getHourlyRateLimit() { return hourlyRateLimit; }
    public UpdatePlanRequest maxBatchSize(Integer maxBatchSize) { this.maxBatchSize = maxBatchSize; return this; }
    public Integer getMaxBatchSize() { return maxBatchSize; }
    public UpdatePlanRequest maxAttachmentSizeMb(Integer maxAttachmentSizeMb) { this.maxAttachmentSizeMb = maxAttachmentSizeMb; return this; }
    public Integer getMaxAttachmentSizeMb() { return maxAttachmentSizeMb; }
    public UpdatePlanRequest maxApiKeys(Integer maxApiKeys) { this.maxApiKeys = maxApiKeys; return this; }
    public Integer getMaxApiKeys() { return maxApiKeys; }
    public UpdatePlanRequest maxDomains(Integer maxDomains) { this.maxDomains = maxDomains; return this; }
    public Integer getMaxDomains() { return maxDomains; }
    public UpdatePlanRequest maxSmtpServers(Integer maxSmtpServers) { this.maxSmtpServers = maxSmtpServers; return this; }
    public Integer getMaxSmtpServers() { return maxSmtpServers; }
    public UpdatePlanRequest maxWorkspaces(Integer maxWorkspaces) { this.maxWorkspaces = maxWorkspaces; return this; }
    public Integer getMaxWorkspaces() { return maxWorkspaces; }
    public UpdatePlanRequest emailLogRetentionDays(Integer emailLogRetentionDays) { this.emailLogRetentionDays = emailLogRetentionDays; return this; }
    public Integer getEmailLogRetentionDays() { return emailLogRetentionDays; }
}
