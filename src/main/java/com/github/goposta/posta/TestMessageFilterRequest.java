package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TestMessageFilterRequest dry-runs a candidate pattern over recent messages,
 * so a rule can be checked before it starts rejecting mail. Kind takes the
 * same values as [CreateMessageFilterRequest].
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestMessageFilterRequest {

    private String kind;

    private String pattern;

    @JsonProperty("case_sensitive")
    private boolean caseSensitive;

    /**
     * Limit caps how many recent messages are scanned.
     */
    private int limit;

    public TestMessageFilterRequest kind(String kind) { this.kind = kind; return this; }
    public String getKind() { return kind; }
    public TestMessageFilterRequest pattern(String pattern) { this.pattern = pattern; return this; }
    public String getPattern() { return pattern; }
    public TestMessageFilterRequest caseSensitive(boolean caseSensitive) { this.caseSensitive = caseSensitive; return this; }
    public boolean isCaseSensitive() { return caseSensitive; }
    public TestMessageFilterRequest limit(int limit) { this.limit = limit; return this; }
    public int getLimit() { return limit; }
}
