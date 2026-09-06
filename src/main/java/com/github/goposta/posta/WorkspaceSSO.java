package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * WorkspaceSSO binds a workspace to an OAuth provider for single sign-on.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceSSO {

    @JsonProperty("provider_id")
    private long providerId;

    @JsonProperty("provider_name")
    private String providerName;

    /**
     * AllowedDomains restricts SSO to these email domains, comma separated.
     */
    @JsonProperty("allowed_domains")
    private String allowedDomains;

    /**
     * AutoProvision creates a workspace membership on first SSO login.
     */
    @JsonProperty("auto_provision")
    private boolean autoProvision;

    /**
     * EnforceSSO refuses password logins for members of this workspace.
     */
    @JsonProperty("enforce_sso")
    private boolean enforceSso;

    public WorkspaceSSO providerId(long providerId) { this.providerId = providerId; return this; }
    public long getProviderId() { return providerId; }
    public WorkspaceSSO providerName(String providerName) { this.providerName = providerName; return this; }
    public String getProviderName() { return providerName; }
    public WorkspaceSSO allowedDomains(String allowedDomains) { this.allowedDomains = allowedDomains; return this; }
    public String getAllowedDomains() { return allowedDomains; }
    public WorkspaceSSO autoProvision(boolean autoProvision) { this.autoProvision = autoProvision; return this; }
    public boolean isAutoProvision() { return autoProvision; }
    public WorkspaceSSO enforceSso(boolean enforceSso) { this.enforceSso = enforceSso; return this; }
    public boolean isEnforceSso() { return enforceSso; }
}
