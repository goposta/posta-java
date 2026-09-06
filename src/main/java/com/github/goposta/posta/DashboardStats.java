package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * DashboardStats is the workspace's headline counters, as shown on the
 * dashboard landing page.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardStats {

    @JsonProperty("total_emails")
    private long totalEmails;

    @JsonProperty("sent_emails")
    private long sentEmails;

    @JsonProperty("failed_emails")
    private long failedEmails;

    @JsonProperty("queued_emails")
    private long queuedEmails;

    @JsonProperty("processing_emails")
    private long processingEmails;

    @JsonProperty("suppressed_emails")
    private long suppressedEmails;

    @JsonProperty("failure_rate")
    private double failureRate;

    @JsonProperty("bounce_rate")
    private double bounceRate;

    @JsonProperty("total_bounces")
    private long totalBounces;

    @JsonProperty("total_suppressions")
    private long totalSuppressions;

    @JsonProperty("total_templates")
    private long totalTemplates;

    @JsonProperty("total_domains")
    private long totalDomains;

    @JsonProperty("unverified_domains")
    private long unverifiedDomains;

    @JsonProperty("total_smtp_servers")
    private long totalSmtpServers;

    @JsonProperty("total_webhooks")
    private long totalWebhooks;

    @JsonProperty("total_api_keys")
    private long totalApiKeys;

    @JsonProperty("active_api_keys")
    private long activeApiKeys;

    @JsonProperty("expiring_api_keys")
    private long expiringApiKeys;

    @JsonProperty("total_contacts")
    private long totalContacts;

    @JsonProperty("total_subscribers")
    private long totalSubscribers;

    @JsonProperty("total_campaigns")
    private long totalCampaigns;

    @JsonProperty("total_inbound")
    private long totalInbound;

    @JsonProperty("forwarded_inbound")
    private long forwardedInbound;

    @JsonProperty("failed_inbound")
    private long failedInbound;

    @JsonProperty("total_forms")
    private long totalForms;

    @JsonProperty("total_messages")
    private long totalMessages;

    @JsonProperty("unread_messages")
    private long unreadMessages;

    @JsonProperty("spam_messages")
    private long spamMessages;

    @JsonProperty("daily_volume")
    private List<DailyVolume> dailyVolume;

    @JsonProperty("webhook_deliveries")
    private Map<String, Long> webhookDeliveries;

    private WorkspaceFeatures features;

    public long getTotalEmails() { return totalEmails; }
    public long getSentEmails() { return sentEmails; }
    public long getFailedEmails() { return failedEmails; }
    public long getQueuedEmails() { return queuedEmails; }
    public long getProcessingEmails() { return processingEmails; }
    public long getSuppressedEmails() { return suppressedEmails; }
    public double getFailureRate() { return failureRate; }
    public double getBounceRate() { return bounceRate; }
    public long getTotalBounces() { return totalBounces; }
    public long getTotalSuppressions() { return totalSuppressions; }
    public long getTotalTemplates() { return totalTemplates; }
    public long getTotalDomains() { return totalDomains; }
    public long getUnverifiedDomains() { return unverifiedDomains; }
    public long getTotalSmtpServers() { return totalSmtpServers; }
    public long getTotalWebhooks() { return totalWebhooks; }
    public long getTotalApiKeys() { return totalApiKeys; }
    public long getActiveApiKeys() { return activeApiKeys; }
    public long getExpiringApiKeys() { return expiringApiKeys; }
    public long getTotalContacts() { return totalContacts; }
    public long getTotalSubscribers() { return totalSubscribers; }
    public long getTotalCampaigns() { return totalCampaigns; }
    public long getTotalInbound() { return totalInbound; }
    public long getForwardedInbound() { return forwardedInbound; }
    public long getFailedInbound() { return failedInbound; }
    public long getTotalForms() { return totalForms; }
    public long getTotalMessages() { return totalMessages; }
    public long getUnreadMessages() { return unreadMessages; }
    public long getSpamMessages() { return spamMessages; }
    public List<DailyVolume> getDailyVolume() { return dailyVolume; }
    public Map<String, Long> getWebhookDeliveries() { return webhookDeliveries; }
    public WorkspaceFeatures getFeatures() { return features; }
}
