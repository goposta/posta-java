package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * Subscriber is a mailing-list recipient. Status is one of "subscribed",
 * "unsubscribed", "bounced", "complained".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscriber {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String email;

    private String name;

    private String status;

    private String language;

    private String timezone;

    @JsonProperty("custom_fields")
    private Map<String, Object> customFields;

    @JsonProperty("subscribed_at")
    private String subscribedAt;

    @JsonProperty("unsubscribed_at")
    private String unsubscribedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Subscriber id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Subscriber userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public Subscriber workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Subscriber email(String email) { this.email = email; return this; }
    public String getEmail() { return email; }
    public Subscriber name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public Subscriber status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public Subscriber language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public Subscriber timezone(String timezone) { this.timezone = timezone; return this; }
    public String getTimezone() { return timezone; }
    public Subscriber customFields(Map<String, Object> customFields) { this.customFields = customFields; return this; }
    public Map<String, Object> getCustomFields() { return customFields; }
    public Subscriber subscribedAt(String subscribedAt) { this.subscribedAt = subscribedAt; return this; }
    public String getSubscribedAt() { return subscribedAt; }
    public Subscriber unsubscribedAt(String unsubscribedAt) { this.unsubscribedAt = unsubscribedAt; return this; }
    public String getUnsubscribedAt() { return unsubscribedAt; }
    public Subscriber createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public Subscriber updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
