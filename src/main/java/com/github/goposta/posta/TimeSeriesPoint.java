package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TimeSeriesPoint is one bucket of a time series.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSeriesPoint {

    private String time;

    private long count;

    public String getTime() { return time; }
    public long getCount() { return count; }
}
