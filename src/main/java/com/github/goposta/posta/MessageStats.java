package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MessageStats holds the workspace's message counters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageStats {

    private long total;

    private long unread;

    private long spam;

    private long forms;

    public long getTotal() { return total; }
    public long getUnread() { return unread; }
    public long getSpam() { return spam; }
    public long getForms() { return forms; }
}
