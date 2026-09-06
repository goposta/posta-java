package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SegmentPreview reports how many subscribers a set of filter rules would
 * select, so a segment can be checked before it is saved.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SegmentPreview {

    private long count;

    public long getCount() { return count; }
}
