package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreatePlanRequest defines a plan's quotas.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePlanRequest {

    private String name;

    private String description;

    @JsonProperty("is_default")
    private boolean isDefault;

    @JsonProperty("daily_rate_limit")
    private int dailyRateLimit;

    @JsonProperty("hourly_rate_limit")
    private int hourlyRateLimit;

    @JsonProperty("max_batch_size")
    private int maxBatchSize;

    @JsonProperty("max_attachment_size_mb")
    private int maxAttachmentSizeMb;

    @JsonProperty("max_api_keys")
    private int maxApiKeys;

    @JsonProperty("max_domains")
    private int maxDomains;

    @JsonProperty("max_smtp_servers")
    private int maxSmtpServers;

    @JsonProperty("max_workspaces")
    private int maxWorkspaces;

    @JsonProperty("email_log_retention_days")
    private int emailLogRetentionDays;

    public CreatePlanRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreatePlanRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public CreatePlanRequest isDefault(boolean isDefault) { this.isDefault = isDefault; return this; }
    public boolean isIsDefault() { return isDefault; }
    public CreatePlanRequest dailyRateLimit(int dailyRateLimit) { this.dailyRateLimit = dailyRateLimit; return this; }
    public int getDailyRateLimit() { return dailyRateLimit; }
    public CreatePlanRequest hourlyRateLimit(int hourlyRateLimit) { this.hourlyRateLimit = hourlyRateLimit; return this; }
    public int getHourlyRateLimit() { return hourlyRateLimit; }
    public CreatePlanRequest maxBatchSize(int maxBatchSize) { this.maxBatchSize = maxBatchSize; return this; }
    public int getMaxBatchSize() { return maxBatchSize; }
    public CreatePlanRequest maxAttachmentSizeMb(int maxAttachmentSizeMb) { this.maxAttachmentSizeMb = maxAttachmentSizeMb; return this; }
    public int getMaxAttachmentSizeMb() { return maxAttachmentSizeMb; }
    public CreatePlanRequest maxApiKeys(int maxApiKeys) { this.maxApiKeys = maxApiKeys; return this; }
    public int getMaxApiKeys() { return maxApiKeys; }
    public CreatePlanRequest maxDomains(int maxDomains) { this.maxDomains = maxDomains; return this; }
    public int getMaxDomains() { return maxDomains; }
    public CreatePlanRequest maxSmtpServers(int maxSmtpServers) { this.maxSmtpServers = maxSmtpServers; return this; }
    public int getMaxSmtpServers() { return maxSmtpServers; }
    public CreatePlanRequest maxWorkspaces(int maxWorkspaces) { this.maxWorkspaces = maxWorkspaces; return this; }
    public int getMaxWorkspaces() { return maxWorkspaces; }
    public CreatePlanRequest emailLogRetentionDays(int emailLogRetentionDays) { this.emailLogRetentionDays = emailLogRetentionDays; return this; }
    public int getEmailLogRetentionDays() { return emailLogRetentionDays; }
}
