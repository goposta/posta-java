package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * A registered webhook endpoint.
 */
public class Webhook {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String url;
    private List<String> events;
    private List<String> filters;
    private String secret;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public String getUrl() { return url; }
    public List<String> getEvents() { return events; }
    public List<String> getFilters() { return filters; }
    public String getSecret() { return secret; }
    public String getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "Webhook{id=" + id + ", url='" + url + "', events=" + events + "}";
    }
}
