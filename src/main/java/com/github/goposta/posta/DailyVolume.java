package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DailyVolume is one day of send volume.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyVolume {

    private String date;

    private long sent;

    private long failed;

    public String getDate() { return date; }
    public long getSent() { return sent; }
    public long getFailed() { return failed; }
}
