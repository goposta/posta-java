package com.github.goposta.posta;

import java.io.IOException;

/**
 * Reads the derived record of every address the workspace has mailed, with
 * delivery counters.
 *
 * <p>Contacts are created by sending; they are not managed directly.</p>
 */
public class Contacts {

    private final Http http;

    Contacts(Http http) {
        this.http = http;
    }

    /** Returns a page of contacts. */
    public PageableResponse<Contact> list(int page, int size) throws PostaException, IOException {
        return list(page, size, null);
    }

    /** Returns a page of contacts matching a free-text search. */
    public PageableResponse<Contact> list(int page, int size, String search)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/contacts"
                + Http.query("page", page, "size", size, "search", search), Contact.class);
    }

    /** Returns one contact. */
    public Contact get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/contacts/" + Http.seg(id), Contact.class);
    }
}
