package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Lightweight delivery status of an email.
 */
public class EmailStatusResponse {

    private String id;
    private String status;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("retry_count")
    private int retryCount;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("sent_at")
    private String sentAt;

    public String getId() { return id; }
    public String getStatus() { return status; }
    public String getErrorMessage() { return errorMessage; }
    public int getRetryCount() { return retryCount; }
    public String getCreatedAt() { return createdAt; }
    public String getSentAt() { return sentAt; }

    @Override
    public String toString() {
        return "EmailStatusResponse{id='" + id + "', status='" + status +
                "', retryCount=" + retryCount + "}";
    }
}
