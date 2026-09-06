package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Notification is a dashboard message addressed to the signed-in user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String kind;

    private String category;

    private String severity;

    private String title;

    private String body;

    private String link;

    @JsonProperty("action_text")
    private String actionText;

    /**
     * DedupKey collapses repeats of the same underlying condition into one
     * notification rather than a stream of them.
     */
    @JsonProperty("dedup_key")
    private String dedupKey;

    @JsonProperty("read_at")
    private String readAt;

    @JsonProperty("dismissed_at")
    private String dismissedAt;

    @JsonProperty("resolved_at")
    private String resolvedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getId() { return id; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public String getKind() { return kind; }
    public String getCategory() { return category; }
    public String getSeverity() { return severity; }
    public String getTitle() { return title; }
    public String getBody() { return body; }
    public String getLink() { return link; }
    public String getActionText() { return actionText; }
    public String getDedupKey() { return dedupKey; }
    public String getReadAt() { return readAt; }
    public String getDismissedAt() { return dismissedAt; }
    public String getResolvedAt() { return resolvedAt; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
