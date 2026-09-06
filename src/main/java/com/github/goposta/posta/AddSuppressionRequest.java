package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AddSuppressionRequest suppresses one address. ListID scopes the suppression
 * to a single unsubscribe list; without it the address is suppressed workspace
 * wide.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddSuppressionRequest {

    private String email;

    private String reason;

    @JsonProperty("list_id")
    private Long listId;

    public AddSuppressionRequest email(String email) { this.email = email; return this; }
    public String getEmail() { return email; }
    public AddSuppressionRequest reason(String reason) { this.reason = reason; return this; }
    public String getReason() { return reason; }
    public AddSuppressionRequest listId(Long listId) { this.listId = listId; return this; }
    public Long getListId() { return listId; }
}
