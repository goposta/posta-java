package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateVersionRequest changes the stylesheet attached to a version.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateVersionRequest {

    @JsonProperty("stylesheet_id")
    private Long stylesheetId;

    public UpdateVersionRequest stylesheetId(Long stylesheetId) { this.stylesheetId = stylesheetId; return this; }
    public Long getStylesheetId() { return stylesheetId; }
}
