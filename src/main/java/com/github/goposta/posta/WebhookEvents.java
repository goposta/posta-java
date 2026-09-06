package com.github.goposta.posta;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Webhook event names, and verification of the signature Posta sends with each
 * delivery.
 *
 * <p>Register a subset of the event constants on a webhook to choose what Posta
 * notifies you about.</p>
 */
public final class WebhookEvents {

    /** A message was accepted by the destination MTA. */
    public static final String EMAIL_SENT = "email.sent";
    /** A message permanently failed after retries. */
    public static final String EMAIL_FAILED = "email.failed";
    /** An inbound email was received and parsed. */
    public static final String EMAIL_INBOUND = "email.inbound";
    /** A recipient opted out via one-click unsubscribe. */
    public static final String EMAIL_UNSUBSCRIBED = "email.unsubscribed";
    /** A recipient marked a message as spam. */
    public static final String EMAIL_COMPLAINED = "email.complained";
    /** A campaign began sending. */
    public static final String CAMPAIGN_STARTED = "campaign.started";
    /** A campaign finished sending. */
    public static final String CAMPAIGN_COMPLETED = "campaign.completed";
    /** A web form submission passed scanning. */
    public static final String MESSAGE_RECEIVED = "message.received";
    /** A web form submission was quarantined or rejected. */
    public static final String MESSAGE_SPAM = "message.spam";

    private WebhookEvents() {
    }

    /**
     * Reports whether {@code signature} authenticates {@code payload} under
     * {@code secret}.
     *
     * <p>Posta signs each delivery with HMAC-SHA256 over the raw request body and
     * sends it as {@code sha256=<hex>} in the {@code X-Posta-Signature} header.
     * Pass the header value verbatim, along with the exact bytes received —
     * re-serializing the JSON changes them and the check will fail.</p>
     *
     * <pre>{@code
     * if (!WebhookEvents.verifySignature(rawBody, request.getHeader(Http.SIGNATURE_HEADER), secret)) {
     *     response.setStatus(401);
     *     return;
     * }
     * }</pre>
     */
    public static boolean verifySignature(byte[] payload, String signature, String secret) {
        if (signature == null || signature.isEmpty() || secret == null || secret.isEmpty()) {
            return false;
        }
        String provided = signature.startsWith("sha256=") ? signature.substring(7) : signature;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] digest = mac.doFinal(payload);
            StringBuilder hex = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                hex.append(Character.forDigit((b >> 4) & 0xF, 16));
                hex.append(Character.forDigit(b & 0xF, 16));
            }
            // isEqual compares in constant time, so a wrong signature leaks
            // nothing about how much of it was right.
            return MessageDigest.isEqual(
                    hex.toString().getBytes(StandardCharsets.UTF_8),
                    provided.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            return false;
        }
    }

    /** Convenience overload for a body already decoded as a UTF-8 string. */
    public static boolean verifySignature(String payload, String signature, String secret) {
        return verifySignature(payload.getBytes(StandardCharsets.UTF_8), signature, secret);
    }
}
