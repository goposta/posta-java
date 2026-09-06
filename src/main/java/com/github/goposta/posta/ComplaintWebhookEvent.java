package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ComplaintWebhookEvent is the payload of the email.complained event.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplaintWebhookEvent {

    private String event;

    private String email;

    @JsonProperty("email_uuid")
    private String emailUuid;

    private String timestamp;

    public String getEvent() { return event; }
    public String getEmail() { return email; }
    public String getEmailUuid() { return emailUuid; }
    public String getTimestamp() { return timestamp; }
}
