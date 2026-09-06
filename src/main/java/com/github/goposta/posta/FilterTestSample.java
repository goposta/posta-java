package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * FilterTestSample is one message a candidate filter would have matched.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterTestSample {

    @JsonProperty("message_uuid")
    private String messageUuid;

    private String subject;

    @JsonProperty("sender_email")
    private String senderEmail;

    private String excerpt;

    public String getMessageUuid() { return messageUuid; }
    public String getSubject() { return subject; }
    public String getSenderEmail() { return senderEmail; }
    public String getExcerpt() { return excerpt; }
}
