package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Language is a language code available to template localizations.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String code;

    private String name;

    @JsonProperty("is_default")
    private boolean isDefault;

    @JsonProperty("created_at")
    private String createdAt;

    public Language id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Language userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public Language workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Language code(String code) { this.code = code; return this; }
    public String getCode() { return code; }
    public Language name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public Language isDefault(boolean isDefault) { this.isDefault = isDefault; return this; }
    public boolean isIsDefault() { return isDefault; }
    public Language createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
}
