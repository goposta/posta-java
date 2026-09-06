package com.github.goposta.posta;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Manages lists and who belongs to them.
 *
 * <p>A {@code static} list has explicit members. A {@code segment} list derives
 * its members from filter rules evaluated at send time.</p>
 */
public class SubscriberLists {

    private final Http http;

    SubscriberLists(Http http) {
        this.http = http;
    }

    /** Adds a list. */
    public SubscriberList create(CreateSubscriberListRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/subscriber-lists", request, SubscriberList.class);
    }

    /** Returns a page of lists with their member counts. */
    public PageableResponse<SubscriberListWithCount> list(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/subscriber-lists" + Http.query("page", page, "size", size),
                SubscriberListWithCount.class);
    }

    /** Returns one list with its member count. */
    public SubscriberListWithCount get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/subscriber-lists/" + Http.seg(id),
                SubscriberListWithCount.class);
    }

    /** Changes a list. The type cannot be changed after creation. */
    public SubscriberList update(long id, UpdateSubscriberListRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/subscriber-lists/" + Http.seg(id), request,
                SubscriberList.class);
    }

    /** Removes a list. The subscribers themselves are not deleted. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/subscriber-lists/" + Http.seg(id));
    }

    /**
     * Returns a page of the subscribers on a list. For a segment list this
     * evaluates the filter rules.
     */
    public PageableResponse<Subscriber> listMembers(long listId, int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/subscriber-lists/" + Http.seg(listId) + "/members"
                + Http.query("page", page, "size", size), Subscriber.class);
    }

    /** Puts an existing subscriber on a static list. */
    public void addMember(long listId, long subscriberId) throws PostaException, IOException {
        http.post(Http.WS + "/subscriber-lists/" + Http.seg(listId) + "/members",
                Map.of("subscriber_id", subscriberId), Void.class);
    }

    /**
     * Takes a subscriber off a static list. This is not an opt-out: use
     * {@link #unsubscribe} to record one.
     */
    public void removeMember(long listId, long subscriberId) throws PostaException, IOException {
        http.delete(Http.WS + "/subscriber-lists/" + Http.seg(listId) + "/members",
                Map.of("subscriber_id", subscriberId));
    }

    /** Counts the subscribers a candidate segment would match. */
    public SegmentPreview previewSegment(List<FilterRule> filterRules)
            throws PostaException, IOException {
        return http.post(Http.WS + "/subscriber-lists/preview-segment",
                Map.of("filter_rules", filterRules), SegmentPreview.class);
    }

    /**
     * Adds an address to a list by name, creating the list on first use and
     * clearing any prior opt-out for it. Idempotent, and reachable with a
     * {@code send}-scoped API key, so a signup form can call it directly.
     */
    public ListSubscribeResponse subscribe(ListSubscribeRequest request)
            throws PostaException, IOException {
        return http.post("/subscriber-lists/subscribe", request, ListSubscribeResponse.class);
    }

    /**
     * Opts an address out of one list. The subscriber's global status is
     * untouched. Idempotent.
     */
    public ListSubscribeResponse unsubscribe(long listId, ListUnsubscribeRequest request)
            throws PostaException, IOException {
        return http.post("/subscriber-lists/" + Http.seg(listId) + "/unsubscribe",
                request, ListSubscribeResponse.class);
    }

    /**
     * Reverses a list-scoped opt-out and, for a static list, puts the subscriber
     * back on it. Idempotent.
     */
    public ListSubscribeResponse resubscribe(long listId, String email)
            throws PostaException, IOException {
        return http.post("/subscriber-lists/" + Http.seg(listId) + "/resubscribe",
                Map.of("email", email), ListSubscribeResponse.class);
    }

    /** Opts an address out through the workspace-scoped endpoint. */
    public ListSubscribeResponse unsubscribeInWorkspace(long listId,
                                                        ListUnsubscribeRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/subscriber-lists/" + Http.seg(listId) + "/unsubscribe",
                request, ListSubscribeResponse.class);
    }

    /** Reverses an opt-out through the workspace-scoped endpoint. */
    public ListSubscribeResponse resubscribeInWorkspace(long listId, String email)
            throws PostaException, IOException {
        return http.post(Http.WS + "/subscriber-lists/" + Http.seg(listId) + "/resubscribe",
                Map.of("email", email), ListSubscribeResponse.class);
    }
}
