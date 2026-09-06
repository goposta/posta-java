package com.github.goposta.posta;

import java.io.IOException;

/** Registers endpoints Posta notifies, and reads the delivery attempts it made. */
public class Webhooks {

    private final Http http;

    Webhooks(Http http) {
        this.http = http;
    }

    /** Returns a page of webhooks. Needs an API key with the {@code webhooks} scope. */
    public PageableResponse<Webhook> list(int page, int size) throws PostaException, IOException {
        return http.getPage("/webhooks" + Http.query("page", page, "size", size), Webhook.class);
    }

    /**
     * Registers a webhook endpoint. The response carries the signing secret,
     * which is shown only here — store it to verify deliveries. Event names are
     * the constants on {@link WebhookEvents}.
     */
    public Webhook create(CreateWebhookRequest request) throws PostaException, IOException {
        return http.post("/webhooks", request, Webhook.class);
    }

    /** Removes a webhook. */
    public void delete(long id) throws PostaException, IOException {
        http.delete("/webhooks/" + Http.seg(id));
    }

    /**
     * Returns a page of delivery attempts, with the HTTP status and error of
     * each. Needs an API key with the {@code read} scope.
     */
    public PageableResponse<WebhookDelivery> listDeliveries(int page, int size)
            throws PostaException, IOException {
        return http.getPage("/webhook-deliveries" + Http.query("page", page, "size", size),
                WebhookDelivery.class);
    }

    /** Returns a page of webhooks through the workspace-scoped endpoint. */
    public PageableResponse<Webhook> listInWorkspace(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/webhooks" + Http.query("page", page, "size", size),
                Webhook.class);
    }

    /** Registers a webhook through the workspace-scoped endpoint. */
    public Webhook createInWorkspace(CreateWebhookRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/webhooks", request, Webhook.class);
    }

    /** Removes a webhook through the workspace-scoped endpoint. */
    public void deleteInWorkspace(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/webhooks/" + Http.seg(id));
    }

    /** Returns delivery attempts through the workspace-scoped endpoint. */
    public PageableResponse<WebhookDelivery> listDeliveriesInWorkspace(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/webhook-deliveries" + Http.query("page", page, "size", size),
                WebhookDelivery.class);
    }
}
