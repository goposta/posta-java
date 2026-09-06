package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * UpdateSubscriberRequest changes a subscriber. The email address itself
 * cannot be changed; delete and re-add instead.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateSubscriberRequest {

    private String name;

    private String status;

    private String language;

    private String timezone;

    @JsonProperty("custom_fields")
    private Map<String, Object> customFields;

    public UpdateSubscriberRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateSubscriberRequest status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public UpdateSubscriberRequest language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public UpdateSubscriberRequest timezone(String timezone) { this.timezone = timezone; return this; }
    public String getTimezone() { return timezone; }
    public UpdateSubscriberRequest customFields(Map<String, Object> customFields) { this.customFields = customFields; return this; }
    public Map<String, Object> getCustomFields() { return customFields; }
}
