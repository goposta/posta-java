package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * InboundEmail is a message Posta received, either over its inbound SMTP
 * listener or by webhook relay from an external provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InboundEmail {

    private long id;

    private String uuid;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("domain_id")
    private long domainId;

    @JsonProperty("message_id")
    private String messageId;

    private String sender;

    private List<String> recipients;

    private String subject;

    @JsonProperty("html_body")
    private String htmlBody;

    @JsonProperty("text_body")
    private String textBody;

    @JsonProperty("headers_json")
    private String headersJson;

    @JsonProperty("attachments_json")
    private String attachmentsJson;

    @JsonProperty("raw_storage_key")
    private String rawStorageKey;

    private long size;

    private String source;

    @JsonProperty("spam_score")
    private Double spamScore;

    private String status;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("retry_count")
    private int retryCount;

    @JsonProperty("forwarded_at")
    private String forwardedAt;

    @JsonProperty("received_at")
    private String receivedAt;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getUuid() { return uuid; }
    public long getUserId() { return userId; }
    public Long getWorkspaceId() { return workspaceId; }
    public long getDomainId() { return domainId; }
    public String getMessageId() { return messageId; }
    public String getSender() { return sender; }
    public List<String> getRecipients() { return recipients; }
    public String getSubject() { return subject; }
    public String getHtmlBody() { return htmlBody; }
    public String getTextBody() { return textBody; }
    public String getHeadersJson() { return headersJson; }
    public String getAttachmentsJson() { return attachmentsJson; }
    public String getRawStorageKey() { return rawStorageKey; }
    public long getSize() { return size; }
    public String getSource() { return source; }
    public Double getSpamScore() { return spamScore; }
    public String getStatus() { return status; }
    public String getErrorMessage() { return errorMessage; }
    public int getRetryCount() { return retryCount; }
    public String getForwardedAt() { return forwardedAt; }
    public String getReceivedAt() { return receivedAt; }
    public String getCreatedAt() { return createdAt; }
}
