package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * UpdateMessageFilterRequest changes a spam rule. Nil fields are left
 * unchanged.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateMessageFilterRequest {

    private String pattern;

    private List<String> fields;

    private String action;

    private Double score;

    @JsonProperty("case_sensitive")
    private Boolean caseSensitive;

    private Boolean enabled;

    private String note;

    public UpdateMessageFilterRequest pattern(String pattern) { this.pattern = pattern; return this; }
    public String getPattern() { return pattern; }
    public UpdateMessageFilterRequest fields(List<String> fields) { this.fields = fields; return this; }
    public List<String> getFields() { return fields; }
    public UpdateMessageFilterRequest action(String action) { this.action = action; return this; }
    public String getAction() { return action; }
    public UpdateMessageFilterRequest score(Double score) { this.score = score; return this; }
    public Double getScore() { return score; }
    public UpdateMessageFilterRequest caseSensitive(Boolean caseSensitive) { this.caseSensitive = caseSensitive; return this; }
    public Boolean getCaseSensitive() { return caseSensitive; }
    public UpdateMessageFilterRequest enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public Boolean getEnabled() { return enabled; }
    public UpdateMessageFilterRequest note(String note) { this.note = note; return this; }
    public String getNote() { return note; }
}
