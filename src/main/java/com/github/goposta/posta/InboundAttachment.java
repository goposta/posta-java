package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * InboundAttachment describes a file on an inbound message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InboundAttachment {

    private String filename;

    @JsonProperty("content_type")
    private String contentType;

    private long size;

    public String getFilename() { return filename; }
    public String getContentType() { return contentType; }
    public long getSize() { return size; }
}
