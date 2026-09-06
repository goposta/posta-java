package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * UserMetrics is one account's usage across the platform.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMetrics {

    private User user;

    @JsonProperty("total_emails")
    private long totalEmails;

    @JsonProperty("sent_emails")
    private long sentEmails;

    @JsonProperty("failed_emails")
    private long failedEmails;

    @JsonProperty("suppressed_emails")
    private long suppressedEmails;

    @JsonProperty("failure_rate")
    private double failureRate;

    @JsonProperty("total_bounces")
    private long totalBounces;

    @JsonProperty("total_suppressions")
    private long totalSuppressions;

    @JsonProperty("total_contacts")
    private long totalContacts;

    @JsonProperty("total_domains")
    private long totalDomains;

    @JsonProperty("total_smtp_servers")
    private long totalSmtpServers;

    @JsonProperty("total_api_keys")
    private long totalApiKeys;

    @JsonProperty("active_api_keys")
    private long activeApiKeys;

    @JsonProperty("total_inbound")
    private long totalInbound;

    @JsonProperty("forwarded_inbound")
    private long forwardedInbound;

    @JsonProperty("failed_inbound")
    private long failedInbound;

    @JsonProperty("webhook_deliveries")
    private Map<String, Long> webhookDeliveries;

    public User getUser() { return user; }
    public long getTotalEmails() { return totalEmails; }
    public long getSentEmails() { return sentEmails; }
    public long getFailedEmails() { return failedEmails; }
    public long getSuppressedEmails() { return suppressedEmails; }
    public double getFailureRate() { return failureRate; }
    public long getTotalBounces() { return totalBounces; }
    public long getTotalSuppressions() { return totalSuppressions; }
    public long getTotalContacts() { return totalContacts; }
    public long getTotalDomains() { return totalDomains; }
    public long getTotalSmtpServers() { return totalSmtpServers; }
    public long getTotalApiKeys() { return totalApiKeys; }
    public long getActiveApiKeys() { return activeApiKeys; }
    public long getTotalInbound() { return totalInbound; }
    public long getForwardedInbound() { return forwardedInbound; }
    public long getFailedInbound() { return failedInbound; }
    public Map<String, Long> getWebhookDeliveries() { return webhookDeliveries; }
}
