package com.github.goposta.posta;

import java.io.IOException;

/**
 * Manages bulk sends to a subscriber list, and the lifecycle that carries one
 * from draft through sending to completion.
 */
public class Campaigns {

    private final Http http;

    Campaigns(Http http) {
        this.http = http;
    }

    /** Adds a campaign. */
    public Campaign create(CreateCampaignRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/campaigns", request, Campaign.class);
    }

    /** Returns a page of campaigns with their delivery counters. */
    public PageableResponse<CampaignWithStats> list(int page, int size)
            throws PostaException, IOException {
        return list(page, size, null);
    }

    /** Returns a page of campaigns in one status. */
    public PageableResponse<CampaignWithStats> list(int page, int size, String status)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/campaigns"
                + Http.query("page", page, "size", size, "status", status),
                CampaignWithStats.class);
    }

    /** Returns one campaign with its delivery counters. */
    public CampaignWithStats get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/campaigns/" + Http.seg(id), CampaignWithStats.class);
    }

    /** Changes a campaign that has not started sending. */
    public Campaign update(long id, UpdateCampaignRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/campaigns/" + Http.seg(id), request, Campaign.class);
    }

    /** Removes a campaign. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/campaigns/" + Http.seg(id));
    }

    /** Starts a campaign immediately, ignoring any schedule on it. */
    public Campaign send(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/campaigns/" + Http.seg(id) + "/send", null, Campaign.class);
    }

    /** Halts a sending campaign. Recipients already sent to are not resent. */
    public Campaign pause(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/campaigns/" + Http.seg(id) + "/pause", null, Campaign.class);
    }

    /** Continues a paused campaign from where it stopped. */
    public Campaign resume(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/campaigns/" + Http.seg(id) + "/resume", null, Campaign.class);
    }

    /** Stops a campaign for good. It cannot be resumed afterwards. */
    public Campaign cancel(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/campaigns/" + Http.seg(id) + "/cancel", null, Campaign.class);
    }

    /**
     * Copies a campaign into a fresh draft, so a recurring send can be repeated
     * without rebuilding it.
     */
    public Campaign duplicate(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/campaigns/" + Http.seg(id) + "/duplicate", null,
                Campaign.class);
    }

    /**
     * Returns a page of per-subscriber sends, with the engagement timestamps
     * recorded against each.
     */
    public PageableResponse<CampaignMessage> listMessages(long id, int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/campaigns/" + Http.seg(id) + "/messages"
                + Http.query("page", page, "size", size), CampaignMessage.class);
    }

    /** Returns the engagement analytics for a campaign. */
    public CampaignAnalyticsResponse analytics(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/campaigns/" + Http.seg(id) + "/analytics",
                CampaignAnalyticsResponse.class);
    }
}
