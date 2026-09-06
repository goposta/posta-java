package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * Campaign is a bulk send to a subscriber list. Status is one of "draft",
 * "scheduled", "sending", "paused", "completed", "cancelled", "failed".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Campaign {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;

    private String subject;

    @JsonProperty("from_email")
    private String fromEmail;

    @JsonProperty("from_name")
    private String fromName;

    @JsonProperty("list_id")
    private long listId;

    @JsonProperty("template_id")
    private long templateId;

    @JsonProperty("template_version_id")
    private Long templateVersionId;

    @JsonProperty("template_data")
    private Map<String, Object> templateData;

    private String language;

    private String status;

    @JsonProperty("send_rate")
    private int sendRate;

    @JsonProperty("send_at_local_time")
    private boolean sendAtLocalTime;

    @JsonProperty("ab_test_enabled")
    private boolean abTestEnabled;

    @JsonProperty("ab_test_variants")
    private List<AbTestVariant> abTestVariants;

    @JsonProperty("ab_test_winner")
    private String abTestWinner;

    @JsonProperty("scheduled_at")
    private String scheduledAt;

    @JsonProperty("started_at")
    private String startedAt;

    @JsonProperty("completed_at")
    private String completedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Campaign id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Campaign userId(long userId) { this.userId = userId; return this; }
    public long getUserId() { return userId; }
    public Campaign workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public Campaign name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public Campaign subject(String subject) { this.subject = subject; return this; }
    public String getSubject() { return subject; }
    public Campaign fromEmail(String fromEmail) { this.fromEmail = fromEmail; return this; }
    public String getFromEmail() { return fromEmail; }
    public Campaign fromName(String fromName) { this.fromName = fromName; return this; }
    public String getFromName() { return fromName; }
    public Campaign listId(long listId) { this.listId = listId; return this; }
    public long getListId() { return listId; }
    public Campaign templateId(long templateId) { this.templateId = templateId; return this; }
    public long getTemplateId() { return templateId; }
    public Campaign templateVersionId(Long templateVersionId) { this.templateVersionId = templateVersionId; return this; }
    public Long getTemplateVersionId() { return templateVersionId; }
    public Campaign templateData(Map<String, Object> templateData) { this.templateData = templateData; return this; }
    public Map<String, Object> getTemplateData() { return templateData; }
    public Campaign language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public Campaign status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public Campaign sendRate(int sendRate) { this.sendRate = sendRate; return this; }
    public int getSendRate() { return sendRate; }
    public Campaign sendAtLocalTime(boolean sendAtLocalTime) { this.sendAtLocalTime = sendAtLocalTime; return this; }
    public boolean isSendAtLocalTime() { return sendAtLocalTime; }
    public Campaign abTestEnabled(boolean abTestEnabled) { this.abTestEnabled = abTestEnabled; return this; }
    public boolean isAbTestEnabled() { return abTestEnabled; }
    public Campaign abTestVariants(List<AbTestVariant> abTestVariants) { this.abTestVariants = abTestVariants; return this; }
    public List<AbTestVariant> getAbTestVariants() { return abTestVariants; }
    public Campaign abTestWinner(String abTestWinner) { this.abTestWinner = abTestWinner; return this; }
    public String getAbTestWinner() { return abTestWinner; }
    public Campaign scheduledAt(String scheduledAt) { this.scheduledAt = scheduledAt; return this; }
    public String getScheduledAt() { return scheduledAt; }
    public Campaign startedAt(String startedAt) { this.startedAt = startedAt; return this; }
    public String getStartedAt() { return startedAt; }
    public Campaign completedAt(String completedAt) { this.completedAt = completedAt; return this; }
    public String getCompletedAt() { return completedAt; }
    public Campaign createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public Campaign updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
