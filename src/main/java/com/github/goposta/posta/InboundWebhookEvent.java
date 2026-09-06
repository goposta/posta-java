package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * InboundWebhookEvent is the payload of the email.inbound event: a received
 * message, already parsed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InboundWebhookEvent {

    private String event;

    @JsonProperty("inbound_id")
    private String inboundId;

    @JsonProperty("message_id")
    private String messageId;

    private String from;

    private List<String> to;

    private String subject;

    @JsonProperty("html_body")
    private String htmlBody;

    @JsonProperty("text_body")
    private String textBody;

    private Map<String, Object> headers;

    private List<InboundAttachment> attachments;

    private long size;

    private String source;

    @JsonProperty("received_at")
    private String receivedAt;

    private String timestamp;

    public String getEvent() { return event; }
    public String getInboundId() { return inboundId; }
    public String getMessageId() { return messageId; }
    public String getFrom() { return from; }
    public List<String> getTo() { return to; }
    public String getSubject() { return subject; }
    public String getHtmlBody() { return htmlBody; }
    public String getTextBody() { return textBody; }
    public Map<String, Object> getHeaders() { return headers; }
    public List<InboundAttachment> getAttachments() { return attachments; }
    public long getSize() { return size; }
    public String getSource() { return source; }
    public String getReceivedAt() { return receivedAt; }
    public String getTimestamp() { return timestamp; }
}
