package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * TemplateVersion is one immutable revision of a template. Sending uses the
 * template's active version unless a specific one is named.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateVersion {

    private long id;

    @JsonProperty("template_id")
    private long templateId;

    private int version;

    @JsonProperty("sample_data")
    private String sampleData;

    @JsonProperty("stylesheet_id")
    private Long stylesheetId;

    private Stylesheet stylesheet;

    private List<TemplateLocalization> localizations;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getTemplateId() { return templateId; }
    public int getVersion() { return version; }
    public String getSampleData() { return sampleData; }
    public Long getStylesheetId() { return stylesheetId; }
    public Stylesheet getStylesheet() { return stylesheet; }
    public List<TemplateLocalization> getLocalizations() { return localizations; }
    public String getCreatedAt() { return createdAt; }
}
