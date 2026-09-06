package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * UpdateServerRequest changes a shared SMTP server. Omit Password to keep the
 * stored one.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateServerRequest {

    private String name;

    private String host;

    private int port;

    private String username;

    private String password;

    private String encryption;

    @JsonProperty("security_mode")
    private String securityMode;

    private String status;

    @JsonProperty("allowed_domains")
    private List<String> allowedDomains;

    @JsonProperty("max_retries")
    private Integer maxRetries;

    public UpdateServerRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateServerRequest host(String host) { this.host = host; return this; }
    public String getHost() { return host; }
    public UpdateServerRequest port(int port) { this.port = port; return this; }
    public int getPort() { return port; }
    public UpdateServerRequest username(String username) { this.username = username; return this; }
    public String getUsername() { return username; }
    public UpdateServerRequest password(String password) { this.password = password; return this; }
    public String getPassword() { return password; }
    public UpdateServerRequest encryption(String encryption) { this.encryption = encryption; return this; }
    public String getEncryption() { return encryption; }
    public UpdateServerRequest securityMode(String securityMode) { this.securityMode = securityMode; return this; }
    public String getSecurityMode() { return securityMode; }
    public UpdateServerRequest status(String status) { this.status = status; return this; }
    public String getStatus() { return status; }
    public UpdateServerRequest allowedDomains(List<String> allowedDomains) { this.allowedDomains = allowedDomains; return this; }
    public List<String> getAllowedDomains() { return allowedDomains; }
    public UpdateServerRequest maxRetries(Integer maxRetries) { this.maxRetries = maxRetries; return this; }
    public Integer getMaxRetries() { return maxRetries; }
}
