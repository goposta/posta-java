package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CreateServerRequest registers a shared SMTP server, offered to workspaces
 * that have configured none of their own.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateServerRequest {

    private String name;

    private String host;

    private int port;

    private String username;

    private String password;

    private String encryption;

    /**
     * SecurityMode governs how strictly TLS is enforced on the connection.
     */
    @JsonProperty("security_mode")
    private String securityMode;

    /**
     * AllowedDomains restricts which sender domains may use this server.
     */
    @JsonProperty("allowed_domains")
    private List<String> allowedDomains;

    @JsonProperty("max_retries")
    private int maxRetries;

    public CreateServerRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateServerRequest host(String host) { this.host = host; return this; }
    public String getHost() { return host; }
    public CreateServerRequest port(int port) { this.port = port; return this; }
    public int getPort() { return port; }
    public CreateServerRequest username(String username) { this.username = username; return this; }
    public String getUsername() { return username; }
    public CreateServerRequest password(String password) { this.password = password; return this; }
    public String getPassword() { return password; }
    public CreateServerRequest encryption(String encryption) { this.encryption = encryption; return this; }
    public String getEncryption() { return encryption; }
    public CreateServerRequest securityMode(String securityMode) { this.securityMode = securityMode; return this; }
    public String getSecurityMode() { return securityMode; }
    public CreateServerRequest allowedDomains(List<String> allowedDomains) { this.allowedDomains = allowedDomains; return this; }
    public List<String> getAllowedDomains() { return allowedDomains; }
    public CreateServerRequest maxRetries(int maxRetries) { this.maxRetries = maxRetries; return this; }
    public int getMaxRetries() { return maxRetries; }
}
