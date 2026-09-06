package com.github.goposta.posta;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the signed-in account: profile, password, two-factor authentication,
 * sessions, settings, and notifications.
 *
 * <p>These endpoints accept only a user session token — an API key is never a
 * valid credential here — so build the client with
 * {@link PostaClient#withToken}.</p>
 */
public class Users {

    private final Http http;

    Users(Http http) {
        this.http = http;
    }

    /** Returns the signed-in account's profile. */
    public UserProfile me() throws PostaException, IOException {
        return http.get("/users/me", UserProfile.class);
    }

    /**
     * Changes the account's display name, and whether its sends require a
     * verified domain.
     */
    public UserProfile updateProfile(String name, Boolean requireVerifiedDomain)
            throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("name", name);
        if (requireVerifiedDomain != null) {
            body.put("require_verified_domain", requireVerifiedDomain);
        }
        return http.put("/users/me", body, UserProfile.class);
    }

    /** Sets a new password, confirming the current one. */
    public void changePassword(String currentPassword, String newPassword)
            throws PostaException, IOException {
        http.put("/users/me/password",
                Map.of("current_password", currentPassword, "new_password", newPassword),
                Void.class);
    }

    /** Sends the address confirmation email again. */
    public void resendVerificationEmail() throws PostaException, IOException {
        http.post("/users/me/verify-email/resend", null, Void.class);
    }

    /** Returns the quota and feature set applied to the account. */
    public Plan plan() throws PostaException, IOException {
        return http.get("/users/me/plan", Plan.class);
    }

    /**
     * Begins two-factor enrolment and returns the TOTP secret. Two-factor is not
     * active until {@link #verify2fa} confirms a code from it.
     */
    public Enable2FAResponse setup2fa() throws PostaException, IOException {
        return http.post("/users/me/2fa/setup", null, Enable2FAResponse.class);
    }

    /** Confirms a code from the authenticator and switches two-factor on. */
    public void verify2fa(String code) throws PostaException, IOException {
        http.post("/users/me/2fa/verify", Map.of("code", code), Void.class);
    }

    /** Switches two-factor off, confirming a current code. */
    public void disable2fa(String code) throws PostaException, IOException {
        http.post("/users/me/2fa/disable", Map.of("code", code), Void.class);
    }

    /**
     * Schedules the account for deletion after a grace period.
     * {@link #cancelDeletion} reverses it while the grace period lasts.
     */
    public void requestDeletion() throws PostaException, IOException {
        http.post("/users/me/delete", null, Void.class);
    }

    /** Calls off a scheduled account deletion. */
    public void cancelDeletion() throws PostaException, IOException {
        http.post("/users/me/cancel-deletion", null, Void.class);
    }

    /** Returns the account's active sessions. */
    public List<Session> listSessions() throws PostaException, IOException {
        return http.getList("/users/me/sessions", Session.class);
    }

    /** Signs one session out. */
    public void revokeSession(long id) throws PostaException, IOException {
        http.delete("/users/me/sessions/" + Http.seg(id));
    }

    /**
     * Signs out every session but this one — what to call after a password
     * change on a possibly compromised account.
     */
    public void revokeOtherSessions() throws PostaException, IOException {
        http.post("/users/me/sessions/revoke-others", null, Void.class);
    }

    /** Signs out the session making the request. */
    public void logout() throws PostaException, IOException {
        http.post("/users/me/sessions/logout", null, Void.class);
    }

    /** Chooses the workspace a request lands in when it names none. */
    public void setDefaultWorkspace(long workspaceId) throws PostaException, IOException {
        http.put("/users/me/default-workspace", Map.of("workspace_id", workspaceId), Void.class);
    }

    /** Returns a page of the account's own audit events. */
    public PageableResponse<Event> auditLog(int page, int size)
            throws PostaException, IOException {
        return auditLog(page, size, null, null);
    }

    /** Returns a page of the account's audit events, filtered. */
    public PageableResponse<Event> auditLog(int page, int size, String category, String search)
            throws PostaException, IOException {
        return http.getPage("/users/me/audit-log" + Http.query(
                "page", page, "size", size, "category", category, "search", search), Event.class);
    }

    /** Returns the account's settings. */
    public UserSettings settings() throws PostaException, IOException {
        return http.get("/users/me/settings", UserSettings.class);
    }

    /** Changes the account's settings. */
    public UserSettings updateSettings(UpdateUserSettingsRequest request)
            throws PostaException, IOException {
        return http.put("/users/me/settings", request, UserSettings.class);
    }

    /** Returns the account's notifications. */
    public List<Notification> listNotifications() throws PostaException, IOException {
        return listNotifications(null, null, null);
    }

    /**
     * Returns the account's notifications.
     *
     * @param unread keeps only unread notifications, or null for all
     * @param open   keeps only notifications that have not been dismissed
     * @param limit  caps how many are returned
     */
    public List<Notification> listNotifications(Boolean unread, Boolean open, Integer limit)
            throws PostaException, IOException {
        return http.getList("/users/me/notifications"
                + Http.query("unread", unread, "open", open, "limit", limit), Notification.class);
    }

    /**
     * Returns the notifications meant for the dashboard banner: platform
     * announcements and anything needing attention now.
     */
    public List<Notification> listBannerNotifications() throws PostaException, IOException {
        return http.getList("/users/me/notifications/banner", Notification.class);
    }

    /** Returns the unread and open notification totals, for a badge. */
    public NotificationCounts notificationCounts() throws PostaException, IOException {
        return http.get("/users/me/notifications/counts", NotificationCounts.class);
    }

    /** Marks the given notifications read. */
    public void markNotificationsRead(List<Long> ids) throws PostaException, IOException {
        http.post("/users/me/notifications/read", Map.of("ids", ids), Void.class);
    }

    /** Marks every notification read. */
    public void markAllNotificationsRead() throws PostaException, IOException {
        http.post("/users/me/notifications/read-all", null, Void.class);
    }

    /** Removes the given notifications from the list. */
    public void dismissNotifications(List<Long> ids) throws PostaException, IOException {
        http.post("/users/me/notifications/dismiss", Map.of("ids", ids), Void.class);
    }

    /** Removes every notification from the list. */
    public void dismissAllNotifications() throws PostaException, IOException {
        http.post("/users/me/notifications/dismiss-all", null, Void.class);
    }

    /** Returns the external identities linked to the account. */
    public List<LinkedOAuthAccount> listLinkedOAuthAccounts() throws PostaException, IOException {
        return http.getList("/users/me/oauth", LinkedOAuthAccount.class);
    }

    /** Detaches an external identity from the account. */
    public void unlinkOAuthAccount(long providerId) throws PostaException, IOException {
        http.delete("/users/me/oauth/" + Http.seg(providerId));
    }
}
