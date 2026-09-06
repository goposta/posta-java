package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * NotificationCounts is the unread and open notification totals, for a badge.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationCounts {

    private long unread;

    private long open;

    public long getUnread() { return unread; }
    public long getOpen() { return open; }
}
