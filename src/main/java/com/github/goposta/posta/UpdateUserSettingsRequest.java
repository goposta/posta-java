package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateUserSettingsRequest changes account settings. Nil fields are left
 * unchanged.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserSettingsRequest {

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
    private Boolean emailNotifications;

    @JsonProperty("daily_report")
    private Boolean dailyReport;

    @JsonProperty("notify_bounce_alerts")
    private Boolean notifyBounceAlerts;

    @JsonProperty("notify_api_key_expiry")
    private Boolean notifyApiKeyExpiry;

    @JsonProperty("notify_new_message")
    private Boolean notifyNewMessage;

    @JsonProperty("notify_workspace_activity")
    private Boolean notifyWorkspaceActivity;

    @JsonProperty("bounce_auto_suppress")
    private Boolean bounceAutoSuppress;

    @JsonProperty("webhook_retry_count")
    private Integer webhookRetryCount;

    @JsonProperty("api_key_expiry_days")
    private Integer apiKeyExpiryDays;

    private String timezone;

    public UpdateUserSettingsRequest defaultSenderEmail(String defaultSenderEmail) { this.defaultSenderEmail = defaultSenderEmail; return this; }
    public String getDefaultSenderEmail() { return defaultSenderEmail; }
    public UpdateUserSettingsRequest defaultSenderName(String defaultSenderName) { this.defaultSenderName = defaultSenderName; return this; }
    public String getDefaultSenderName() { return defaultSenderName; }
    public UpdateUserSettingsRequest defaultLanguage(String defaultLanguage) { this.defaultLanguage = defaultLanguage; return this; }
    public String getDefaultLanguage() { return defaultLanguage; }
    public UpdateUserSettingsRequest defaultTemplateId(Long defaultTemplateId) { this.defaultTemplateId = defaultTemplateId; return this; }
    public Long getDefaultTemplateId() { return defaultTemplateId; }
    public UpdateUserSettingsRequest notificationEmail(String notificationEmail) { this.notificationEmail = notificationEmail; return this; }
    public String getNotificationEmail() { return notificationEmail; }
    public UpdateUserSettingsRequest emailNotifications(Boolean emailNotifications) { this.emailNotifications = emailNotifications; return this; }
    public Boolean getEmailNotifications() { return emailNotifications; }
    public UpdateUserSettingsRequest dailyReport(Boolean dailyReport) { this.dailyReport = dailyReport; return this; }
    public Boolean getDailyReport() { return dailyReport; }
    public UpdateUserSettingsRequest notifyBounceAlerts(Boolean notifyBounceAlerts) { this.notifyBounceAlerts = notifyBounceAlerts; return this; }
    public Boolean getNotifyBounceAlerts() { return notifyBounceAlerts; }
    public UpdateUserSettingsRequest notifyApiKeyExpiry(Boolean notifyApiKeyExpiry) { this.notifyApiKeyExpiry = notifyApiKeyExpiry; return this; }
    public Boolean getNotifyApiKeyExpiry() { return notifyApiKeyExpiry; }
    public UpdateUserSettingsRequest notifyNewMessage(Boolean notifyNewMessage) { this.notifyNewMessage = notifyNewMessage; return this; }
    public Boolean getNotifyNewMessage() { return notifyNewMessage; }
    public UpdateUserSettingsRequest notifyWorkspaceActivity(Boolean notifyWorkspaceActivity) { this.notifyWorkspaceActivity = notifyWorkspaceActivity; return this; }
    public Boolean getNotifyWorkspaceActivity() { return notifyWorkspaceActivity; }
    public UpdateUserSettingsRequest bounceAutoSuppress(Boolean bounceAutoSuppress) { this.bounceAutoSuppress = bounceAutoSuppress; return this; }
    public Boolean getBounceAutoSuppress() { return bounceAutoSuppress; }
    public UpdateUserSettingsRequest webhookRetryCount(Integer webhookRetryCount) { this.webhookRetryCount = webhookRetryCount; return this; }
    public Integer getWebhookRetryCount() { return webhookRetryCount; }
    public UpdateUserSettingsRequest apiKeyExpiryDays(Integer apiKeyExpiryDays) { this.apiKeyExpiryDays = apiKeyExpiryDays; return this; }
    public Integer getApiKeyExpiryDays() { return apiKeyExpiryDays; }
    public UpdateUserSettingsRequest timezone(String timezone) { this.timezone = timezone; return this; }
    public String getTimezone() { return timezone; }
}
