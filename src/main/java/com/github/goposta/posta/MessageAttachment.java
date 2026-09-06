package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MessageAttachment describes a file submitted with a form. Content is present
 * only for small inline attachments; otherwise fetch it with
 * [MessagesService.DownloadAttachment].
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageAttachment {

    private String filename;

    @JsonProperty("content_type")
    private String contentType;

    private long size;

    @JsonProperty("storage_key")
    private String storageKey;

    private String content;

    public String getFilename() { return filename; }
    public String getContentType() { return contentType; }
    public long getSize() { return size; }
    public String getStorageKey() { return storageKey; }
    public String getContent() { return content; }
}
