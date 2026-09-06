package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * MessageWebhookEvent is the payload of the message.received and message.spam
 * events: a web form submission and the verdict scanning gave it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageWebhookEvent {

    private String event;

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("form_id")
    private String formId;

    @JsonProperty("form_name")
    private String formName;

    private String subject;

    private String body;

    private List<MessageField> fields;

    @JsonProperty("sender_name")
    private String senderName;

    @JsonProperty("sender_email")
    private String senderEmail;

    @JsonProperty("sender_phone")
    private String senderPhone;

    private String status;

    @JsonProperty("spam_score")
    private double spamScore;

    @JsonProperty("scan_reasons")
    private List<String> scanReasons;

    @JsonProperty("client_ip")
    private String clientIp;

    @JsonProperty("received_at")
    private String receivedAt;

    private String timestamp;

    public String getEvent() { return event; }
    public String getMessageId() { return messageId; }
    public String getFormId() { return formId; }
    public String getFormName() { return formName; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public List<MessageField> getFields() { return fields; }
    public String getSenderName() { return senderName; }
    public String getSenderEmail() { return senderEmail; }
    public String getSenderPhone() { return senderPhone; }
    public String getStatus() { return status; }
    public double getSpamScore() { return spamScore; }
    public List<String> getScanReasons() { return scanReasons; }
    public String getClientIp() { return clientIp; }
    public String getReceivedAt() { return receivedAt; }
    public String getTimestamp() { return timestamp; }
}
