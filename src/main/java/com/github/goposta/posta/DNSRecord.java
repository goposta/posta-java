package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DNSRecord is one record a domain needs published.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DNSRecord {

    private String type;

    private String host;

    private String value;

    public String getType() { return type; }
    public String getHost() { return host; }
    public String getValue() { return value; }
}
