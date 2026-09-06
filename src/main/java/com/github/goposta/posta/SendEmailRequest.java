package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Request body for sending a single email.
 */
public class SendEmailRequest {

    private String from;
    private List<String> to;
    private String subject;
    private String html;
    private String text;
    private List<Attachment> attachments;
    private Map<String, String> headers;

    /**
     * Configures the {@code List-Unsubscribe} / {@code List-Unsubscribe-Post}
     * headers. Supersedes the deprecated {@link #listUnsubscribeUrl} /
     * {@link #listUnsubscribePost} fields.
     */
    private Unsubscribe unsubscribe;

    /** @deprecated Use {@link Unsubscribe#url(String)} via {@link #unsubscribe(Unsubscribe)}. */
    @Deprecated
    @JsonProperty("list_unsubscribe_url")
    private String listUnsubscribeUrl;

    /** @deprecated Use {@link Unsubscribe#oneClick(Boolean)} via {@link #unsubscribe(Unsubscribe)}. */
    @Deprecated
    @JsonProperty("list_unsubscribe_post")
    private Boolean listUnsubscribePost;

    @JsonProperty("send_at")
    private String sendAt;

    /**
     * Optional: auto-add the recipient to a named subscriber list (created on
     * first use). Per-list opt-outs are honored; a suppressed recipient causes
     * the send to be skipped (see {@link SendResponse#getSkipped()}). Only
     * applied when {@code to} has a single address.
     */
    private String list;

    public SendEmailRequest from(String from) { this.from = from; return this; }
    public SendEmailRequest to(List<String> to) { this.to = to; return this; }
    public SendEmailRequest subject(String subject) { this.subject = subject; return this; }
    public SendEmailRequest html(String html) { this.html = html; return this; }
    public SendEmailRequest text(String text) { this.text = text; return this; }
    public SendEmailRequest attachments(List<Attachment> attachments) { this.attachments = attachments; return this; }
    public SendEmailRequest headers(Map<String, String> headers) { this.headers = headers; return this; }
    public SendEmailRequest unsubscribe(Unsubscribe unsubscribe) { this.unsubscribe = unsubscribe; return this; }
    /** @deprecated Use {@link #unsubscribe(Unsubscribe)}. */
    @Deprecated
    public SendEmailRequest listUnsubscribeUrl(String url) { this.listUnsubscribeUrl = url; return this; }
    /** @deprecated Use {@link #unsubscribe(Unsubscribe)}. */
    @Deprecated
    public SendEmailRequest listUnsubscribePost(Boolean post) { this.listUnsubscribePost = post; return this; }
    public SendEmailRequest sendAt(String sendAt) { this.sendAt = sendAt; return this; }
    public SendEmailRequest list(String list) { this.list = list; return this; }

    public String getFrom() { return from; }
    public List<String> getTo() { return to; }
    public String getSubject() { return subject; }
    public String getHtml() { return html; }
    public String getText() { return text; }
    public List<Attachment> getAttachments() { return attachments; }
    public Map<String, String> getHeaders() { return headers; }
    public Unsubscribe getUnsubscribe() { return unsubscribe; }
    public String getListUnsubscribeUrl() { return listUnsubscribeUrl; }
    public Boolean getListUnsubscribePost() { return listUnsubscribePost; }
    public String getSendAt() { return sendAt; }
    public String getList() { return list; }
}
