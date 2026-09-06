package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Request body for sending a template-based email.
 * <p>
 * Provide either {@code templateId} or {@code template} (name). {@code templateId} is preferred
 * (primary key lookup); {@code template} is a fallback when the ID is not known.
 */
public class SendTemplateEmailRequest {

    /** Template numeric ID (preferred). */
    @JsonProperty("template_id")
    private Integer templateId;

    /** Template name (fallback when templateId is not provided). */
    private String template;
    private String language;
    private String from;
    private List<String> to;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    private List<Attachment> attachments;

    /** Configures the {@code List-Unsubscribe} / {@code List-Unsubscribe-Post} headers. */
    private Unsubscribe unsubscribe;

    public SendTemplateEmailRequest templateId(Integer templateId) { this.templateId = templateId; return this; }
    public SendTemplateEmailRequest template(String template) { this.template = template; return this; }
    public SendTemplateEmailRequest language(String language) { this.language = language; return this; }
    public SendTemplateEmailRequest from(String from) { this.from = from; return this; }
    public SendTemplateEmailRequest to(List<String> to) { this.to = to; return this; }
    public SendTemplateEmailRequest templateData(Map<String, Object> data) { this.templateData = data; return this; }
    public SendTemplateEmailRequest attachments(List<Attachment> attachments) { this.attachments = attachments; return this; }
    public SendTemplateEmailRequest unsubscribe(Unsubscribe unsubscribe) { this.unsubscribe = unsubscribe; return this; }

    public Integer getTemplateId() { return templateId; }
    public String getTemplate() { return template; }
    public String getLanguage() { return language; }
    public String getFrom() { return from; }
    public List<String> getTo() { return to; }
    public Map<String, Object> getTemplateData() { return templateData; }
    public List<Attachment> getAttachments() { return attachments; }
    public Unsubscribe getUnsubscribe() { return unsubscribe; }
}
