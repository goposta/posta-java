package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CreateAPIKeyRequest mints an API key. An empty Scopes defaults to
 * [ScopeSend]; ExpiresInDays leaves the key permanent when nil.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAPIKeyRequest {

    private String name;

    private List<String> scopes;

    @JsonProperty("allowed_ips")
    private List<String> allowedIps;

    @JsonProperty("expires_in_days")
    private Integer expiresInDays;

    public CreateAPIKeyRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateAPIKeyRequest scopes(List<String> scopes) { this.scopes = scopes; return this; }
    public List<String> getScopes() { return scopes; }
    public CreateAPIKeyRequest allowedIps(List<String> allowedIps) { this.allowedIps = allowedIps; return this; }
    public List<String> getAllowedIps() { return allowedIps; }
    public CreateAPIKeyRequest expiresInDays(Integer expiresInDays) { this.expiresInDays = expiresInDays; return this; }
    public Integer getExpiresInDays() { return expiresInDays; }
}
