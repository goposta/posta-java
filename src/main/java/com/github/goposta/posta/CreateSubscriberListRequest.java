package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CreateSubscriberListRequest creates a list. Type is "static" (the default)
 * or "segment", in which case FilterRules defines membership.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSubscriberListRequest {

    private String name;

    private String description;

    private String type;

    @JsonProperty("filter_rules")
    private List<FilterRule> filterRules;

    public CreateSubscriberListRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateSubscriberListRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public CreateSubscriberListRequest type(String type) { this.type = type; return this; }
    public String getType() { return type; }
    public CreateSubscriberListRequest filterRules(List<FilterRule> filterRules) { this.filterRules = filterRules; return this; }
    public List<FilterRule> getFilterRules() { return filterRules; }
}
