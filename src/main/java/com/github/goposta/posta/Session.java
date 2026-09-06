package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Session is one signed-in browser or client.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {

    private long id;

    private String label;

    private String device;

    private String browser;

    private String os;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("user_agent")
    private String userAgent;

    /**
     * Current marks the session making this request.
     */
    private boolean current;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("expires_at")
    private String expiresAt;

    public long getId() { return id; }
    public String getLabel() { return label; }
    public String getDevice() { return device; }
    public String getBrowser() { return browser; }
    public String getOs() { return os; }
    public String getIpAddress() { return ipAddress; }
    public String getUserAgent() { return userAgent; }
    public boolean isCurrent() { return current; }
    public String getCreatedAt() { return createdAt; }
    public String getExpiresAt() { return expiresAt; }
}
