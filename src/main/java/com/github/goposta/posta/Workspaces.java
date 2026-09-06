package com.github.goposta.posta;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Manages workspaces and everything that governs one: membership, invitations,
 * settings, SSO, the audit log, and the data export and GDPR erasure tools.
 *
 * <p>Methods on "current" act on the workspace the credential resolves to — the
 * one a workspace-bound API key names, or the one the client was built with.</p>
 */
public class Workspaces {

    private final Http http;

    Workspaces(Http http) {
        this.http = http;
    }

    /** Adds a workspace, owned by the caller. */
    public Workspace create(CreateWorkspaceRequest request) throws PostaException, IOException {
        return http.post("/workspaces", request, Workspace.class);
    }

    /** Returns every workspace the caller belongs to, with their role in each. */
    public List<Workspace> list() throws PostaException, IOException {
        return http.getList("/workspaces", Workspace.class);
    }

    /** Returns the active workspace. */
    public Workspace get() throws PostaException, IOException {
        return http.get(Http.WS, Workspace.class);
    }

    /** Changes the active workspace. */
    public Workspace update(UpdateWorkspaceRequest request) throws PostaException, IOException {
        return http.put(Http.WS, request, Workspace.class);
    }

    /**
     * Removes the active workspace and everything in it. This cannot be undone;
     * export first with {@link #exportData()}.
     */
    public void delete() throws PostaException, IOException {
        http.delete(Http.WS);
    }

    /** Returns the workspace's members and their roles. */
    public List<WorkspaceMember> listMembers() throws PostaException, IOException {
        return http.getList(Http.WS + "/members", WorkspaceMember.class);
    }

    /** Changes a member's role: {@code owner}, {@code admin}, {@code editor}, or {@code viewer}. */
    public WorkspaceMember updateMemberRole(long memberId, String role)
            throws PostaException, IOException {
        return http.put(Http.WS + "/members/" + Http.seg(memberId), Map.of("role", role),
                WorkspaceMember.class);
    }

    /** Removes a member from the workspace. */
    public void removeMember(long memberId) throws PostaException, IOException {
        http.delete(Http.WS + "/members/" + Http.seg(memberId));
    }

    /** Offers workspace membership to an email address, at the given role. */
    public Invitation invite(String email, String role) throws PostaException, IOException {
        return http.post(Http.WS + "/invitations", Map.of("email", email, "role", role),
                Invitation.class);
    }

    /** Returns the workspace's pending invitations. */
    public List<Invitation> listInvitations() throws PostaException, IOException {
        return http.getList(Http.WS + "/invitations", Invitation.class);
    }

    /** Withdraws a pending invitation. */
    public void cancelInvitation(long invitationId) throws PostaException, IOException {
        http.delete(Http.WS + "/invitations/" + Http.seg(invitationId));
    }

    /** Returns the invitations addressed to the signed-in user. */
    public List<Invitation> listMyInvitations() throws PostaException, IOException {
        return http.getList("/invitations", Invitation.class);
    }

    /** Joins a workspace using the token from an invitation email. */
    public void acceptInvitation(String token) throws PostaException, IOException {
        http.post("/invitations/accept", Map.of("token", token), Void.class);
    }

    /** Refuses an invitation using its token. */
    public void declineInvitation(String token) throws PostaException, IOException {
        http.post("/invitations/decline", Map.of("token", token), Void.class);
    }

    /** Joins a workspace using an invitation id, which needs no token. */
    public void acceptInvitationById(long id) throws PostaException, IOException {
        http.post("/invitations/" + Http.seg(id) + "/accept", null, Void.class);
    }

    /** Refuses an invitation by its id. */
    public void declineInvitationById(long id) throws PostaException, IOException {
        http.post("/invitations/" + Http.seg(id) + "/decline", null, Void.class);
    }

    /** Returns the workspace's settings. */
    public WorkspaceSettings settings() throws PostaException, IOException {
        return http.get(Http.WS + "/settings", WorkspaceSettings.class);
    }

    /** Changes the workspace's settings. */
    public WorkspaceSettings updateSettings(UpdateWorkspaceSettingsRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/settings", request, WorkspaceSettings.class);
    }

    /** Returns the quota and feature set applied to the workspace. */
    public Plan plan() throws PostaException, IOException {
        return http.get(Http.WS + "/plan", Plan.class);
    }

    /** Returns a page of the workspace's audit events. */
    public PageableResponse<Event> listAuditLog(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/audit-log" + Http.query("page", page, "size", size),
                Event.class);
    }

    /** Returns one audit event with its full metadata. */
    public Event getAuditEvent(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/audit-log/" + Http.seg(id), Event.class);
    }

    /**
     * Returns a portable snapshot of the workspace, for backup or for moving it
     * to another Posta deployment.
     */
    public WorkspaceDataExport exportData() throws PostaException, IOException {
        return http.get(Http.WS + "/data/export", WorkspaceDataExport.class);
    }

    /** Restores a snapshot into the active workspace. */
    public MessageData importData(WorkspaceDataExport data) throws PostaException, IOException {
        return http.post(Http.WS + "/data/import", data, MessageData.class);
    }

    /**
     * Erases a data subject's contact, subscriber, and suppression records.
     * Passing an empty email erases every contact in the workspace, so pass the
     * address you mean.
     */
    public GDPRDeleteResult deleteContactData(String email) throws PostaException, IOException {
        return http.post(Http.WS + "/gdpr/delete-contacts", Map.of("email", email),
                GDPRDeleteResult.class);
    }

    /** Erases stored email records older than {@code olderThanDays}. */
    public GDPRDeleteResult deleteEmailLogs(int olderThanDays) throws PostaException, IOException {
        return http.post(Http.WS + "/gdpr/delete-email-logs",
                Map.of("older_than_days", olderThanDays), GDPRDeleteResult.class);
    }

    /** Returns the workspace's single sign-on configuration. */
    public WorkspaceSSO sso() throws PostaException, IOException {
        return http.get(Http.WS + "/sso", WorkspaceSSO.class);
    }

    /** Configures single sign-on for the workspace. */
    public WorkspaceSSO setSso(WorkspaceSSO config) throws PostaException, IOException {
        return http.put(Http.WS + "/sso", config, WorkspaceSSO.class);
    }

    /** Removes the workspace's single sign-on configuration. */
    public void deleteSso() throws PostaException, IOException {
        http.delete(Http.WS + "/sso");
    }
}
