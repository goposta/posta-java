package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateOAuthProviderRequest configures an SSO provider. For a standards
 * compliant OIDC provider, Issuer alone is enough — Posta discovers the
 * endpoints. Set AuthURL, TokenURL, and UserinfoURL only for one that does not
 * publish a discovery document.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOAuthProviderRequest {

    private String name;

    private String slug;

    private String type;

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

    private Boolean hidden;

    public CreateOAuthProviderRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateOAuthProviderRequest slug(String slug) { this.slug = slug; return this; }
    public String getSlug() { return slug; }
    public CreateOAuthProviderRequest type(String type) { this.type = type; return this; }
    public String getType() { return type; }
    public CreateOAuthProviderRequest clientId(String clientId) { this.clientId = clientId; return this; }
    public String getClientId() { return clientId; }
    public CreateOAuthProviderRequest clientSecret(String clientSecret) { this.clientSecret = clientSecret; return this; }
    public String getClientSecret() { return clientSecret; }
    public CreateOAuthProviderRequest issuer(String issuer) { this.issuer = issuer; return this; }
    public String getIssuer() { return issuer; }
    public CreateOAuthProviderRequest authUrl(String authUrl) { this.authUrl = authUrl; return this; }
    public String getAuthUrl() { return authUrl; }
    public CreateOAuthProviderRequest tokenUrl(String tokenUrl) { this.tokenUrl = tokenUrl; return this; }
    public String getTokenUrl() { return tokenUrl; }
    public CreateOAuthProviderRequest userinfoUrl(String userinfoUrl) { this.userinfoUrl = userinfoUrl; return this; }
    public String getUserinfoUrl() { return userinfoUrl; }
    public CreateOAuthProviderRequest scopes(String scopes) { this.scopes = scopes; return this; }
    public String getScopes() { return scopes; }
    public CreateOAuthProviderRequest allowedDomains(String allowedDomains) { this.allowedDomains = allowedDomains; return this; }
    public String getAllowedDomains() { return allowedDomains; }
    public CreateOAuthProviderRequest autoRegister(Boolean autoRegister) { this.autoRegister = autoRegister; return this; }
    public Boolean getAutoRegister() { return autoRegister; }
    public CreateOAuthProviderRequest hidden(Boolean hidden) { this.hidden = hidden; return this; }
    public Boolean getHidden() { return hidden; }
}
