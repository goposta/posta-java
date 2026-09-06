package com.github.goposta.posta;

import java.io.IOException;

/** Manages the workspace's machine credentials. */
public class ApiKeys {

    private final Http http;

    ApiKeys(Http http) {
        this.http = http;
    }

    /**
     * Mints an API key. The secret is returned once, in this response; store it
     * now. Scope values are the constants on {@link Scopes}.
     */
    public APIKeyCreated create(CreateAPIKeyRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/api-keys", request, APIKeyCreated.class);
    }

    /** Returns a page of API keys. The secrets are not included. */
    public PageableResponse<APIKey> list(int page, int size) throws PostaException, IOException {
        return http.getPage(Http.WS + "/api-keys" + Http.query("page", page, "size", size),
                APIKey.class);
    }

    /** Returns one API key's metadata. */
    public APIKey get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/api-keys/" + Http.seg(id), APIKey.class);
    }

    /** Disables a key without deleting it, so its past use stays auditable. */
    public MessageData revoke(long id) throws PostaException, IOException {
        return http.put(Http.WS + "/api-keys/" + Http.seg(id) + "/revoke", null, MessageData.class);
    }

    /** Removes a key entirely. */
    public MessageData delete(long id) throws PostaException, IOException {
        return http.delete(Http.WS + "/api-keys/" + Http.seg(id), null, MessageData.class);
    }
}
