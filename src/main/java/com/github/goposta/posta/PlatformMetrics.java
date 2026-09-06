package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * PlatformMetrics is the deployment's overall usage and runtime health.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformMetrics {

    @JsonProperty("total_users")
    private long totalUsers;

    @JsonProperty("total_workspaces")
    private long totalWorkspaces;

    @JsonProperty("users_without_workspace")
    private long usersWithoutWorkspace;

    @JsonProperty("two_factor_users")
    private long twoFactorUsers;

    @JsonProperty("two_factor_adoption_rate")
    private double twoFactorAdoptionRate;

    @JsonProperty("active_sessions")
    private long activeSessions;

    @JsonProperty("failed_logins_last_24h")
    private long failedLoginsLast24h;

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

    @JsonProperty("total_bounces")
    private long totalBounces;

    @JsonProperty("total_suppressions")
    private long totalSuppressions;

    @JsonProperty("total_domains")
    private long totalDomains;

    @JsonProperty("total_api_keys")
    private long totalApiKeys;

    @JsonProperty("active_api_keys")
    private long activeApiKeys;

    @JsonProperty("shared_smtp_servers")
    private long sharedSmtpServers;

    @JsonProperty("total_inbound")
    private long totalInbound;

    @JsonProperty("received_inbound")
    private long receivedInbound;

    @JsonProperty("forwarded_inbound")
    private long forwardedInbound;

    @JsonProperty("failed_inbound")
    private long failedInbound;

    @JsonProperty("rejected_inbound")
    private long rejectedInbound;

    @JsonProperty("active_workers")
    private int activeWorkers;

    @JsonProperty("current_goroutines")
    private int currentGoroutines;

    @JsonProperty("current_memory_usage")
    private long currentMemoryUsage;

    @JsonProperty("server_uptime_seconds")
    private double serverUptimeSeconds;

    @JsonProperty("webhook_deliveries")
    private Map<String, Long> webhookDeliveries;

    public long getTotalUsers() { return totalUsers; }
    public long getTotalWorkspaces() { return totalWorkspaces; }
    public long getUsersWithoutWorkspace() { return usersWithoutWorkspace; }
    public long getTwoFactorUsers() { return twoFactorUsers; }
    public double getTwoFactorAdoptionRate() { return twoFactorAdoptionRate; }
    public long getActiveSessions() { return activeSessions; }
    public long getFailedLoginsLast24h() { return failedLoginsLast24h; }
    public long getTotalEmails() { return totalEmails; }
    public long getSentEmails() { return sentEmails; }
    public long getFailedEmails() { return failedEmails; }
    public long getQueuedEmails() { return queuedEmails; }
    public long getProcessingEmails() { return processingEmails; }
    public long getSuppressedEmails() { return suppressedEmails; }
    public double getFailureRate() { return failureRate; }
    public long getTotalBounces() { return totalBounces; }
    public long getTotalSuppressions() { return totalSuppressions; }
    public long getTotalDomains() { return totalDomains; }
    public long getTotalApiKeys() { return totalApiKeys; }
    public long getActiveApiKeys() { return activeApiKeys; }
    public long getSharedSmtpServers() { return sharedSmtpServers; }
    public long getTotalInbound() { return totalInbound; }
    public long getReceivedInbound() { return receivedInbound; }
    public long getForwardedInbound() { return forwardedInbound; }
    public long getFailedInbound() { return failedInbound; }
    public long getRejectedInbound() { return rejectedInbound; }
    public int getActiveWorkers() { return activeWorkers; }
    public int getCurrentGoroutines() { return currentGoroutines; }
    public long getCurrentMemoryUsage() { return currentMemoryUsage; }
    public double getServerUptimeSeconds() { return serverUptimeSeconds; }
    public Map<String, Long> getWebhookDeliveries() { return webhookDeliveries; }
}
