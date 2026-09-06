package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * UpdateFormRequest changes a form. Nil fields are left unchanged, so a single
 * setting can be adjusted without restating the rest. Status is "active",
 * "paused", or "archived".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateFormRequest {

    private String name;

    private String slug;

    private String description;

    private String status;

    @JsonProperty("allowed_origins")
    private List<String> allowedOrigins;

    @JsonProperty("strict_origin")
    private Boolean strictOrigin;

    @JsonProperty("honeypot_field")
    private String honeypotField;

    @JsonProperty("require_nonce")
    private Boolean requireNonce;

    @JsonProperty("min_fill_seconds")
    private Integer minFillSeconds;

    @JsonProperty("max_fields")
    private Integer maxFields;

    @JsonProperty("max_body_bytes")
    private Long maxBodyBytes;

    @JsonProperty("allow_attachments")
    private Boolean allowAttachments;

    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("scan_enabled")
    private Boolean scanEnabled;

    @JsonProperty("flag_threshold")
    private Double flagThreshold;

    @JsonProperty("quarantine_threshold")
    private Double quarantineThreshold;

    @JsonProperty("reject_threshold")
    private Double rejectThreshold;

    @JsonProperty("notify_enabled")
    private Boolean notifyEnabled;

    @JsonProperty("notify_emails")
    private List<String> notifyEmails;

    @JsonProperty("notify_mode")
    private String notifyMode;

    @JsonProperty("notify_on_flagged")
    private Boolean notifyOnFlagged;

    @JsonProperty("reply_from")
    private String replyFrom;

    @JsonProperty("reply_from_name")
    private String replyFromName;

    @JsonProperty("retention_days")
    private Integer retentionDays;

    public UpdateFormRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateFormRequest slug(String slug) { this.slug = slug; return this; }
    public String getSlug() { return slug; }
    public UpdateFormRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public UpdateFormRequest status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public UpdateFormRequest allowedOrigins(List<String> allowedOrigins) { this.allowedOrigins = allowedOrigins; return this; }
    public List<String> getAllowedOrigins() { return allowedOrigins; }
    public UpdateFormRequest strictOrigin(Boolean strictOrigin) { this.strictOrigin = strictOrigin; return this; }
    public Boolean getStrictOrigin() { return strictOrigin; }
    public UpdateFormRequest honeypotField(String honeypotField) { this.honeypotField = honeypotField; return this; }
    public String getHoneypotField() { return honeypotField; }
    public UpdateFormRequest requireNonce(Boolean requireNonce) { this.requireNonce = requireNonce; return this; }
    public Boolean getRequireNonce() { return requireNonce; }
    public UpdateFormRequest minFillSeconds(Integer minFillSeconds) { this.minFillSeconds = minFillSeconds; return this; }
    public Integer getMinFillSeconds() { return minFillSeconds; }
    public UpdateFormRequest maxFields(Integer maxFields) { this.maxFields = maxFields; return this; }
    public Integer getMaxFields() { return maxFields; }
    public UpdateFormRequest maxBodyBytes(Long maxBodyBytes) { this.maxBodyBytes = maxBodyBytes; return this; }
    public Long getMaxBodyBytes() { return maxBodyBytes; }
    public UpdateFormRequest allowAttachments(Boolean allowAttachments) { this.allowAttachments = allowAttachments; return this; }
    public Boolean getAllowAttachments() { return allowAttachments; }
    public UpdateFormRequest redirectUrl(String redirectUrl) { this.redirectUrl = redirectUrl; return this; }
    public String getRedirectUrl() { return redirectUrl; }
    public UpdateFormRequest scanEnabled(Boolean scanEnabled) { this.scanEnabled = scanEnabled; return this; }
    public Boolean getScanEnabled() { return scanEnabled; }
    public UpdateFormRequest flagThreshold(Double flagThreshold) { this.flagThreshold = flagThreshold; return this; }
    public Double getFlagThreshold() { return flagThreshold; }
    public UpdateFormRequest quarantineThreshold(Double quarantineThreshold) { this.quarantineThreshold = quarantineThreshold; return this; }
    public Double getQuarantineThreshold() { return quarantineThreshold; }
    public UpdateFormRequest rejectThreshold(Double rejectThreshold) { this.rejectThreshold = rejectThreshold; return this; }
    public Double getRejectThreshold() { return rejectThreshold; }
    public UpdateFormRequest notifyEnabled(Boolean notifyEnabled) { this.notifyEnabled = notifyEnabled; return this; }
    public Boolean getNotifyEnabled() { return notifyEnabled; }
    public UpdateFormRequest notifyEmails(List<String> notifyEmails) { this.notifyEmails = notifyEmails; return this; }
    public List<String> getNotifyEmails() { return notifyEmails; }
    public UpdateFormRequest notifyMode(String notifyMode) { this.notifyMode = notifyMode; return this; }
    public String getNotifyMode() { return notifyMode; }
    public UpdateFormRequest notifyOnFlagged(Boolean notifyOnFlagged) { this.notifyOnFlagged = notifyOnFlagged; return this; }
    public Boolean getNotifyOnFlagged() { return notifyOnFlagged; }
    public UpdateFormRequest replyFrom(String replyFrom) { this.replyFrom = replyFrom; return this; }
    public String getReplyFrom() { return replyFrom; }
    public UpdateFormRequest replyFromName(String replyFromName) { this.replyFromName = replyFromName; return this; }
    public String getReplyFromName() { return replyFromName; }
    public UpdateFormRequest retentionDays(Integer retentionDays) { this.retentionDays = retentionDays; return this; }
    public Integer getRetentionDays() { return retentionDays; }
}
