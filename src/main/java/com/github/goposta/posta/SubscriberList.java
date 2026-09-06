package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * SubscriberList groups subscribers. Type is "static" (explicit membership) or
 * "segment" (membership derived from FilterRules).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriberList {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    private String description;

    private String type;

    @JsonProperty("filter_rules")
    private List<FilterRule> filterRules;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public SubscriberList id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public SubscriberList userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public SubscriberList workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public SubscriberList name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public SubscriberList description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public SubscriberList type(String type) { this.type = type; return this; }
    public String getType() { return type; }
    public SubscriberList filterRules(List<FilterRule> filterRules) { this.filterRules = filterRules; return this; }
    public List<FilterRule> getFilterRules() { return filterRules; }
    public SubscriberList createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public SubscriberList updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
