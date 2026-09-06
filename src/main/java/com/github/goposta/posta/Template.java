package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Template is a named, versioned email template. The rendered content lives on
 * its versions; the template itself holds the metadata and points at the
 * version that sends.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Template {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    private String description;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("sample_data")
    private String sampleData;

    @JsonProperty("active_version_id")
    private Long activeVersionId;

    @JsonProperty("active_version")
    private TemplateVersion activeVersion;

    @JsonProperty("last_edited_by_id")
    private Long lastEditedById;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getId() { return id; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDefaultLanguage() { return defaultLanguage; }
    public String getSampleData() { return sampleData; }
    public Long getActiveVersionId() { return activeVersionId; }
    public TemplateVersion getActiveVersion() { return activeVersion; }
    public Long getLastEditedById() { return lastEditedById; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
