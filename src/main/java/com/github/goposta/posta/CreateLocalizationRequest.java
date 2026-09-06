package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateLocalizationRequest adds one language's content to a version.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateLocalizationRequest {

    private String language;

    @JsonProperty("subject_template")
    private String subjectTemplate;

    @JsonProperty("html_template")
    private String htmlTemplate;

    @JsonProperty("text_template")
    private String textTemplate;

    /**
     * BuilderJSON stores the visual editor's document for this localization.
     */
    @JsonProperty("builder_json")
    private String builderJson;

    public CreateLocalizationRequest language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public CreateLocalizationRequest subjectTemplate(String subjectTemplate) { this.subjectTemplate = subjectTemplate; return this; }
    public String getSubjectTemplate() { return subjectTemplate; }
    public CreateLocalizationRequest htmlTemplate(String htmlTemplate) { this.htmlTemplate = htmlTemplate; return this; }
    public String getHtmlTemplate() { return htmlTemplate; }
    public CreateLocalizationRequest textTemplate(String textTemplate) { this.textTemplate = textTemplate; return this; }
    public String getTextTemplate() { return textTemplate; }
    public CreateLocalizationRequest builderJson(String builderJson) { this.builderJson = builderJson; return this; }
    public String getBuilderJson() { return builderJson; }
}
