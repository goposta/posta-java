package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * CreateSubscriberRequest adds a subscriber. Status defaults to "subscribed".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSubscriberRequest {

    private String email;

    private String name;

    private String status;

    private String language;

    private String timezone;

    @JsonProperty("custom_fields")
    private Map<String, Object> customFields;

    public CreateSubscriberRequest email(String email) { this.email = email; return this; }
    public String getEmail() { return email; }
    public CreateSubscriberRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateSubscriberRequest status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public CreateSubscriberRequest language(String language) { this.language = language; return this; }
    public String getLanguage() { return language; }
    public CreateSubscriberRequest timezone(String timezone) { this.timezone = timezone; return this; }
    public String getTimezone() { return timezone; }
    public CreateSubscriberRequest customFields(Map<String, Object> customFields) { this.customFields = customFields; return this; }
    public Map<String, Object> getCustomFields() { return customFields; }
}
