package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * MessageFilter is a spam rule applied to incoming form submissions. Kind
 * selects what the pattern matches ("keyword", "phrase", "regex", "email",
 * "domain", "ip"); Action is "score", "flag", "quarantine", "reject", or
 * "allowlist".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageFilter {

    private long id;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("form_id")
    private Long formId;

    private String kind;

    private String pattern;

    private List<String> fields;

    private String action;

    private double score;

    @JsonProperty("case_sensitive")
    private boolean caseSensitive;

    private boolean enabled;

    private String note;

    @JsonProperty("hit_count")
    private long hitCount;

    @JsonProperty("last_hit_at")
    private String lastHitAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public MessageFilter id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public MessageFilter workspaceId(Long workspaceId) { this.workspaceId = workspaceId; return this; }
    public Long getWorkspaceId() { return workspaceId; }
    public MessageFilter formId(Long formId) { this.formId = formId; return this; }
    public Long getFormId() { return formId; }
    public MessageFilter kind(String kind) { this.kind = kind; return this; }
    public String getKind() { return kind; }
    public MessageFilter pattern(String pattern) { this.pattern = pattern; return this; }
    public String getPattern() { return pattern; }
    public MessageFilter fields(List<String> fields) { this.fields = fields; return this; }
    public List<String> getFields() { return fields; }
    public MessageFilter action(String action) { this.action = action; return this; }
    public String getAction() { return action; }
    public MessageFilter score(double score) { this.score = score; return this; }
    public double getScore() { return score; }
    public MessageFilter caseSensitive(boolean caseSensitive) { this.caseSensitive = caseSensitive; return this; }
    public boolean isCaseSensitive() { return caseSensitive; }
    public MessageFilter enabled(boolean enabled) { this.enabled = enabled; return this; }
    public boolean isEnabled() { return enabled; }
    public MessageFilter note(String note) { this.note = note; return this; }
    public String getNote() { return note; }
    public MessageFilter hitCount(long hitCount) { this.hitCount = hitCount; return this; }
    public long getHitCount() { return hitCount; }
    public MessageFilter lastHitAt(String lastHitAt) { this.lastHitAt = lastHitAt; return this; }
    public String getLastHitAt() { return lastHitAt; }
    public MessageFilter createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public String getCreatedAt() { return createdAt; }
    public MessageFilter updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
    public String getUpdatedAt() { return updatedAt; }
}
