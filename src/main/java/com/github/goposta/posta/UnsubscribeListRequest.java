package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UnsubscribeListRequest creates or changes an unsubscribe list. PublicName is
 * what a recipient sees on the opt-out page.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsubscribeListRequest {

    private String name;

    @JsonProperty("public_name")
    private String publicName;

    private String description;

    private Boolean active;

    public UnsubscribeListRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UnsubscribeListRequest publicName(String publicName) { this.publicName = publicName; return this; }
    public String getPublicName() { return publicName; }
    public UnsubscribeListRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public UnsubscribeListRequest active(Boolean active) { this.active = active; return this; }
    public Boolean getActive() { return active; }
}
