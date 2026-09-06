package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * CampaignAnalyticsResponse is the full analytics view of a campaign: headline
 * rates, open and click series over time, per-link click counts, and — for an
 * A/B test — the same figures per variant.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignAnalyticsResponse {

    private CampaignAnalytics analytics;

    @JsonProperty("open_series")
    private List<TimeSeriesPoint> openSeries;

    @JsonProperty("click_series")
    private List<TimeSeriesPoint> clickSeries;

    private List<CampaignLink> links;

    @JsonProperty("variant_analytics")
    private Map<String, CampaignAnalytics> variantAnalytics;

    public CampaignAnalytics getAnalytics() { return analytics; }
    public List<TimeSeriesPoint> getOpenSeries() { return openSeries; }
    public List<TimeSeriesPoint> getClickSeries() { return clickSeries; }
    public List<CampaignLink> getLinks() { return links; }
    public Map<String, CampaignAnalytics> getVariantAnalytics() { return variantAnalytics; }
}
