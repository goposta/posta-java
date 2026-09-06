package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * CreateCampaignRequest schedules a bulk send. Set ScheduledAt to send later;
 * leave it nil and the campaign stays a draft until
 * [CampaignsService.Send] is called.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCampaignRequest {

    private String name;

    private String subject;

    @JsonProperty("from_email")
    private String fromEmail;

    @JsonProperty("from_name")
    private String fromName;

    /**
     * ListID names the subscriber list to send to.
     */
    @JsonProperty("list_id")
    private long listId;

    /**
     * TemplateID names the template to render.
     */
    @JsonProperty("template_id")
    private long templateId;

    /**
     * TemplateVersionID pins a specific version; nil uses the active one.
     */
    @JsonProperty("template_version_id")
    private Long templateVersionId;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    private String language;

    @JsonProperty("scheduled_at")
    private String scheduledAt;

    /**
     * SendRate caps deliveries per hour, to stay within a provider's limits.
     */
    @JsonProperty("send_rate")
    private int sendRate;

    /**
     * SendAtLocalTime staggers delivery so each subscriber receives the
     * campaign at the scheduled hour in their own timezone.
     */
    @JsonProperty("send_at_local_time")
    private boolean sendAtLocalTime;

    @JsonProperty("ab_test_enabled")
    private boolean abTestEnabled;

    @JsonProperty("ab_test_variants")
    private List<AbTestVariant> abTestVariants;

    public CreateCampaignRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateCampaignRequest subject(String subject) { this.subject = subject; return this; }
    public String getSubject() { return subject; }
    public CreateCampaignRequest fromEmail(String fromEmail) { this.fromEmail = fromEmail; return this; }
    public String getFromEmail() { return fromEmail; }
    public CreateCampaignRequest fromName(String fromName) { this.fromName = fromName; return this; }
    public String getFromName() { return fromName; }
    public CreateCampaignRequest listId(long listId) { this.listId = listId; return this; }
    public long getListId() { return listId; }
    public CreateCampaignRequest templateId(long templateId) { this.templateId = templateId; return this; }
    public long getTemplateId() { return templateId; }
    public CreateCampaignRequest templateVersionId(Long templateVersionId) { this.templateVersionId = templateVersionId; return this; }
    public Long getTemplateVersionId() { return templateVersionId; }
    public CreateCampaignRequest templateData(Map<String, Object> templateData) { this.templateData = templateData; return this; }
    public Map<String, Object> getTemplateData() { return templateData; }
    public CreateCampaignRequest language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public CreateCampaignRequest scheduledAt(String scheduledAt) { this.scheduledAt = scheduledAt; return this; }
    public String getScheduledAt() { return scheduledAt; }
    public CreateCampaignRequest sendRate(int sendRate) { this.sendRate = sendRate; return this; }
    public int getSendRate() { return sendRate; }
    public CreateCampaignRequest sendAtLocalTime(boolean sendAtLocalTime) { this.sendAtLocalTime = sendAtLocalTime; return this; }
    public boolean isSendAtLocalTime() { return sendAtLocalTime; }
    public CreateCampaignRequest abTestEnabled(boolean abTestEnabled) { this.abTestEnabled = abTestEnabled; return this; }
    public boolean isAbTestEnabled() { return abTestEnabled; }
    public CreateCampaignRequest abTestVariants(List<AbTestVariant> abTestVariants) { this.abTestVariants = abTestVariants; return this; }
    public List<AbTestVariant> getAbTestVariants() { return abTestVariants; }
}
