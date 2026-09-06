package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * UpdateSubscriberListRequest changes a list. The type cannot be changed after
 * creation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateSubscriberListRequest {

    private String name;

    private String description;

    @JsonProperty("filter_rules")
    private List<FilterRule> filterRules;

    public UpdateSubscriberListRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateSubscriberListRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public UpdateSubscriberListRequest filterRules(List<FilterRule> filterRules) { this.filterRules = filterRules; return this; }
    public List<FilterRule> getFilterRules() { return filterRules; }
}
