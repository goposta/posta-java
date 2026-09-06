package com.github.goposta.posta;

/**
 * Response after sending an email.
 */
public class SendResponse {

    private String id;
    private String status;

    public String getId() { return id; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "SendResponse{id='" + id + "', status='" + status + "'}";
    }
}
