package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * TemplateListItem is the shape returned when listing templates: the metadata
 * and the active version, without the other versions' bodies.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateListItem {

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

    /**
     * Languages lists the language codes the active version is localized
     * into.
     */
    private List<String> languages;

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
    public List<String> getLanguages() { return languages; }
    public Long getLastEditedById() { return lastEditedById; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
