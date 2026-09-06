package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateLocalizationRequest changes one language's content. Nil fields are
 * left unchanged.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateLocalizationRequest {

    @JsonProperty("subject_template")
    private String subjectTemplate;

    @JsonProperty("html_template")
    private String htmlTemplate;

    @JsonProperty("text_template")
    private String textTemplate;

    @JsonProperty("builder_json")
    private String builderJson;

    public UpdateLocalizationRequest subjectTemplate(String subjectTemplate) { this.subjectTemplate = subjectTemplate; return this; }
    public String getSubjectTemplate() { return subjectTemplate; }
    public UpdateLocalizationRequest htmlTemplate(String htmlTemplate) { this.htmlTemplate = htmlTemplate; return this; }
    public String getHtmlTemplate() { return htmlTemplate; }
    public UpdateLocalizationRequest textTemplate(String textTemplate) { this.textTemplate = textTemplate; return this; }
    public String getTextTemplate() { return textTemplate; }
    public UpdateLocalizationRequest builderJson(String builderJson) { this.builderJson = builderJson; return this; }
    public String getBuilderJson() { return builderJson; }
}
