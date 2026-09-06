package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UnsubscribeWebhookEvent is the payload of the email.unsubscribed event.
 * ListID names the unsubscribe list the recipient opted out of, if any.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsubscribeWebhookEvent {

    private String event;

    private String email;

    @JsonProperty("email_uuid")
    private String emailUuid;

    @JsonProperty("list_id")
    private Long listId;

    private String timestamp;

    public String getEvent() { return event; }
    public String getEmail() { return email; }
    public String getEmailUuid() { return emailUuid; }
    public Long getListId() { return listId; }
    public String getTimestamp() { return timestamp; }
}
