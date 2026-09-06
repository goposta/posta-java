package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * AnalyticsResponse is the email volume view: a daily series plus the current
 * breakdown by delivery status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalyticsResponse {

    @JsonProperty("daily_counts")
    private List<DailyCount> dailyCounts;

    @JsonProperty("status_breakdown")
    private List<StatusCount> statusBreakdown;

    public List<DailyCount> getDailyCounts() { return dailyCounts; }
    public List<StatusCount> getStatusBreakdown() { return statusBreakdown; }
}
