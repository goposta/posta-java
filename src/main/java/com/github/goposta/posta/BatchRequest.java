package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Request body for sending batch emails using a template.
 * <p>
 * Provide either {@code templateId} or {@code template} (name). {@code templateId} is preferred
 * (primary key lookup); {@code template} is a fallback when the ID is not known.
 */
public class BatchRequest {

    /** Template numeric ID (preferred). */
    @JsonProperty("template_id")
    private Integer templateId;

    /** Template name (fallback when templateId is not provided). */
    private String template;
    private String language;
    private String from;
    private List<BatchRecipient> recipients;

    public BatchRequest templateId(Integer templateId) { this.templateId = templateId; return this; }
    public BatchRequest template(String template) { this.template = template; return this; }
    public BatchRequest language(String language) { this.language = language; return this; }
    public BatchRequest from(String from) { this.from = from; return this; }
    public BatchRequest recipients(List<BatchRecipient> recipients) { this.recipients = recipients; return this; }

    public Integer getTemplateId() { return templateId; }
    public String getTemplate() { return template; }
    public String getLanguage() { return language; }
    public String getFrom() { return from; }
    public List<BatchRecipient> getRecipients() { return recipients; }
}
