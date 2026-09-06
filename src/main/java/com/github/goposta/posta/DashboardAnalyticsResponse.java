package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * DashboardAnalyticsResponse is the trend view behind the dashboard charts.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardAnalyticsResponse {

    @JsonProperty("delivery_rate_trends")
    private List<DeliveryRatePoint> deliveryRateTrends;

    @JsonProperty("bounce_rate_trends")
    private List<BounceRatePoint> bounceRateTrends;

    @JsonProperty("latency_percentiles")
    private Map<String, Double> latencyPercentiles;

    public List<DeliveryRatePoint> getDeliveryRateTrends() { return deliveryRateTrends; }
    public List<BounceRatePoint> getBounceRateTrends() { return bounceRateTrends; }
    public Map<String, Double> getLatencyPercentiles() { return latencyPercentiles; }
}
