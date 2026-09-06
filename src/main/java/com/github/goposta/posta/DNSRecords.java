package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DNSRecords are the four records a sending domain needs: a TXT proving
 * ownership, and the SPF, DKIM, and DMARC records that make mail from it
 * deliverable.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DNSRecords {

    private DNSRecord verification;

    private DNSRecord spf;

    private DNSRecord dkim;

    private DNSRecord dmarc;

    public DNSRecord getVerification() { return verification; }
    public DNSRecord getSpf() { return spf; }
    public DNSRecord getDkim() { return dkim; }
    public DNSRecord getDmarc() { return dmarc; }
}
