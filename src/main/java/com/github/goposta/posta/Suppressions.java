package com.github.goposta.posta;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/** Manages the addresses Posta refuses to deliver to. */
public class Suppressions {

    private final Http http;

    Suppressions(Http http) {
        this.http = http;
    }

    /** Returns a page of suppressed addresses. */
    public PageableResponse<Suppression> list(int page, int size)
            throws PostaException, IOException {
        return list(page, size, null);
    }

    /**
     * Returns a page of suppressed addresses.
     *
     * @param listId restricts the result to the opt-outs recorded against a
     *               single unsubscribe list; null for all of them
     */
    public PageableResponse<Suppression> list(int page, int size, Long listId)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/suppressions"
                + Http.query("page", page, "size", size, "list_id", listId), Suppression.class);
    }

    /**
     * Suppresses an address.
     *
     * @param listId scopes the suppression to a single unsubscribe list; null
     *               suppresses the address workspace wide
     */
    public Suppression add(String email, String reason, Long listId)
            throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("email", email);
        if (reason != null) {
            body.put("reason", reason);
        }
        if (listId != null) {
            body.put("list_id", listId);
        }
        return http.post(Http.WS + "/suppressions", body, Suppression.class);
    }

    /**
     * Lifts a suppression, letting Posta deliver to the address again.
     *
     * @param listId lifts a list-scoped opt-out; null lifts the workspace-wide entry
     */
    public void remove(String email, Long listId) throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("email", email);
        if (listId != null) {
            body.put("list_id", listId);
        }
        http.delete(Http.WS + "/suppressions", body);
    }
}
