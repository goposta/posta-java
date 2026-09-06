package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response after sending an email.
 */
public class SendResponse {

    private String id;
    private String status;

    @JsonProperty("list_id")
    private Long listId;

    @JsonProperty("subscriber_id")
    private Long subscriberId;

    @JsonProperty("list_created")
    private Boolean listCreated;

    @JsonProperty("member_added")
    private Boolean memberAdded;

    /**
     * True when the email was NOT queued because the recipient is suppressed
     * on the list or globally. HTTP status is still 200 — branch on this
     * field and {@link #getSkippedReason()} for compliance handling.
     */
    private Boolean skipped;

    @JsonProperty("skipped_reason")
    private String skippedReason;

    public String getId() { return id; }
    public String getStatus() { return status; }
    public Long getListId() { return listId; }
    public Long getSubscriberId() { return subscriberId; }
    public Boolean getListCreated() { return listCreated; }
    public Boolean getMemberAdded() { return memberAdded; }
    public Boolean getSkipped() { return skipped; }
    public String getSkippedReason() { return skippedReason; }

    @Override
    public String toString() {
        return "SendResponse{id='" + id + "', status='" + status + "'"
                + (skipped != null && skipped ? ", skipped=" + skippedReason : "")
                + (listId != null ? ", list_id=" + listId : "")
                + "}";
    }
}
