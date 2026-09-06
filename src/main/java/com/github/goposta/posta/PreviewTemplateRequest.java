package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * PreviewTemplateRequest renders template source directly, without saving it.
 * It is the preview used while editing, before a version exists.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreviewTemplateRequest {

    @JsonProperty("subject_template")
    private String subjectTemplate;

    @JsonProperty("html_template")
    private String htmlTemplate;

    @JsonProperty("text_template")
    private String textTemplate;

    @JsonProperty("stylesheet_id")
    private Long stylesheetId;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    public PreviewTemplateRequest subjectTemplate(String subjectTemplate) { this.subjectTemplate = subjectTemplate; return this; }
    public String getSubjectTemplate() { return subjectTemplate; }
    public PreviewTemplateRequest htmlTemplate(String htmlTemplate) { this.htmlTemplate = htmlTemplate; return this; }
    public String getHtmlTemplate() { return htmlTemplate; }
    public PreviewTemplateRequest textTemplate(String textTemplate) { this.textTemplate = textTemplate; return this; }
    public String getTextTemplate() { return textTemplate; }
    public PreviewTemplateRequest stylesheetId(Long stylesheetId) { this.stylesheetId = stylesheetId; return this; }
    public Long getStylesheetId() { return stylesheetId; }
    public PreviewTemplateRequest templateData(Map<String, Object> templateData) { this.templateData = templateData; return this; }
    public Map<String, Object> getTemplateData() { return templateData; }
}
