package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AbTestVariant is one arm of a campaign A/B test.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbTestVariant {

    private String name;

    private String subject;

    @JsonProperty("template_id")
    private Long templateId;

    @JsonProperty("split_percentage")
    private int splitPercentage;

    public AbTestVariant name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public AbTestVariant subject(String subject) { this.subject = subject; return this; }
    public String getSubject() { return subject; }
    public AbTestVariant templateId(Long templateId) { this.templateId = templateId; return this; }
    public Long getTemplateId() { return templateId; }
    public AbTestVariant splitPercentage(int splitPercentage) { this.splitPercentage = splitPercentage; return this; }
    public int getSplitPercentage() { return splitPercentage; }
}
