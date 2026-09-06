package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TemplateLocalization holds the subject and body for one language of a
 * template version.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateLocalization {

    private long id;

    @JsonProperty("version_id")
    private long versionId;

    private String language;

    @JsonProperty("subject_template")
    private String subjectTemplate;

    @JsonProperty("html_template")
    private String htmlTemplate;

    @JsonProperty("text_template")
    private String textTemplate;

    @JsonProperty("builder_json")
    private String builderJson;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public TemplateLocalization id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public TemplateLocalization versionId(long versionId) { this.versionId = versionId; return this; }
    public long getVersionId() { return versionId; }
    public TemplateLocalization language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public TemplateLocalization subjectTemplate(String subjectTemplate) { this.subjectTemplate = subjectTemplate; return this; }
    public String getSubjectTemplate() { return subjectTemplate; }
    public TemplateLocalization htmlTemplate(String htmlTemplate) { this.htmlTemplate = htmlTemplate; return this; }
    public String getHtmlTemplate() { return htmlTemplate; }
    public TemplateLocalization textTemplate(String textTemplate) { this.textTemplate = textTemplate; return this; }
    public String getTextTemplate() { return textTemplate; }
    public TemplateLocalization builderJson(String builderJson) { this.builderJson = builderJson; return this; }
    public String getBuilderJson() { return builderJson; }
    public TemplateLocalization createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public TemplateLocalization updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
