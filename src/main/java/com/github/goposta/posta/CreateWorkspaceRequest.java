package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateWorkspaceRequest creates a workspace. SeedDefaults, when true, fills
 * the new workspace with a starter set of languages and templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateWorkspaceRequest {

    private String name;

    private String slug;

    private String description;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("seed_defaults")
    private Boolean seedDefaults;

    public CreateWorkspaceRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateWorkspaceRequest slug(String slug) { this.slug = slug; return this; }
    public String getSlug() { return slug; }
    public CreateWorkspaceRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public CreateWorkspaceRequest defaultLanguage(String defaultLanguage) { this.defaultLanguage = defaultLanguage; return this; }
    public String getDefaultLanguage() { return defaultLanguage; }
    public CreateWorkspaceRequest seedDefaults(Boolean seedDefaults) { this.seedDefaults = seedDefaults; return this; }
    public Boolean getSeedDefaults() { return seedDefaults; }
}
