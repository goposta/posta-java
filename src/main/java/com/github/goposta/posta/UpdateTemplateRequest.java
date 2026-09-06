package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateTemplateRequest changes a template's metadata. Nil fields are left
 * unchanged.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTemplateRequest {

    private String name;

    private String description;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("sample_data")
    private String sampleData;

    public UpdateTemplateRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateTemplateRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public UpdateTemplateRequest defaultLanguage(String defaultLanguage) { this.defaultLanguage = defaultLanguage; return this; }
    public String getDefaultLanguage() { return defaultLanguage; }
    public UpdateTemplateRequest sampleData(String sampleData) { this.sampleData = sampleData; return this; }
    public String getSampleData() { return sampleData; }
}
