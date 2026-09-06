package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * TemplateExportVersion is one version inside an exported template.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateExportVersion {

    private int version;

    @JsonProperty("sample_data")
    private String sampleData;

    private boolean active;

    private List<TemplateLocalization> localizations;

    public TemplateExportVersion version(int version) { this.version = version; return this; }
    public int getVersion() { return version; }
    public TemplateExportVersion sampleData(String sampleData) { this.sampleData = sampleData; return this; }
    public String getSampleData() { return sampleData; }
    public TemplateExportVersion active(boolean active) { this.active = active; return this; }
    public boolean isActive() { return active; }
    public TemplateExportVersion localizations(List<TemplateLocalization> localizations) { this.localizations = localizations; return this; }
    public List<TemplateLocalization> getLocalizations() { return localizations; }
}
