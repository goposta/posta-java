package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MarkSpamRequest quarantines a message. Set CreateFilter to also derive a
 * reusable filter from it, so later submissions like it are caught on arrival;
 * Kind ("keyword", "phrase", "email", "domain", or "ip") and Pattern then
 * describe the rule to create.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarkSpamRequest {

    @JsonProperty("create_filter")
    private boolean createFilter;

    private String kind;

    private String pattern;

    public MarkSpamRequest createFilter(boolean createFilter) { this.createFilter = createFilter; return this; }
    public boolean isCreateFilter() { return createFilter; }
    public MarkSpamRequest kind(String kind) { this.kind = kind; return this; }
    public String getKind() { return kind; }
    public MarkSpamRequest pattern(String pattern) { this.pattern = pattern; return this; }
    public String getPattern() { return pattern; }
}
