package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ListUnsubscribeRequest is the body for list-scoped unsubscribe/resubscribe.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUnsubscribeRequest {

    private String email;

    private String reason;

    public ListUnsubscribeRequest email(String email) { this.email = email; return this; }
    public String getEmail() { return email; }
    public ListUnsubscribeRequest reason(String reason) { this.reason = reason; return this; }
    public String getReason() { return reason; }
}
