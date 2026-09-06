package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateTemplateRequest creates a template. Only Name is required; content is
 * added afterwards as a version with localizations.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTemplateRequest {

    private String name;

    private String description;

    @JsonProperty("default_language")
    private String defaultLanguage;

    /**
     * SampleData is JSON used to render previews of this template.
     */
    @JsonProperty("sample_data")
    private String sampleData;

    public CreateTemplateRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateTemplateRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public CreateTemplateRequest defaultLanguage(String defaultLanguage) { this.defaultLanguage = defaultLanguage; return this; }
    public String getDefaultLanguage() { return defaultLanguage; }
    public CreateTemplateRequest sampleData(String sampleData) { this.sampleData = sampleData; return this; }
    public String getSampleData() { return sampleData; }
}
