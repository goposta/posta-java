package com.github.goposta.posta;

import java.io.IOException;

/** Reads delivery and engagement analytics for the workspace. */
public class Analytics {

    private final Http http;

    Analytics(Http http) {
        this.http = http;
    }

    /** Returns email volume and status analytics over the server's default window. */
    public AnalyticsResponse emails() throws PostaException, IOException {
        return emails(null, null, null);
    }

    /**
     * Returns email volume and status analytics.
     *
     * @param from   ISO-8601 start of the window, or null for the server default
     * @param to     ISO-8601 end of the window, or null
     * @param status narrows the result to one email status, or null
     */
    public AnalyticsResponse emails(String from, String to, String status)
            throws PostaException, IOException {
        return http.get(Http.WS + "/analytics" + Http.query("from", from, "to", to, "status", status),
                AnalyticsResponse.class);
    }

    /** Returns delivery and bounce trends plus send-latency percentiles. */
    public DashboardAnalyticsResponse dashboard() throws PostaException, IOException {
        return dashboard(null, null);
    }

    /** Returns delivery and bounce trends over a date window. */
    public DashboardAnalyticsResponse dashboard(String from, String to)
            throws PostaException, IOException {
        return http.get(Http.WS + "/analytics/dashboard" + Http.query("from", from, "to", to),
                DashboardAnalyticsResponse.class);
    }

    /**
     * Returns deliverability broken down by recipient mailbox provider, which is
     * how a reputation problem at one provider shows up.
     */
    public ProviderBreakdownResponse providers() throws PostaException, IOException {
        return providers(null, null);
    }

    /** Returns deliverability by recipient provider over a date window. */
    public ProviderBreakdownResponse providers(String from, String to)
            throws PostaException, IOException {
        return http.get(Http.WS + "/analytics/providers" + Http.query("from", from, "to", to),
                ProviderBreakdownResponse.class);
    }

    /** Returns the workspace's headline counters. */
    public DashboardStats dashboardStats() throws PostaException, IOException {
        return http.get(Http.WS + "/dashboard/stats", DashboardStats.class);
    }
}
