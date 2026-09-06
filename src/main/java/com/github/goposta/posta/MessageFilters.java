package com.github.goposta.posta;

import java.io.IOException;

/** Manages the spam rules applied to form submissions as they arrive. */
public class MessageFilters {

    private final Http http;

    MessageFilters(Http http) {
        this.http = http;
    }

    /** Adds a spam filter. */
    public MessageFilter create(CreateMessageFilterRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/message-filters", request, MessageFilter.class);
    }

    /** Returns a page of spam filters with their hit counts. */
    public PageableResponse<MessageFilter> list(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/message-filters" + Http.query("page", page, "size", size),
                MessageFilter.class);
    }

    /** Changes a spam filter. */
    public MessageFilter update(long id, UpdateMessageFilterRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/message-filters/" + Http.seg(id), request, MessageFilter.class);
    }

    /** Removes a spam filter. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/message-filters/" + Http.seg(id));
    }

    /**
     * Reports how many recent messages a candidate filter would have matched,
     * without creating it.
     */
    public FilterTestResult test(TestMessageFilterRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/message-filters/test", request, FilterTestResult.class);
    }
}
