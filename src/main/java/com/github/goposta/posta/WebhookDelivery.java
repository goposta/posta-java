package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Records the result of a webhook delivery attempt.
 * <p>
 * {@code status} is one of {@code "success"} or {@code "failed"}.
 */
public class WebhookDelivery {

    private long id;

    @JsonProperty("webhook_id")
    private long webhookId;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String event;
    private String status;

    @JsonProperty("http_status_code")
    private int httpStatusCode;

    @JsonProperty("error_message")
    private String errorMessage;

    private int attempt;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getWebhookId() { return webhookId; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public String getEvent() { return event; }
    public String getStatus() { return status; }
    public int getHttpStatusCode() { return httpStatusCode; }
    public String getErrorMessage() { return errorMessage; }
    public int getAttempt() { return attempt; }
    public String getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "WebhookDelivery{id=" + id + ", webhookId=" + webhookId +
                ", event='" + event + "', status='" + status + "'}";
    }
}
