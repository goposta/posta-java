package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Request body for rendering a template without sending.
 * <p>
 * Provide either {@code templateId} or {@code template} (name).
 */
public class PreviewRequest {

    @JsonProperty("template_id")
    private Integer templateId;

    private String template;
    private String language;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    public PreviewRequest templateId(Integer templateId) { this.templateId = templateId; return this; }
    public PreviewRequest template(String template) { this.template = template; return this; }
    public PreviewRequest language(String language) { this.language = language; return this; }
    public PreviewRequest templateData(Map<String, Object> data) { this.templateData = data; return this; }

    public Integer getTemplateId() { return templateId; }
    public String getTemplate() { return template; }
    public String getLanguage() { return language; }
    public Map<String, Object> getTemplateData() { return templateData; }
}
