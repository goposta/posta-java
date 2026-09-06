package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DailyCount is one day's total in a volume series.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyCount {

    private String date;

    private long count;

    public String getDate() { return date; }
    public long getCount() { return count; }
}
