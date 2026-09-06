package com.github.goposta.posta;

import java.io.IOException;

/**
 * Manages the named opt-out lists that {@code List-Unsubscribe} headers point
 * at.
 *
 * <p>Referencing one from a send lets Posta mint the signed one-click URL and
 * record the opt-out against that list alone.</p>
 */
public class UnsubscribeLists {

    private final Http http;

    UnsubscribeLists(Http http) {
        this.http = http;
    }

    /** Adds an unsubscribe list. */
    public UnsubscribeList create(UnsubscribeListRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/unsubscribe-lists", request, UnsubscribeList.class);
    }

    /** Returns a page of unsubscribe lists. */
    public PageableResponse<UnsubscribeList> list(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/unsubscribe-lists" + Http.query("page", page, "size", size),
                UnsubscribeList.class);
    }

    /** Returns one unsubscribe list. */
    public UnsubscribeList get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/unsubscribe-lists/" + Http.seg(id), UnsubscribeList.class);
    }

    /** Changes an unsubscribe list. */
    public UnsubscribeList update(long id, UnsubscribeListRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/unsubscribe-lists/" + Http.seg(id), request,
                UnsubscribeList.class);
    }

    /** Removes an unsubscribe list. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/unsubscribe-lists/" + Http.seg(id));
    }
}
