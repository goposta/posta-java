package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CampaignLink is a tracked link in a campaign and how often it was clicked.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignLink {

    private long id;

    @JsonProperty("campaign_id")
    private long campaignId;

    private String hash;

    @JsonProperty("original_url")
    private String originalUrl;

    @JsonProperty("click_count")
    private long clickCount;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getCampaignId() { return campaignId; }
    public String getHash() { return hash; }
    public String getOriginalUrl() { return originalUrl; }
    public long getClickCount() { return clickCount; }
    public String getCreatedAt() { return createdAt; }
}
