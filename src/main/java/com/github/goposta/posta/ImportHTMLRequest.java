package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ImportHTMLRequest creates a template from a raw HTML document, letting Posta
 * derive the text alternative.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportHTMLRequest {

    private String name;

    private String description;

    @JsonProperty("subject_template")
    private String subjectTemplate;

    private String html;

    private String language;

    public ImportHTMLRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public ImportHTMLRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public ImportHTMLRequest subjectTemplate(String subjectTemplate) { this.subjectTemplate = subjectTemplate; return this; }
    public String getSubjectTemplate() { return subjectTemplate; }
    public ImportHTMLRequest html(String html) { this.html = html; return this; }
    public String getHtml() { return html; }
    public ImportHTMLRequest language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
}
