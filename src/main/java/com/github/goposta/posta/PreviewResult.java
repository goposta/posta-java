package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * PreviewResult is rendered template output.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreviewResult {

    private String subject;

    private String html;

    private String text;

    public String getSubject() { return subject; }
    public String getHtml() { return html; }
    public String getText() { return text; }
}
