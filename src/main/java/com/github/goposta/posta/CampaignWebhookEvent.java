package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CampaignWebhookEvent is the payload of the campaign.started and
 * campaign.completed events.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignWebhookEvent {

    private String event;

    @JsonProperty("campaign_id")
    private long campaignId;

    private String name;

    private String timestamp;

    public String getEvent() { return event; }
    public long getCampaignId() { return campaignId; }
    public String getName() { return name; }
    public String getTimestamp() { return timestamp; }
}
