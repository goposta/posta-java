package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * RecordBounceRequest reports a bounce observed elsewhere. Type is "hard" or
 * "soft".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordBounceRequest {

    /**
     * EmailID is the UUID of the email that bounced.
     */
    @JsonProperty("email_id")
    private String emailId;

    /**
     * Recipient is the address that rejected or complained about it.
     */
    private String recipient;

    private String type;

    private String reason;

    public RecordBounceRequest emailId(String emailId) { this.emailId = emailId; return this; }
    public String getEmailId() { return emailId; }
    public RecordBounceRequest recipient(String recipient) { this.recipient = recipient; return this; }
    public String getRecipient() { return recipient; }
    public RecordBounceRequest type(String type) { this.type = type; return this; }
    public String getType() { return type; }
    public RecordBounceRequest reason(String reason) { this.reason = reason; return this; }
    public String getReason() { return reason; }
}
