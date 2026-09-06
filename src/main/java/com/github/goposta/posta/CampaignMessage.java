package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CampaignMessage is one campaign send to one subscriber, with the engagement
 * timestamps recorded for it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignMessage {

    private long id;

    @JsonProperty("campaign_id")
    private long campaignId;

    @JsonProperty("subscriber_id")
    private long subscriberId;

    @JsonProperty("email_id")
    private Long emailId;

    private String status;

    private String variant;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("sent_at")
    private String sentAt;

    @JsonProperty("opened_at")
    private String openedAt;

    @JsonProperty("clicked_at")
    private String clickedAt;

    @JsonProperty("bounced_at")
    private String bouncedAt;

    @JsonProperty("unsubscribed_at")
    private String unsubscribedAt;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getCampaignId() { return campaignId; }
    public long getSubscriberId() { return subscriberId; }
    public Long getEmailId() { return emailId; }
    public String getStatus() { return status; }
    public String getVariant() { return variant; }
    public String getErrorMessage() { return errorMessage; }
    public String getSentAt() { return sentAt; }
    public String getOpenedAt() { return openedAt; }
    public String getClickedAt() { return clickedAt; }
    public String getBouncedAt() { return bouncedAt; }
    public String getUnsubscribedAt() { return unsubscribedAt; }
    public String getCreatedAt() { return createdAt; }
}
