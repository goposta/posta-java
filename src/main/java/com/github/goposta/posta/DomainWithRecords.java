package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DomainWithRecords is a domain together with the DNS records to publish for
 * it, as returned when adding or fetching one.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainWithRecords extends Domain {

    @JsonProperty("dns_records")
    private DNSRecords dnsRecords;

    public DNSRecords getDnsRecords() { return dnsRecords; }
}
