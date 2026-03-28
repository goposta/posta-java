package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * A single recipient in a batch send request.
 */
public class BatchRecipient {

    private String email;
    private String language;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    public BatchRecipient email(String email) { this.email = email; return this; }
    public BatchRecipient language(String language) { this.language = language; return this; }
    public BatchRecipient templateData(Map<String, Object> data) { this.templateData = data; return this; }

    public String getEmail() { return email; }
    public String getLanguage() { return language; }
    public Map<String, Object> getTemplateData() { return templateData; }
}
