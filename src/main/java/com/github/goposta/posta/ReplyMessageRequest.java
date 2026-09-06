package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ReplyMessageRequest is an operator reply, sent to the submitter through the
 * workspace's normal email pipeline and recorded on the thread.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplyMessageRequest {

    private String subject;

    private String text;

    private String html;

    public ReplyMessageRequest subject(String subject) { this.subject = subject; return this; }
    public String getSubject() { return subject; }
    public ReplyMessageRequest text(String text) { this.text = text; return this; }
    public String getText() { return text; }
    public ReplyMessageRequest html(String html) { this.html = html; return this; }
    public String getHtml() { return html; }
}
