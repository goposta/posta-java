package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SubscriberListWithCount is a list together with its current member count.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriberListWithCount extends SubscriberList {

    @JsonProperty("subscriber_count")
    private long subscriberCount;

    public long getSubscriberCount() { return subscriberCount; }
}
