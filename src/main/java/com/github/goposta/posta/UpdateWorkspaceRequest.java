package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateWorkspaceRequest renames or re-describes a workspace.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateWorkspaceRequest {

    private String name;

    private String description;

    @JsonProperty("default_language")
    private String defaultLanguage;

    public UpdateWorkspaceRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateWorkspaceRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public UpdateWorkspaceRequest defaultLanguage(String defaultLanguage) { this.defaultLanguage = defaultLanguage; return this; }
    public String getDefaultLanguage() { return defaultLanguage; }
}
