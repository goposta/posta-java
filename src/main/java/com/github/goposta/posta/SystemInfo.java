package com.github.goposta.posta;

import java.io.IOException;

/**
 * Reads build and health information.
 *
 * <p>Named {@code SystemInfo} rather than {@code System} so that
 * {@code import com.github.goposta.posta.*} does not clash with
 * {@link java.lang.System}.</p>
 */
public class SystemInfo {

    private final Http http;

    SystemInfo(Http http) {
        this.http = http;
    }

    /**
     * Returns the running build's name, version, and commit. Authenticated: the
     * exact build is what an attacker needs to match a deployment against known
     * CVEs.
     */
    public AppInfo info() throws PostaException, IOException {
        return http.get("/info", AppInfo.class);
    }

    /** Reports process liveness. Public: it needs no credential. */
    public HealthStatus healthz() throws PostaException, IOException {
        return http.getRoot("/healthz", HealthStatus.class);
    }

    /**
     * Reports whether dependencies (database, Redis) are reachable, which is
     * what a load balancer should gate traffic on. Public.
     */
    public HealthStatus readyz() throws PostaException, IOException {
        return http.getRoot("/readyz", HealthStatus.class);
    }
}
