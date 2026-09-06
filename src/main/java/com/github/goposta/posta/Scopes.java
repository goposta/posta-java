package com.github.goposta.posta;

/**
 * Scopes an API key can carry.
 *
 * <p>A key reaches only what its scopes allow. Note that {@link #SEND} grants
 * none of the others: a send-only key is confined to the public send API and
 * cannot read or modify workspace resources.</p>
 */
public final class Scopes {

    /** Sending, verification, and subscriber-list opt-ins. */
    public static final String SEND = "send";
    /** Reading emails, bounces, webhook deliveries, and workspace resources. */
    public static final String READ = "read";
    /** Mutating workspace resources. */
    public static final String WRITE = "write";
    /** Managing webhook endpoints. */
    public static final String WEBHOOKS = "webhooks";
    /** Tenant administration: keys, members, invitations, settings, SSO. */
    public static final String ADMIN = "admin";
    /** Every scope. */
    public static final String ALL = "*";

    private Scopes() {
    }
}
