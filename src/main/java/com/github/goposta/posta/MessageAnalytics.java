package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * MessageAnalytics is submission volume over time, with the spam share.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageAnalytics {

    private long total;

    private long spam;

    private List<MessageDailyCount> daily;

    public long getTotal() { return total; }
    public long getSpam() { return spam; }
    public List<MessageDailyCount> getDaily() { return daily; }
}
