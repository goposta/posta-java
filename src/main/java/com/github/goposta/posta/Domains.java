package com.github.goposta.posta;

import java.io.IOException;
import java.util.Map;

/**
 * Manages sending domains and their DNS verification.
 *
 * <p>A workspace that requires verified domains refuses to send from one that
 * has not passed its checks.</p>
 */
public class Domains {

    private final Http http;

    Domains(Http http) {
        this.http = http;
    }

    /** Registers a domain and returns the DNS records to publish for it. */
    public DomainWithRecords add(String domain) throws PostaException, IOException {
        return http.post(Http.WS + "/domains", Map.of("domain", domain), DomainWithRecords.class);
    }

    /** Returns a page of domains. */
    public PageableResponse<Domain> list(int page, int size) throws PostaException, IOException {
        return http.getPage(Http.WS + "/domains" + Http.query("page", page, "size", size),
                Domain.class);
    }

    /** Returns one domain with its DNS records and their verification state. */
    public DomainWithRecords get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/domains/" + Http.seg(id), DomainWithRecords.class);
    }

    /**
     * Re-runs the DNS lookups and reports each check's outcome. DNS propagates
     * slowly, so this is expected to be called repeatedly until the result is
     * fully verified.
     */
    public DomainVerificationResult verify(long id) throws PostaException, IOException {
        return http.post(Http.WS + "/domains/" + Http.seg(id) + "/verify", null,
                DomainVerificationResult.class);
    }

    /** Removes a domain. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/domains/" + Http.seg(id));
    }
}
