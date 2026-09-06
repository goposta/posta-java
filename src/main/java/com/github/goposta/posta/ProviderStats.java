package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ProviderStats is one receiving provider's deliverability.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderStats {

    private String provider;

    private long total;

    private long sent;

    private long failed;

    private long suppressed;

    @JsonProperty("delivery_rate")
    private double deliveryRate;

    public String getProvider() { return provider; }
    public long getTotal() { return total; }
    public long getSent() { return sent; }
    public long getFailed() { return failed; }
    public long getSuppressed() { return suppressed; }
    public double getDeliveryRate() { return deliveryRate; }
}
