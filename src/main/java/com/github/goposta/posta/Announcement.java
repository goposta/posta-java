package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Announcement is a platform-wide notice broadcast by an administrator.
 * Recipients counts the users it reached.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Announcement {

    private long id;

    private String title;

    private String message;

    private String severity;

    private String link;

    @JsonProperty("created_by")
    private long createdBy;

    @JsonProperty("author_name")
    private String authorName;

    private int recipients;

    @JsonProperty("sent_at")
    private String sentAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getSeverity() { return severity; }
    public String getLink() { return link; }
    public long getCreatedBy() { return createdBy; }
    public String getAuthorName() { return authorName; }
    public int getRecipients() { return recipients; }
    public String getSentAt() { return sentAt; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
