package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * ProviderBreakdownResponse groups deliverability by recipient provider, which
 * is how a reputation problem at one mailbox provider shows up.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderBreakdownResponse {

    private List<ProviderStats> providers;

    public List<ProviderStats> getProviders() { return providers; }
}
