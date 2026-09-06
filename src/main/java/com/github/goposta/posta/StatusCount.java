package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * StatusCount is the number of emails in one delivery status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusCount {

    private String status;

    private long count;

    public String getStatus() { return status; }
    public long getCount() { return count; }
}
