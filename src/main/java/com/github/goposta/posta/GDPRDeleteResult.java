package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * GDPRDeleteResult reports how many records an erasure removed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GDPRDeleteResult {

    private long deleted;

    private String message;

    public long getDeleted() { return deleted; }
    public String getMessage() { return message; }
}
