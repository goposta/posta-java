package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DeliveryRatePoint is one day's delivery outcome.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryRatePoint {

    private String date;

    private long total;

    private long sent;

    private long failed;

    @JsonProperty("delivery_rate")
    private double deliveryRate;

    public String getDate() { return date; }
    public long getTotal() { return total; }
    public long getSent() { return sent; }
    public long getFailed() { return failed; }
    public double getDeliveryRate() { return deliveryRate; }
}
