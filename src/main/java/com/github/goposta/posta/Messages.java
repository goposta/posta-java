package com.github.goposta.posta;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/** Reads and triages the submissions collected by web forms. */
public class Messages {

    private final Http http;

    Messages(Http http) {
        this.http = http;
    }

    /** Returns a page of messages. */
    public PageableResponse<Message> list(int page, int size) throws PostaException, IOException {
        return list(page, size, null, null, null, null);
    }

    /**
     * Returns a page of messages.
     *
     * @param formId restricts the result to one form, or null for all
     * @param status spam verdict: {@code received}, {@code flagged}, {@code spam}, {@code rejected}
     * @param state  triage state: {@code new}, {@code open}, {@code replied}, {@code closed}, {@code spam}
     * @param q      free-text search over sender, subject, and body
     */
    public PageableResponse<Message> list(int page, int size, Long formId,
                                          String status, String state, String q)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/messages" + Http.query(
                "page", page, "size", size, "form_id", formId,
                "status", status, "state", state, "q", q), Message.class);
    }

    /**
     * Returns one message with its fields, attachments, and reply thread.
     * Reading a message marks it read.
     */
    public Message get(String uuid) throws PostaException, IOException {
        return http.get(Http.WS + "/messages/" + Http.seg(uuid), Message.class);
    }

    /** Removes a message. */
    public void delete(String uuid) throws PostaException, IOException {
        http.delete(Http.WS + "/messages/" + Http.seg(uuid));
    }

    /**
     * Returns total, unread, and spam message counts plus the number of forms in
     * the workspace.
     */
    public MessageStats stats() throws PostaException, IOException {
        return http.get(Http.WS + "/messages/stats", MessageStats.class);
    }

    /** Returns submission volume for the last {@code days} days (default 30). */
    public MessageAnalytics analytics(Integer days) throws PostaException, IOException {
        return http.get(Http.WS + "/messages/analytics" + Http.query("days", days),
                MessageAnalytics.class);
    }

    /** Answers a message's sender and records the reply on the thread. */
    public MessageReply reply(String uuid, ReplyMessageRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/messages/" + Http.seg(uuid) + "/reply", request,
                MessageReply.class);
    }

    /**
     * Moves a message through triage.
     *
     * @param state {@code new}, {@code open}, {@code replied}, {@code closed}, or {@code spam}
     * @param read  when non-null, also marks the message read or unread
     */
    public Message updateState(String uuid, String state, Boolean read)
            throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("state", state);
        if (read != null) {
            body.put("read", read);
        }
        return http.put(Http.WS + "/messages/" + Http.seg(uuid) + "/state", body, Message.class);
    }

    /**
     * Gives a message to a workspace member, or clears the assignment when
     * {@code userId} is null.
     */
    public Message assign(String uuid, Long userId) throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("user_id", userId);
        return http.put(Http.WS + "/messages/" + Http.seg(uuid) + "/assign", body, Message.class);
    }

    /** Quarantines a message and optionally learns a filter from it. */
    public Message markSpam(String uuid, MarkSpamRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/messages/" + Http.seg(uuid) + "/spam",
                request == null ? new MarkSpamRequest() : request, Message.class);
    }

    /** Clears the spam verdict on a message. */
    public Message markNotSpam(String uuid) throws PostaException, IOException {
        return http.post(Http.WS + "/messages/" + Http.seg(uuid) + "/not-spam", null,
                Message.class);
    }

    /**
     * Downloads the file at {@code index} of a message. Indexes match the order
     * of the message's attachments.
     */
    public Http.Download downloadAttachment(String uuid, int index)
            throws PostaException, IOException {
        return http.download(Http.WS + "/messages/" + Http.seg(uuid)
                + "/attachments/" + Http.seg(index));
    }
}
