package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateVersionRequest opens a new version of a template, copying the current
 * active version's localizations as a starting point.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateVersionRequest {

    @JsonProperty("sample_data")
    private String sampleData;

    @JsonProperty("stylesheet_id")
    private Long stylesheetId;

    public CreateVersionRequest sampleData(String sampleData) { this.sampleData = sampleData; return this; }
    public String getSampleData() { return sampleData; }
    public CreateVersionRequest stylesheetId(Long stylesheetId) { this.stylesheetId = stylesheetId; return this; }
    public Long getStylesheetId() { return stylesheetId; }
}
