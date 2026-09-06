package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * FilterTestResult reports what a candidate filter would have caught.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterTestResult {

    private int scanned;

    private int matched;

    private List<FilterTestSample> samples;

    public int getScanned() { return scanned; }
    public int getMatched() { return matched; }
    public List<FilterTestSample> getSamples() { return samples; }
}
