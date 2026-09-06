package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateOAuthProviderRequest changes an SSO provider. Omit ClientSecret to
 * keep the stored one.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateOAuthProviderRequest {

    private String name;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    private String issuer;

    @JsonProperty("auth_url")
    private String authUrl;

    @JsonProperty("token_url")
    private String tokenUrl;

    @JsonProperty("userinfo_url")
    private String userinfoUrl;

    private String scopes;

    @JsonProperty("allowed_domains")
    private String allowedDomains;

    @JsonProperty("auto_register")
    private Boolean autoRegister;

    private Boolean enabled;

    private Boolean hidden;

    public UpdateOAuthProviderRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateOAuthProviderRequest clientId(String clientId) { this.clientId = clientId; return this; }
    public String getClientId() { return clientId; }
    public UpdateOAuthProviderRequest clientSecret(String clientSecret) { this.clientSecret = clientSecret; return this; }
    public String getClientSecret() { return clientSecret; }
    public UpdateOAuthProviderRequest issuer(String issuer) { this.issuer = issuer; return this; }
    public String getIssuer() { return issuer; }
    public UpdateOAuthProviderRequest authUrl(String authUrl) { this.authUrl = authUrl; return this; }
    public String getAuthUrl() { return authUrl; }
    public UpdateOAuthProviderRequest tokenUrl(String tokenUrl) { this.tokenUrl = tokenUrl; return this; }
    public String getTokenUrl() { return tokenUrl; }
    public UpdateOAuthProviderRequest userinfoUrl(String userinfoUrl) { this.userinfoUrl = userinfoUrl; return this; }
    public String getUserinfoUrl() { return userinfoUrl; }
    public UpdateOAuthProviderRequest scopes(String scopes) { this.scopes = scopes; return this; }
    public String getScopes() { return scopes; }
    public UpdateOAuthProviderRequest allowedDomains(String allowedDomains) { this.allowedDomains = allowedDomains; return this; }
    public String getAllowedDomains() { return allowedDomains; }
    public UpdateOAuthProviderRequest autoRegister(Boolean autoRegister) { this.autoRegister = autoRegister; return this; }
    public Boolean getAutoRegister() { return autoRegister; }
    public UpdateOAuthProviderRequest enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public Boolean getEnabled() { return enabled; }
    public UpdateOAuthProviderRequest hidden(Boolean hidden) { this.hidden = hidden; return this; }
    public Boolean getHidden() { return hidden; }
}
