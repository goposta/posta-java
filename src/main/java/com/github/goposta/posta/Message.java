package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Message is a web form submission. State tracks triage ("new", "open",
 * "replied", "closed", "spam"); Status records the spam verdict ("received",
 * "flagged", "spam", "rejected").
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private long id;

    private String uuid;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("form_id")
    private long formId;

    private Form form;

    private String subject;

    private String body;

    private List<MessageField> fields;

    private List<MessageAttachment> attachments;

    @JsonProperty("sender_name")
    private String senderName;

    @JsonProperty("sender_email")
    private String senderEmail;

    @JsonProperty("sender_phone")
    private String senderPhone;

    private String state;

    private String status;

    @JsonProperty("spam_score")
    private double spamScore;

    @JsonProperty("scan_reasons")
    private List<String> scanReasons;

    @JsonProperty("assigned_to_id")
    private Long assignedToId;

    @JsonProperty("client_ip")
    private String clientIp;

    private String origin;

    private String referer;

    @JsonProperty("user_agent")
    private String userAgent;

    private List<MessageReply> replies;

    @JsonProperty("reply_count")
    private int replyCount;

    @JsonProperty("read_at")
    private String readAt;

    @JsonProperty("replied_at")
    private String repliedAt;

    @JsonProperty("notified_at")
    private String notifiedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getId() { return id; }
    public String getUuid() { return uuid; }
    public Long getWorkspaceId() { return workspaceId; }
    public long getFormId() { return formId; }
    public Form getForm() { return form; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public List<MessageField> getFields() { return fields; }
    public List<MessageAttachment> getAttachments() { return attachments; }
    public String getSenderName() { return senderName; }
    public String getSenderEmail() { return senderEmail; }
    public String getSenderPhone() { return senderPhone; }
    public String getState() { return state; }
    public String getStatus() { return status; }
    public double getSpamScore() { return spamScore; }
    public List<String> getScanReasons() { return scanReasons; }
    public Long getAssignedToId() { return assignedToId; }
    public String getClientIp() { return clientIp; }
    public String getOrigin() { return origin; }
    public String getReferer() { return referer; }
    public String getUserAgent() { return userAgent; }
    public List<MessageReply> getReplies() { return replies; }
    public int getReplyCount() { return replyCount; }
    public String getReadAt() { return readAt; }
    public String getRepliedAt() { return repliedAt; }
    public String getNotifiedAt() { return notifiedAt; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
