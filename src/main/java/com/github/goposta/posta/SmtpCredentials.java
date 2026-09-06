package com.github.goposta.posta;

import java.io.IOException;

/**
 * Manages credentials for Posta's own SMTP relay listener.
 *
 * <p>They let an existing application send through Posta by pointing its SMTP
 * client at it, instead of calling the HTTP API.</p>
 */
public class SmtpCredentials {

    private final Http http;

    SmtpCredentials(Http http) {
        this.http = http;
    }

    /** Mints a relay credential. The password is returned once; store it now. */
    public SMTPCredentialCreated create(CreateSMTPCredentialRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/smtp-credentials", request, SMTPCredentialCreated.class);
    }

    /** Returns a page of relay credentials. */
    public PageableResponse<SMTPCredential> list(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/smtp-credentials" + Http.query("page", page, "size", size),
                SMTPCredential.class);
    }

    /** Returns one relay credential. */
    public SMTPCredential get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/smtp-credentials/" + Http.seg(id), SMTPCredential.class);
    }

    /** Disables a credential without deleting it, so past use stays auditable. */
    public MessageData revoke(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/smtp-credentials/" + Http.seg(id) + "/revoke", null,
                MessageData.class);
    }

    /** Removes a relay credential entirely. */
    public MessageData delete(long id) throws PostaException, IOException {
        return http.delete(Http.WS + "/smtp-credentials/" + Http.seg(id), null, MessageData.class);
    }
}
