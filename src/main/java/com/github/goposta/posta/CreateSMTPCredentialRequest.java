package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CreateSMTPCredentialRequest mints a relay credential. AllowedIPs, when set,
 * restricts which addresses may authenticate with it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSMTPCredentialRequest {

    private String name;

    @JsonProperty("allowed_ips")
    private List<String> allowedIps;

    public CreateSMTPCredentialRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateSMTPCredentialRequest allowedIps(List<String> allowedIps) { this.allowedIps = allowedIps; return this; }
    public List<String> getAllowedIps() { return allowedIps; }
}
