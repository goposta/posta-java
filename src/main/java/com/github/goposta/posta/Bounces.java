package com.github.goposta.posta;

import java.io.IOException;

/** Reads recorded bounces and complaints, and records them for a provider. */
public class Bounces {

    private final Http http;

    Bounces(Http http) {
        this.http = http;
    }

    /** Returns a page of bounces. Needs an API key with the {@code read} scope. */
    public PageableResponse<Bounce> list(int page, int size) throws PostaException, IOException {
        return http.getPage("/bounces" + Http.query("page", page, "size", size), Bounce.class);
    }

    /** Returns a page of bounces through the workspace-scoped endpoint. */
    public PageableResponse<Bounce> listInWorkspace(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/bounces" + Http.query("page", page, "size", size),
                Bounce.class);
    }

    /**
     * Files a bounce against a recipient, for callers relaying notifications
     * from a provider Posta does not poll itself.
     */
    public Bounce record(RecordBounceRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/bounces", request, Bounce.class);
    }
}
