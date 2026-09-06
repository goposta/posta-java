package com.github.goposta.posta;

import java.io.IOException;

/** Manages the SMTP relays Posta delivers outbound mail through. */
public class SmtpServers {

    private final Http http;

    SmtpServers(Http http) {
        this.http = http;
    }

    /** Registers an SMTP server. */
    public SMTPServer create(CreateSMTPServerRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/smtp-servers", request, SMTPServer.class);
    }

    /**
     * Returns a page of SMTP servers, including any shared server the platform
     * offers the workspace.
     */
    public PageableResponse<SMTPServer> list(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/smtp-servers" + Http.query("page", page, "size", size),
                SMTPServer.class);
    }

    /** Returns one SMTP server. */
    public SMTPServer get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/smtp-servers/" + Http.seg(id), SMTPServer.class);
    }

    /** Changes an SMTP server's configuration. */
    public SMTPServer update(long id, UpdateSMTPServerRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/smtp-servers/" + Http.seg(id), request, SMTPServer.class);
    }

    /** Removes an SMTP server. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/smtp-servers/" + Http.seg(id));
    }

    /**
     * Opens a connection and authenticates, without sending anything. Use it to
     * check credentials before relying on them.
     */
    public MessageData test(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/smtp-servers/" + Http.seg(id) + "/test", null,
                MessageData.class);
    }
}
