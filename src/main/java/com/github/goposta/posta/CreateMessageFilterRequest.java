package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CreateMessageFilterRequest adds a spam rule.
 *
 * Kind selects what Pattern matches: "keyword", "phrase", "regex", "email",
 * "domain", or "ip". Action is "score", "flag", "quarantine", "reject", or
 * "allowlist". FormID limits the rule to one form; leave it nil to apply it
 * workspace wide.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateMessageFilterRequest {

    private String kind;

    private String pattern;

    /**
     * Fields names the submission fields to test; empty tests them all.
     */
    private List<String> fields;

    private String action;

    private Double score;

    @JsonProperty("case_sensitive")
    private boolean caseSensitive;

    @JsonProperty("form_id")
    private Long formId;

    private String note;

    public CreateMessageFilterRequest kind(String kind) { this.kind = kind; return this; }
    public String getKind() { return kind; }
    public CreateMessageFilterRequest pattern(String pattern) { this.pattern = pattern; return this; }
    public String getPattern() { return pattern; }
    public CreateMessageFilterRequest fields(List<String> fields) { this.fields = fields; return this; }
    public List<String> getFields() { return fields; }
    public CreateMessageFilterRequest action(String action) { this.action = action; return this; }
    public String getAction() { return action; }
    public CreateMessageFilterRequest score(Double score) { this.score = score; return this; }
    public Double getScore() { return score; }
    public CreateMessageFilterRequest caseSensitive(boolean caseSensitive) { this.caseSensitive = caseSensitive; return this; }
    public boolean isCaseSensitive() { return caseSensitive; }
    public CreateMessageFilterRequest formId(Long formId) { this.formId = formId; return this; }
    public Long getFormId() { return formId; }
    public CreateMessageFilterRequest note(String note) { this.note = note; return this; }
    public String getNote() { return note; }
}
