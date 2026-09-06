package com.github.goposta.posta;

/**
 * Rendered template returned by {@code POST /emails/preview}.
 */
public class PreviewResponse {

    private String subject;
    private String html;
    private String text;

    public String getSubject() { return subject; }
    public String getHtml() { return html; }
    public String getText() { return text; }

    @Override
    public String toString() {
        return "PreviewResponse{subject='" + subject + "'}";
    }
}
