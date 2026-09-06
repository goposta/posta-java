package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * SendTestRequest sends a template to a handful of addresses so an editor can
 * see the real thing in a real inbox.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendTestRequest {

    private List<String> to;

    private String from;

    private String language;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    public SendTestRequest to(List<String> to) { this.to = to; return this; }
    public List<String> getTo() { return to; }
    public SendTestRequest from(String from) { this.from = from; return this; }
    public String getFrom() { return from; }
    public SendTestRequest language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public SendTestRequest templateData(Map<String, Object> templateData) { this.templateData = templateData; return this; }
    public Map<String, Object> getTemplateData() { return templateData; }
}
