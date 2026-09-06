package com.github.goposta.posta;

import java.util.List;

/**
 * Body for {@code POST /webhooks}.
 * <p>
 * Valid {@code events} are: {@code email.sent}, {@code email.failed},
 * {@code email.inbound}, {@code email.unsubscribed}, {@code email.complained},
 * {@code campaign.started}, and {@code campaign.completed}.
 * <p>
 * {@code filters} is optional and may be {@code null}.
 */
public class CreateWebhookRequest {

    private String url;
    private List<String> events;
    private List<String> filters;

    public CreateWebhookRequest url(String url) { this.url = url; return this; }
    public CreateWebhookRequest events(List<String> events) { this.events = events; return this; }
    public CreateWebhookRequest filters(List<String> filters) { this.filters = filters; return this; }

    public String getUrl() { return url; }
    public List<String> getEvents() { return events; }
    public List<String> getFilters() { return filters; }
}
