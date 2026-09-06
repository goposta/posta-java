package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * UpdateCampaignRequest changes a draft or scheduled campaign. Nil fields are
 * left unchanged; a campaign that has started cannot be edited.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCampaignRequest {

    private String name;

    private String subject;

    @JsonProperty("from_email")
    private String fromEmail;

    @JsonProperty("from_name")
    private String fromName;

    @JsonProperty("list_id")
    private Long listId;

    @JsonProperty("template_id")
    private Long templateId;

    @JsonProperty("template_version_id")
    private Long templateVersionId;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    private String language;

    @JsonProperty("scheduled_at")
    private String scheduledAt;

    @JsonProperty("send_rate")
    private Integer sendRate;

    @JsonProperty("send_at_local_time")
    private Boolean sendAtLocalTime;

    @JsonProperty("ab_test_enabled")
    private Boolean abTestEnabled;

    @JsonProperty("ab_test_variants")
    private List<AbTestVariant> abTestVariants;

    public UpdateCampaignRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateCampaignRequest subject(String subject) { this.subject = subject; return this; }
    public String getSubject() { return subject; }
    public UpdateCampaignRequest fromEmail(String fromEmail) { this.fromEmail = fromEmail; return this; }
    public String getFromEmail() { return fromEmail; }
    public UpdateCampaignRequest fromName(String fromName) { this.fromName = fromName; return this; }
    public String getFromName() { return fromName; }
    public UpdateCampaignRequest listId(Long listId) { this.listId = listId; return this; }
    public Long getListId() { return listId; }
    public UpdateCampaignRequest templateId(Long templateId) { this.templateId = templateId; return this; }
    public Long getTemplateId() { return templateId; }
    public UpdateCampaignRequest templateVersionId(Long templateVersionId) { this.templateVersionId = templateVersionId; return this; }
    public Long getTemplateVersionId() { return templateVersionId; }
    public UpdateCampaignRequest templateData(Map<String, Object> templateData) { this.templateData = templateData; return this; }
    public Map<String, Object> getTemplateData() { return templateData; }
    public UpdateCampaignRequest language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public UpdateCampaignRequest scheduledAt(String scheduledAt) { this.scheduledAt = scheduledAt; return this; }
    public String getScheduledAt() { return scheduledAt; }
    public UpdateCampaignRequest sendRate(Integer sendRate) { this.sendRate = sendRate; return this; }
    public Integer getSendRate() { return sendRate; }
    public UpdateCampaignRequest sendAtLocalTime(Boolean sendAtLocalTime) { this.sendAtLocalTime = sendAtLocalTime; return this; }
    public Boolean getSendAtLocalTime() { return sendAtLocalTime; }
    public UpdateCampaignRequest abTestEnabled(Boolean abTestEnabled) { this.abTestEnabled = abTestEnabled; return this; }
    public Boolean getAbTestEnabled() { return abTestEnabled; }
    public UpdateCampaignRequest abTestVariants(List<AbTestVariant> abTestVariants) { this.abTestVariants = abTestVariants; return this; }
    public List<AbTestVariant> getAbTestVariants() { return abTestVariants; }
}
