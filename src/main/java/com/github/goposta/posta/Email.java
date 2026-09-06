package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * A sent or queued email record.
 */
public class Email {

    private long id;
    private String uuid;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("api_key_id")
    private Long apiKeyId;

    private String sender;
    private List<String> recipients;
    private String subject;

    @JsonProperty("template_name")
    private String templateName;

    @JsonProperty("html_body")
    private String htmlBody;

    @JsonProperty("text_body")
    private String textBody;

    private String status;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("retry_count")
    private int retryCount;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("sent_at")
    private String sentAt;

    @JsonProperty("scheduled_at")
    private String scheduledAt;

    private String provider;

    @JsonProperty("smtp_hostname")
    private String smtpHostname;

    public long getId() { return id; }
    public String getUuid() { return uuid; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public Long getApiKeyId() { return apiKeyId; }
    public String getSender() { return sender; }
    public List<String> getRecipients() { return recipients; }
    public String getSubject() { return subject; }
    public String getTemplateName() { return templateName; }
    public String getHtmlBody() { return htmlBody; }
    public String getTextBody() { return textBody; }
    public String getStatus() { return status; }
    public String getErrorMessage() { return errorMessage; }
    public int getRetryCount() { return retryCount; }
    public String getCreatedAt() { return createdAt; }
    public String getSentAt() { return sentAt; }
    public String getScheduledAt() { return scheduledAt; }
    public String getProvider() { return provider; }
    public String getSmtpHostname() { return smtpHostname; }

    @Override
    public String toString() {
        return "Email{id=" + id + ", uuid='" + uuid + "', subject='" + subject +
                "', status='" + status + "'}";
    }
}
