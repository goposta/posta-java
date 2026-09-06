package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * LinkedOAuthAccount is an external identity linked to the account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedOAuthAccount {

    private long id;

    @JsonProperty("provider_id")
    private long providerId;

    @JsonProperty("provider_name")
    private String providerName;

    @JsonProperty("provider_type")
    private String providerType;

    private String email;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getProviderId() { return providerId; }
    public String getProviderName() { return providerName; }
    public String getProviderType() { return providerType; }
    public String getEmail() { return email; }
    public String getCreatedAt() { return createdAt; }
}
