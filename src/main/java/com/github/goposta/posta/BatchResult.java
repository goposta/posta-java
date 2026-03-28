package com.github.goposta.posta;

/**
 * Result for a single recipient in a batch send.
 */
public class BatchResult {

    private String email;
    private String id;
    private String status;
    private String error;

    public String getEmail() { return email; }
    public String getId() { return id; }
    public String getStatus() { return status; }
    public String getError() { return error; }

    @Override
    public String toString() {
        return "BatchResult{email='" + email + "', id='" + id +
                "', status='" + status + "'}";
    }
}
