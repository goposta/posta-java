package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateAnnouncementRequest broadcasts a notice to every user. Severity is
 * "info", "warning", or "critical".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAnnouncementRequest {

    private String title;

    private String message;

    private String severity;

    private String link;

    public CreateAnnouncementRequest title(String title) { this.title = title; return this; }
    public String getTitle() { return title; }
    public CreateAnnouncementRequest message(String message) { this.message = message; return this; }
    public String getMessage() { return message; }
    public CreateAnnouncementRequest severity(String severity) { this.severity = severity; return this; }
    public String getSeverity() { return severity; }
    public CreateAnnouncementRequest link(String link) { this.link = link; return this; }
    public String getLink() { return link; }
}
