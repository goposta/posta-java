package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Stylesheet is reusable CSS that template versions can share.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stylesheet {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    private String css;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Stylesheet id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Stylesheet userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public Stylesheet workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Stylesheet name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public Stylesheet css(String css) { this.css = css; return this; }
    public String getCss() { return css; }
    public Stylesheet createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public Stylesheet updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
