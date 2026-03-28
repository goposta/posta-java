package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an email attachment (base64-encoded content).
 */
public class Attachment {

    private String filename;
    private String content;

    @JsonProperty("content_type")
    private String contentType;

    public Attachment filename(String filename) { this.filename = filename; return this; }
    public Attachment content(String content) { this.content = content; return this; }
    public Attachment contentType(String contentType) { this.contentType = contentType; return this; }

    public String getFilename() { return filename; }
    public String getContent() { return content; }
    public String getContentType() { return contentType; }
}
