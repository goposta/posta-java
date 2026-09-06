package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DomainVerificationResult is what a verification run returns: the updated
 * domain, whether every check now passes, and the detail of each check.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainVerificationResult {

    private Domain domain;

    @JsonProperty("fully_verified")
    private boolean fullyVerified;

    private DomainVerification verification;

    public Domain getDomain() { return domain; }
    public boolean isFullyVerified() { return fullyVerified; }
    public DomainVerification getVerification() { return verification; }
}
