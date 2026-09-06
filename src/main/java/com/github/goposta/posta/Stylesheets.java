package com.github.goposta.posta;

import java.io.IOException;

/**
 * Manages reusable CSS shared by template versions.
 *
 * <p>Keeping the house style in one stylesheet means changing it once rather
 * than in every template.</p>
 */
public class Stylesheets {

    private final Http http;

    Stylesheets(Http http) {
        this.http = http;
    }

    /** Adds a stylesheet. */
    public Stylesheet create(StylesheetRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/stylesheets", request, Stylesheet.class);
    }

    /** Returns a page of stylesheets. */
    public PageableResponse<Stylesheet> list(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/stylesheets" + Http.query("page", page, "size", size),
                Stylesheet.class);
    }

    /** Replaces a stylesheet's name and CSS. */
    public Stylesheet update(long id, StylesheetRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/stylesheets/" + Http.seg(id), request, Stylesheet.class);
    }

    /** Removes a stylesheet. Versions referencing it fall back to none. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/stylesheets/" + Http.seg(id));
    }
}
