package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MessageDailyCount is one day's submission volume.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDailyCount {

    private String day;

    private long total;

    private long spam;

    public String getDay() { return day; }
    public long getTotal() { return total; }
    public long getSpam() { return spam; }
}
