package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Plan is the quota and feature set applied to a workspace or user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plan {

    private long id;

    private String name;

    private String description;

    @JsonProperty("is_default")
    private boolean isDefault;

    @JsonProperty("is_active")
    private boolean isActive;

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

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isIsDefault() { return isDefault; }
    public boolean isIsActive() { return isActive; }
    public int getDailyRateLimit() { return dailyRateLimit; }
    public int getHourlyRateLimit() { return hourlyRateLimit; }
    public int getMaxBatchSize() { return maxBatchSize; }
    public int getMaxAttachmentSizeMb() { return maxAttachmentSizeMb; }
    public int getMaxApiKeys() { return maxApiKeys; }
    public int getMaxDomains() { return maxDomains; }
    public int getMaxSmtpServers() { return maxSmtpServers; }
    public int getMaxWorkspaces() { return maxWorkspaces; }
    public int getEmailLogRetentionDays() { return emailLogRetentionDays; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
