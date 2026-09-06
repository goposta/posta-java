package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * FormSnippet is paste-ready embed code for a form.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormSnippet {

    @JsonProperty("public_key")
    private String publicKey;

    private String endpoint;

    /**
     * HTML is a plain <form> that posts directly to the endpoint.
     */
    private String html;

    /**
     * Fetch is a JavaScript fetch() call posting JSON to the endpoint.
     */
    private String fetch;

    public String getPublicKey() { return publicKey; }
    public String getEndpoint() { return endpoint; }
    public String getHtml() { return html; }
    public String getFetch() { return fetch; }
}
