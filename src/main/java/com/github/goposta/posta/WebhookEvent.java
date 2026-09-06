package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * WebhookEvent is the payload of the email.sent and email.failed events.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookEvent {

    private String event;

    @JsonProperty("email_id")
    private String emailId;

    private String timestamp;

    public String getEvent() { return event; }
    public String getEmailId() { return emailId; }
    public String getTimestamp() { return timestamp; }
}
