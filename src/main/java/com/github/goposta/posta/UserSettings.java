package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UserSettings holds the account's personal defaults and notification
 * preferences.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSettings {

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("default_sender_email")
    private String defaultSenderEmail;

    @JsonProperty("default_sender_name")
    private String defaultSenderName;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("default_template_id")
    private Long defaultTemplateId;

    @JsonProperty("notification_email")
    private String notificationEmail;

    @JsonProperty("email_notifications")
    private boolean emailNotifications;

    @JsonProperty("daily_report")
    private boolean dailyReport;

    @JsonProperty("notify_bounce_alerts")
    private boolean notifyBounceAlerts;

    @JsonProperty("notify_api_key_expiry")
    private boolean notifyApiKeyExpiry;

    @JsonProperty("notify_new_message")
    private boolean notifyNewMessage;

    @JsonProperty("notify_workspace_activity")
    private boolean notifyWorkspaceActivity;

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

    public long getUserId() { return userId; }
    public String getDefaultSenderEmail() { return defaultSenderEmail; }
    public String getDefaultSenderName() { return defaultSenderName; }
    public String getDefaultLanguage() { return defaultLanguage; }
    public Long getDefaultTemplateId() { return defaultTemplateId; }
    public String getNotificationEmail() { return notificationEmail; }
    public boolean isEmailNotifications() { return emailNotifications; }
    public boolean isDailyReport() { return dailyReport; }
    public boolean isNotifyBounceAlerts() { return notifyBounceAlerts; }
    public boolean isNotifyApiKeyExpiry() { return notifyApiKeyExpiry; }
    public boolean isNotifyNewMessage() { return notifyNewMessage; }
    public boolean isNotifyWorkspaceActivity() { return notifyWorkspaceActivity; }
    public boolean isBounceAutoSuppress() { return bounceAutoSuppress; }
    public int getWebhookRetryCount() { return webhookRetryCount; }
    public int getApiKeyExpiryDays() { return apiKeyExpiryDays; }
    public String getTimezone() { return timezone; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
