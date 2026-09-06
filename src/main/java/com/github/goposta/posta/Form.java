package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Form is a web form endpoint that accepts public submissions and turns them
 * into messages.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Form {

    private long id;

    private String uuid;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    private String slug;

    private String description;

    @JsonProperty("public_key")
    private String publicKey;

    private String status;

    @JsonProperty("allowed_origins")
    private List<String> allowedOrigins;

    @JsonProperty("strict_origin")
    private boolean strictOrigin;

    @JsonProperty("honeypot_field")
    private String honeypotField;

    @JsonProperty("require_nonce")
    private boolean requireNonce;

    @JsonProperty("min_fill_seconds")
    private int minFillSeconds;

    @JsonProperty("max_fields")
    private int maxFields;

    @JsonProperty("max_body_bytes")
    private long maxBodyBytes;

    @JsonProperty("allow_attachments")
    private boolean allowAttachments;

    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("scan_enabled")
    private boolean scanEnabled;

    @JsonProperty("flag_threshold")
    private double flagThreshold;

    @JsonProperty("quarantine_threshold")
    private double quarantineThreshold;

    @JsonProperty("reject_threshold")
    private double rejectThreshold;

    @JsonProperty("notify_enabled")
    private boolean notifyEnabled;

    @JsonProperty("notify_emails")
    private List<String> notifyEmails;

    @JsonProperty("notify_mode")
    private String notifyMode;

    @JsonProperty("notify_on_flagged")
    private boolean notifyOnFlagged;

    @JsonProperty("reply_from")
    private String replyFrom;

    @JsonProperty("reply_from_name")
    private String replyFromName;

    @JsonProperty("retention_days")
    private int retentionDays;

    @JsonProperty("message_count")
    private long messageCount;

    @JsonProperty("spam_count")
    private long spamCount;

    @JsonProperty("last_message_at")
    private String lastMessageAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Form id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Form uuid(String uuid) { this.uuid = uuid; return this; }
    public String getUuid() { return uuid; }
    public Form workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Form name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public Form slug(String slug) { this.slug = slug; return this; }
    public String getSlug() { return slug; }
    public Form description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public Form publicKey(String publicKey) { this.publicKey = publicKey; return this; }
    public String getPublicKey() { return publicKey; }
    public Form status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public Form allowedOrigins(List<String> allowedOrigins) { this.allowedOrigins = allowedOrigins; return this; }
    public List<String> getAllowedOrigins() { return allowedOrigins; }
    public Form strictOrigin(boolean strictOrigin) { this.strictOrigin = strictOrigin; return this; }
    public boolean isStrictOrigin() { return strictOrigin; }
    public Form honeypotField(String honeypotField) { this.honeypotField = honeypotField; return this; }
    public String getHoneypotField() { return honeypotField; }
    public Form requireNonce(boolean requireNonce) { this.requireNonce = requireNonce; return this; }
    public boolean isRequireNonce() { return requireNonce; }
    public Form minFillSeconds(int minFillSeconds) { this.minFillSeconds = minFillSeconds; return this; }
    public int getMinFillSeconds() { return minFillSeconds; }
    public Form maxFields(int maxFields) { this.maxFields = maxFields; return this; }
    public int getMaxFields() { return maxFields; }
    public Form maxBodyBytes(long maxBodyBytes) { this.maxBodyBytes = maxBodyBytes; return this; }
    public long getMaxBodyBytes() { return maxBodyBytes; }
    public Form allowAttachments(boolean allowAttachments) { this.allowAttachments = allowAttachments; return this; }
    public boolean isAllowAttachments() { return allowAttachments; }
    public Form redirectUrl(String redirectUrl) { this.redirectUrl = redirectUrl; return this; }
    public String getRedirectUrl() { return redirectUrl; }
    public Form scanEnabled(boolean scanEnabled) { this.scanEnabled = scanEnabled; return this; }
    public boolean isScanEnabled() { return scanEnabled; }
    public Form flagThreshold(double flagThreshold) { this.flagThreshold = flagThreshold; return this; }
    public double getFlagThreshold() { return flagThreshold; }
    public Form quarantineThreshold(double quarantineThreshold) { this.quarantineThreshold = quarantineThreshold; return this; }
    public double getQuarantineThreshold() { return quarantineThreshold; }
    public Form rejectThreshold(double rejectThreshold) { this.rejectThreshold = rejectThreshold; return this; }
    public double getRejectThreshold() { return rejectThreshold; }
    public Form notifyEnabled(boolean notifyEnabled) { this.notifyEnabled = notifyEnabled; return this; }
    public boolean isNotifyEnabled() { return notifyEnabled; }
    public Form notifyEmails(List<String> notifyEmails) { this.notifyEmails = notifyEmails; return this; }
    public List<String> getNotifyEmails() { return notifyEmails; }
    public Form notifyMode(String notifyMode) { this.notifyMode = notifyMode; return this; }
    public String getNotifyMode() { return notifyMode; }
    public Form notifyOnFlagged(boolean notifyOnFlagged) { this.notifyOnFlagged = notifyOnFlagged; return this; }
    public boolean isNotifyOnFlagged() { return notifyOnFlagged; }
    public Form replyFrom(String replyFrom) { this.replyFrom = replyFrom; return this; }
    public String getReplyFrom() { return replyFrom; }
    public Form replyFromName(String replyFromName) { this.replyFromName = replyFromName; return this; }
    public String getReplyFromName() { return replyFromName; }
    public Form retentionDays(int retentionDays) { this.retentionDays = retentionDays; return this; }
    public int getRetentionDays() { return retentionDays; }
    public Form messageCount(long messageCount) { this.messageCount = messageCount; return this; }
    public long getMessageCount() { return messageCount; }
    public Form spamCount(long spamCount) { this.spamCount = spamCount; return this; }
    public long getSpamCount() { return spamCount; }
    public Form lastMessageAt(String lastMessageAt) { this.lastMessageAt = lastMessageAt; return this; }
    public String getLastMessageAt() { return lastMessageAt; }
    public Form createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public Form updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
