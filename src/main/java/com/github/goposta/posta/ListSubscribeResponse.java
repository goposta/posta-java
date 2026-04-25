package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Result of an unsubscribe or resubscribe call. Action is one of
 * "unsubscribed" or "resubscribed".
 */
public class ListSubscribeResponse {

    @JsonProperty("list_id")
    private Long listId;

    @JsonProperty("subscriber_id")
    private Long subscriberId;

    private String email;
    private String action;

    @JsonProperty("list_created")
    private Boolean listCreated;

    @JsonProperty("subscriber_created")
    private Boolean subscriberCreated;

    @JsonProperty("member_added")
    private Boolean memberAdded;

    public Long getListId() { return listId; }
    public Long getSubscriberId() { return subscriberId; }
    public String getEmail() { return email; }
    public String getAction() { return action; }
    public Boolean getListCreated() { return listCreated; }
    public Boolean getSubscriberCreated() { return subscriberCreated; }
    public Boolean getMemberAdded() { return memberAdded; }

    @Override
    public String toString() {
        return "ListSubscribeResponse{listId=" + listId + ", email='" + email + "', action='" + action + "'}";
    }
}
