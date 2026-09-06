package com.github.goposta.posta;

import java.io.IOException;

/**
 * Reads the email Posta received, whether over its inbound SMTP listener or
 * relayed in by an external provider's webhook.
 */
public class Inbound {

    private final Http http;

    Inbound(Http http) {
        this.http = http;
    }

    /** Returns a page of inbound emails. */
    public PageableResponse<InboundEmail> list(int page, int size)
            throws PostaException, IOException {
        return list(page, size, null, null, null, null);
    }

    /**
     * Returns a page of inbound emails.
     *
     * @param status processing state, such as {@code received} or {@code failed}
     * @param source how the message arrived: {@code smtp} or {@code webhook}
     * @param sender filters on the envelope sender
     * @param q      free-text search over subject and body
     */
    public PageableResponse<InboundEmail> list(int page, int size, String status,
                                               String source, String sender, String q)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/inbound-emails" + Http.query(
                "page", page, "size", size, "status", status,
                "source", source, "sender", sender, "q", q), InboundEmail.class);
    }

    /** Returns one inbound email with its parsed bodies. */
    public InboundEmail get(String uuid) throws PostaException, IOException {
        return http.get(Http.WS + "/inbound-emails/" + Http.seg(uuid), InboundEmail.class);
    }

    /** Removes an inbound email and its stored raw message. */
    public void delete(String uuid) throws PostaException, IOException {
        http.delete(Http.WS + "/inbound-emails/" + Http.seg(uuid));
    }

    /** Re-dispatches the webhook for an inbound email whose forwarding failed. */
    public InboundEmail retry(String uuid) throws PostaException, IOException {
        return http.post(Http.WS + "/inbound-emails/" + Http.seg(uuid) + "/retry", null,
                InboundEmail.class);
    }

    /**
     * Downloads the original RFC 5322 message ({@code .eml}), for callers that
     * need headers Posta did not parse out.
     */
    public Http.Download downloadRaw(String uuid) throws PostaException, IOException {
        return http.download(Http.WS + "/inbound-emails/" + Http.seg(uuid) + "/raw");
    }

    /** Downloads the file at {@code index} of an inbound email. */
    public Http.Download downloadAttachment(String uuid, int index)
            throws PostaException, IOException {
        return http.download(Http.WS + "/inbound-emails/" + Http.seg(uuid)
                + "/attachments/" + Http.seg(index));
    }
}
