package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * BounceRatePoint is one day's bounces, split by kind.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BounceRatePoint {

    private String date;

    private long total;

    private long hard;

    private long soft;

    private long complaint;

    public String getDate() { return date; }
    public long getTotal() { return total; }
    public long getHard() { return hard; }
    public long getSoft() { return soft; }
    public long getComplaint() { return complaint; }
}
