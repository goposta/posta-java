package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MessageReply is an operator reply sent on a message thread, or an inbound
 * message that continued it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageReply {

    private long id;

    private String uuid;

    @JsonProperty("message_id")
    private long messageId;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("author_id")
    private long authorId;

    private String kind;

    private String subject;

    @JsonProperty("from_addr")
    private String fromAddr;

    @JsonProperty("to_addr")
    private String toAddr;

    @JsonProperty("html_body")
    private String htmlBody;

    @JsonProperty("text_body")
    private String textBody;

    @JsonProperty("email_uuid")
    private String emailUuid;

    @JsonProperty("inbound_email_id")
    private Long inboundEmailId;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getUuid() { return uuid; }
    public long getMessageId() { return messageId; }
    public Long getWorkspaceId() { return workspaceId; }
    public long getAuthorId() { return authorId; }
    public String getKind() { return kind; }
    public String getSubject() { return subject; }
    public String getFromAddr() { return fromAddr; }
    public String getToAddr() { return toAddr; }
    public String getHtmlBody() { return htmlBody; }
    public String getTextBody() { return textBody; }
    public String getEmailUuid() { return emailUuid; }
    public Long getInboundEmailId() { return inboundEmailId; }
    public String getCreatedAt() { return createdAt; }
}
