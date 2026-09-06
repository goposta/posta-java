package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * OAuthProvider is an SSO provider configured for the platform.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthProvider {

    private long id;

    private String name;

    private String slug;

    /**
     * Type is the protocol family, such as "oidc", "google", or "github".
     */
    private String type;

    private String issuer;

    private String scopes;

    /**
     * AllowedDomains restricts sign-in to these email domains, comma
     * separated.
     */
    @JsonProperty("allowed_domains")
    private String allowedDomains;

    /**
     * AutoRegister creates an account on first sign-in through this provider.
     */
    @JsonProperty("auto_register")
    private boolean autoRegister;

    private boolean enabled;

    /**
     * Hidden keeps the provider off the sign-in page, reachable only by a
     * direct authorize URL.
     */
    private boolean hidden;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getName() { return name; }
    public String getSlug() { return slug; }
    public String getType() { return type; }
    public String getIssuer() { return issuer; }
    public String getScopes() { return scopes; }
    public String getAllowedDomains() { return allowedDomains; }
    public boolean isAutoRegister() { return autoRegister; }
    public boolean isEnabled() { return enabled; }
    public boolean isHidden() { return hidden; }
    public String getCreatedAt() { return createdAt; }
}
