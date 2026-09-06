package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * HealthStatus is a liveness or readiness answer. Database and Redis are
 * filled in only by the readiness probe.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthStatus {

    private String status;

    private String database;

    private String redis;

    public String getStatus() { return status; }
    public String getDatabase() { return database; }
    public String getRedis() { return redis; }
}
