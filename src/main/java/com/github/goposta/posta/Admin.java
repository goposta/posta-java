package com.github.goposta.posta;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Platform administration: users, plans, shared SMTP servers, domains across
 * every workspace, platform settings, announcements, the event log, and the
 * update check.
 *
 * <p>These endpoints accept only an administrator's session token — an API key
 * is never a valid credential here, whatever scopes it carries — so build the
 * client with {@link PostaClient#withToken}.</p>
 */
public class Admin {

    private final Http http;

    Admin(Http http) {
        this.http = http;
    }

    // ── Users ────────────────────────────────────────────────────────────

    /** Adds an account, bypassing self-registration. */
    public User createUser(CreateUserRequest request) throws PostaException, IOException {
        return http.post("/admin/users", request, User.class);
    }

    /** Returns a page of platform accounts. */
    public PageableResponse<User> listUsers(int page, int size)
            throws PostaException, IOException {
        return listUsers(page, size, null);
    }

    /** Returns a page of platform accounts matching a free-text search. */
    public PageableResponse<User> listUsers(int page, int size, String search)
            throws PostaException, IOException {
        return http.getPage("/admin/users"
                + Http.query("page", page, "size", size, "search", search), User.class);
    }

    /** Changes an account's role or standing. */
    public User updateUser(long id, UpdateUserRequest request) throws PostaException, IOException {
        return http.put("/admin/users/" + Http.seg(id), request, User.class);
    }

    /** Schedules an account for deletion after the usual grace period. */
    public void deleteUser(long id) throws PostaException, IOException {
        http.delete("/admin/users/" + Http.seg(id));
    }

    /**
     * Removes an account and its data immediately, skipping the grace period.
     * This cannot be undone.
     */
    public void forceDeleteUser(long id) throws PostaException, IOException {
        http.delete("/admin/users/" + Http.seg(id) + "/force");
    }

    /** Calls off a scheduled account deletion. */
    public void cancelUserDeletion(long id) throws PostaException, IOException {
        http.post("/admin/users/" + Http.seg(id) + "/cancel-deletion", null, Void.class);
    }

    /**
     * Turns off an account's two-factor authentication, for recovering a user
     * who has lost their authenticator.
     */
    public void disableUser2fa(long id) throws PostaException, IOException {
        http.delete("/admin/users/" + Http.seg(id) + "/2fa");
    }

    /** Signs an account out everywhere. */
    public void revokeUserSessions(long id) throws PostaException, IOException {
        http.post("/admin/users/" + Http.seg(id) + "/revoke-sessions", null, Void.class);
    }

    /** Returns one account's usage figures. */
    public UserMetrics userMetrics(long id) throws PostaException, IOException {
        return http.get("/admin/users/" + Http.seg(id) + "/metrics", UserMetrics.class);
    }

    /** Returns the workspaces an account belongs to. */
    public List<AdminWorkspace> listUserWorkspaces(long id) throws PostaException, IOException {
        return http.getList("/admin/users/" + Http.seg(id) + "/workspaces", AdminWorkspace.class);
    }

    /** Returns the plan assigned to an account. */
    public Plan userPlan(long id) throws PostaException, IOException {
        return http.get("/admin/users/" + Http.seg(id) + "/plan", Plan.class);
    }

    /** Puts an account on a plan. */
    public Plan assignUserPlan(long userId, long planId) throws PostaException, IOException {
        return http.post("/admin/users/" + Http.seg(userId) + "/plan",
                Map.of("plan_id", planId), Plan.class);
    }

    /** Returns the plan assigned to a workspace. */
    public Plan workspacePlan(long workspaceId) throws PostaException, IOException {
        return http.get("/admin/workspaces/" + Http.seg(workspaceId) + "/plan", Plan.class);
    }

    /** Puts a workspace on a plan. */
    public Plan assignWorkspacePlan(long workspaceId, long planId)
            throws PostaException, IOException {
        return http.post("/admin/workspaces/" + Http.seg(workspaceId) + "/plan",
                Map.of("plan_id", planId), Plan.class);
    }

    // ── Plans ────────────────────────────────────────────────────────────

    /** Adds a plan. */
    public Plan createPlan(CreatePlanRequest request) throws PostaException, IOException {
        return http.post("/admin/plans", request, Plan.class);
    }

    /** Returns a page of plans. */
    public PageableResponse<Plan> listPlans(int page, int size)
            throws PostaException, IOException {
        return http.getPage("/admin/plans" + Http.query("page", page, "size", size), Plan.class);
    }

    /** Returns one plan. */
    public Plan getPlan(long id) throws PostaException, IOException {
        return http.get("/admin/plans/" + Http.seg(id), Plan.class);
    }

    /** Changes a plan. */
    public Plan updatePlan(long id, UpdatePlanRequest request) throws PostaException, IOException {
        return http.put("/admin/plans/" + Http.seg(id), request, Plan.class);
    }

    /** Removes a plan. Accounts on it fall back to the default plan. */
    public void deletePlan(long id) throws PostaException, IOException {
        http.delete("/admin/plans/" + Http.seg(id));
    }

    /** Makes a plan the one new accounts receive. */
    public Plan setDefaultPlan(long id) throws PostaException, IOException {
        return http.patch("/admin/plans/" + Http.seg(id) + "/default", null, Plan.class);
    }

    // ── Shared SMTP servers ──────────────────────────────────────────────

    /** Registers a shared SMTP server. */
    public Server createServer(CreateServerRequest request) throws PostaException, IOException {
        return http.post("/admin/servers", request, Server.class);
    }

    /** Returns a page of shared SMTP servers. */
    public PageableResponse<Server> listServers(int page, int size)
            throws PostaException, IOException {
        return http.getPage("/admin/servers" + Http.query("page", page, "size", size),
                Server.class);
    }

    /** Returns one shared SMTP server. */
    public Server getServer(long id) throws PostaException, IOException {
        return http.get("/admin/servers/" + Http.seg(id), Server.class);
    }

    /** Changes a shared SMTP server. */
    public Server updateServer(long id, UpdateServerRequest request)
            throws PostaException, IOException {
        return http.put("/admin/servers/" + Http.seg(id), request, Server.class);
    }

    /** Removes a shared SMTP server. */
    public void deleteServer(long id) throws PostaException, IOException {
        http.delete("/admin/servers/" + Http.seg(id));
    }

    /** Puts a shared SMTP server back into rotation. */
    public Server enableServer(long id) throws PostaException, IOException {
        return http.post("/admin/servers/" + Http.seg(id) + "/enable", null, Server.class);
    }

    /** Takes a shared SMTP server out of rotation without deleting it. */
    public Server disableServer(long id) throws PostaException, IOException {
        return http.post("/admin/servers/" + Http.seg(id) + "/disable", null, Server.class);
    }

    /** Opens a connection to a shared SMTP server, without sending anything. */
    public MessageData testServer(long id) throws PostaException, IOException {
        return http.post("/admin/servers/" + Http.seg(id) + "/test", null, MessageData.class);
    }

    // ── Domains ──────────────────────────────────────────────────────────

    /** Returns a page of domains across every workspace. */
    public PageableResponse<AdminDomain> listDomains(int page, int size)
            throws PostaException, IOException {
        return listDomains(page, size, null, null, null);
    }

    /**
     * Returns a page of domains across every workspace.
     *
     * @param status    verification state, such as {@code verified} or {@code pending}
     * @param workspace restricts the result to one workspace, or null for all
     */
    public PageableResponse<AdminDomain> listDomains(int page, int size, String search,
                                                     String status, Long workspace)
            throws PostaException, IOException {
        return http.getPage("/admin/domains" + Http.query("page", page, "size", size,
                "search", search, "status", status, "workspace", workspace), AdminDomain.class);
    }

    /** Returns one domain with the DNS records it needs. */
    public DomainWithRecords getDomain(long id) throws PostaException, IOException {
        return http.get("/admin/domains/" + Http.seg(id), DomainWithRecords.class);
    }

    /** Re-runs DNS verification for a domain in any workspace. */
    public void verifyDomain(long id) throws PostaException, IOException {
        http.post("/admin/domains/" + Http.seg(id) + "/verify", null, Void.class);
    }

    /**
     * Marks a domain's ownership verified, or withdraws that, without a DNS
     * lookup — an override for a domain that cannot publish the record. The
     * reason is recorded in the audit log.
     */
    public Domain setDomainVerification(long id, boolean verified, String reason)
            throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("ownership_verified", verified);
        if (reason != null) {
            body.put("reason", reason);
        }
        return http.put("/admin/domains/" + Http.seg(id) + "/verification", body, Domain.class);
    }

    // ── Metrics, analytics, events ───────────────────────────────────────

    /** Returns the deployment's overall usage and runtime health. */
    public PlatformMetrics metrics() throws PostaException, IOException {
        return http.get("/admin/metrics", PlatformMetrics.class);
    }

    /** Returns platform-wide email volume and status analytics. */
    public AnalyticsResponse analytics() throws PostaException, IOException {
        return analytics(null, null, null);
    }

    /** Returns platform-wide email volume and status analytics over a window. */
    public AnalyticsResponse analytics(String from, String to, String status)
            throws PostaException, IOException {
        return http.get("/admin/analytics"
                + Http.query("from", from, "to", to, "status", status), AnalyticsResponse.class);
    }

    /** Returns platform-wide delivery and bounce trends. */
    public DashboardAnalyticsResponse dashboardAnalytics() throws PostaException, IOException {
        return dashboardAnalytics(null, null);
    }

    /** Returns platform-wide delivery and bounce trends over a window. */
    public DashboardAnalyticsResponse dashboardAnalytics(String from, String to)
            throws PostaException, IOException {
        return http.get("/admin/analytics/dashboard" + Http.query("from", from, "to", to),
                DashboardAnalyticsResponse.class);
    }

    /** Returns platform-wide deliverability by recipient provider. */
    public ProviderBreakdownResponse providerAnalytics() throws PostaException, IOException {
        return providerAnalytics(null, null);
    }

    /** Returns platform-wide deliverability by recipient provider over a window. */
    public ProviderBreakdownResponse providerAnalytics(String from, String to)
            throws PostaException, IOException {
        return http.get("/admin/analytics/providers" + Http.query("from", from, "to", to),
                ProviderBreakdownResponse.class);
    }

    /** Returns a page of platform events. */
    public PageableResponse<Event> listEvents(int page, int size)
            throws PostaException, IOException {
        return listEvents(page, size, null, null);
    }

    /** Returns a page of platform events, filtered. */
    public PageableResponse<Event> listEvents(int page, int size, String category, String search)
            throws PostaException, IOException {
        return http.getPage("/admin/events" + Http.query("page", page, "size", size,
                "category", category, "search", search), Event.class);
    }

    /** Returns one platform event with its full metadata. */
    public Event getEvent(long id) throws PostaException, IOException {
        return http.get("/admin/events/" + Http.seg(id), Event.class);
    }

    // ── Settings, announcements, updates, SSO ────────────────────────────

    /** Returns the platform's configuration entries. */
    public List<Setting> settings() throws PostaException, IOException {
        return http.getList("/admin/settings", Setting.class);
    }

    /** Changes platform configuration entries. Only the keys supplied are touched. */
    public List<Setting> updateSettings(List<Setting> settings)
            throws PostaException, IOException {
        return http.putList("/admin/settings", Map.of("settings", settings), Setting.class);
    }

    /** Broadcasts a notice to every user. */
    public Announcement createAnnouncement(CreateAnnouncementRequest request)
            throws PostaException, IOException {
        return http.post("/admin/announcements", request, Announcement.class);
    }

    /** Returns a page of announcements. */
    public PageableResponse<Announcement> listAnnouncements(int page, int size)
            throws PostaException, IOException {
        return http.getPage("/admin/announcements" + Http.query("page", page, "size", size),
                Announcement.class);
    }

    /** Retracts an announcement, removing it from every user's notifications. */
    public void deleteAnnouncement(long id) throws PostaException, IOException {
        http.delete("/admin/announcements/" + Http.seg(id));
    }

    /** Reports whether a newer Posta release is available. */
    public UpdateInfo updateStatus() throws PostaException, IOException {
        return http.get("/admin/update", UpdateInfo.class);
    }

    /** Hides the update notice for one version, until a later one appears. */
    public UpdateInfo dismissUpdate(String version) throws PostaException, IOException {
        return http.post("/admin/update/dismiss", Map.of("version", version), UpdateInfo.class);
    }

    /** Returns every configured SSO provider, including hidden and disabled ones. */
    public List<OAuthProvider> listOAuthProviders() throws PostaException, IOException {
        return http.getList("/admin/oauth/providers", OAuthProvider.class);
    }

    /** Configures an SSO provider. */
    public OAuthProvider createOAuthProvider(CreateOAuthProviderRequest request)
            throws PostaException, IOException {
        return http.post("/admin/oauth/providers", request, OAuthProvider.class);
    }

    /** Changes an SSO provider. */
    public OAuthProvider updateOAuthProvider(long id, UpdateOAuthProviderRequest request)
            throws PostaException, IOException {
        return http.put("/admin/oauth/providers/" + Http.seg(id), request, OAuthProvider.class);
    }

    /**
     * Removes an SSO provider. Accounts linked to it fall back to password
     * sign-in.
     */
    public void deleteOAuthProvider(long id) throws PostaException, IOException {
        http.delete("/admin/oauth/providers/" + Http.seg(id));
    }
}
