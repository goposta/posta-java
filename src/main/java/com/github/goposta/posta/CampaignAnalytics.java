package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CampaignAnalytics holds the headline rates and counts for a campaign.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignAnalytics {

    @JsonProperty("total_messages")
    private long totalMessages;

    @JsonProperty("sent_messages")
    private long sentMessages;

    @JsonProperty("failed_messages")
    private long failedMessages;

    @JsonProperty("opened_messages")
    private long openedMessages;

    @JsonProperty("clicked_messages")
    private long clickedMessages;

    @JsonProperty("bounced_messages")
    private long bouncedMessages;

    private long unsubscribed;

    @JsonProperty("delivery_rate")
    private double deliveryRate;

    @JsonProperty("open_rate")
    private double openRate;

    @JsonProperty("click_rate")
    private double clickRate;

    @JsonProperty("bounce_rate")
    private double bounceRate;

    @JsonProperty("unsubscribe_rate")
    private double unsubscribeRate;

    public long getTotalMessages() { return totalMessages; }
    public long getSentMessages() { return sentMessages; }
    public long getFailedMessages() { return failedMessages; }
    public long getOpenedMessages() { return openedMessages; }
    public long getClickedMessages() { return clickedMessages; }
    public long getBouncedMessages() { return bouncedMessages; }
    public long getUnsubscribed() { return unsubscribed; }
    public double getDeliveryRate() { return deliveryRate; }
    public double getOpenRate() { return openRate; }
    public double getClickRate() { return clickRate; }
    public double getBounceRate() { return bounceRate; }
    public double getUnsubscribeRate() { return unsubscribeRate; }
}
