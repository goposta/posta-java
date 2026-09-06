package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A recorded bounce or complaint for a delivered email.
 * <p>
 * {@code type} is one of {@code "hard"}, {@code "soft"}, or {@code "complaint"}.
 */
public class Bounce {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("email_id")
    private long emailId;

    private String recipient;
    private String type;
    private String reason;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public long getEmailId() { return emailId; }
    public String getRecipient() { return recipient; }
    public String getType() { return type; }
    public String getReason() { return reason; }
    public String getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "Bounce{id=" + id + ", recipient='" + recipient +
                "', type='" + type + "'}";
    }
}
