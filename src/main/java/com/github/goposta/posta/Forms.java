package com.github.goposta.posta;

import java.io.IOException;
import java.util.Map;

/**
 * Manages web form endpoints: public URLs a website posts to, whose submissions
 * land in the workspace as messages.
 */
public class Forms {

    private final Http http;

    Forms(Http http) {
        this.http = http;
    }

    /** Adds a form and returns it with its public key. */
    public Form create(CreateFormRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/forms", request, Form.class);
    }

    /** Returns a page of forms. */
    public PageableResponse<Form> list(int page, int size) throws PostaException, IOException {
        return http.getPage(Http.WS + "/forms" + Http.query("page", page, "size", size), Form.class);
    }

    /** Returns one form. */
    public Form get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/forms/" + Http.seg(id), Form.class);
    }

    /** Changes a form. */
    public Form update(long id, UpdateFormRequest request) throws PostaException, IOException {
        return http.put(Http.WS + "/forms/" + Http.seg(id), request, Form.class);
    }

    /** Removes a form and the messages collected through it. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/forms/" + Http.seg(id));
    }

    /**
     * Issues a new public key. Existing embeds stop working the moment this
     * returns, so update them together.
     */
    public Form rotateKey(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/forms/" + Http.seg(id) + "/rotate-key", null, Form.class);
    }

    /** Returns paste-ready HTML and {@code fetch()} code wired to a form. */
    public FormSnippet snippet(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/forms/" + Http.seg(id) + "/snippet", FormSnippet.class);
    }

    /**
     * Issues a submission nonce for a form whose nonce requirement is set. A
     * public endpoint keyed by the form's public key; it needs no credential.
     */
    public FormNonce nonce(String publicKey) throws PostaException, IOException {
        return http.get("/f/" + Http.seg(publicKey) + "/nonce", FormNonce.class);
    }

    /**
     * Posts a submission to a form's public ingest endpoint, as a website would.
     * It needs no credential, and always answers success for a stored or
     * silently rejected submission so a spam client learns nothing.
     */
    public void submit(String publicKey, Map<String, Object> fields)
            throws PostaException, IOException {
        http.post("/f/" + Http.seg(publicKey), fields, Void.class);
    }
}
