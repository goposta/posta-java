package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CampaignWithStats is a campaign together with its delivery counters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignWithStats extends Campaign {

    @JsonProperty("total_recipients")
    private long totalRecipients;

    @JsonProperty("sent_count")
    private long sentCount;

    @JsonProperty("failed_count")
    private long failedCount;

    @JsonProperty("opened_count")
    private long openedCount;

    @JsonProperty("clicked_count")
    private long clickedCount;

    @JsonProperty("bounced_count")
    private long bouncedCount;

    @JsonProperty("unsubscribed_count")
    private long unsubscribedCount;

    public long getTotalRecipients() { return totalRecipients; }
    public long getSentCount() { return sentCount; }
    public long getFailedCount() { return failedCount; }
    public long getOpenedCount() { return openedCount; }
    public long getClickedCount() { return clickedCount; }
    public long getBouncedCount() { return bouncedCount; }
    public long getUnsubscribedCount() { return unsubscribedCount; }
}
