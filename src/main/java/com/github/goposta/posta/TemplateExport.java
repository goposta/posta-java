package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * TemplateExport is a template and all its versions in a portable shape. It is
 * what Export returns and what Import accepts, so a template can be moved
 * between workspaces or kept in version control.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateExport {

    private String name;

    private String description;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("sample_data")
    private String sampleData;

    private List<TemplateExportVersion> versions;

    @JsonProperty("posta_version")
    private String postaVersion;

    @JsonProperty("exported_at")
    private String exportedAt;

    public TemplateExport name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public TemplateExport description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public TemplateExport defaultLanguage(String defaultLanguage) { this.defaultLanguage = defaultLanguage; return this; }
    public String getDefaultLanguage() { return defaultLanguage; }
    public TemplateExport sampleData(String sampleData) { this.sampleData = sampleData; return this; }
    public String getSampleData() { return sampleData; }
    public TemplateExport versions(List<TemplateExportVersion> versions) { this.versions = versions; return this; }
    public List<TemplateExportVersion> getVersions() { return versions; }
    public TemplateExport postaVersion(String postaVersion) { this.postaVersion = postaVersion; return this; }
    public String getPostaVersion() { return postaVersion; }
    public TemplateExport exportedAt(String exportedAt) { this.exportedAt = exportedAt; return this; }
    public String getExportedAt() { return exportedAt; }
}
