package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Outcome returned by {@code POST /emails/verify}.
 * <p>
 * {@code status} is one of {@code "valid"}, {@code "invalid"}, {@code "risky"},
 * {@code "disposable"}, or {@code "unknown"}.
 */
public class VerificationResult {

    private String email;
    private String status;
    private int score;
    private VerificationChecks checks;
    private String reason;

    @JsonProperty("mailbox_verified")
    private boolean mailboxVerified;

    private boolean suppressed;

    @JsonProperty("previously_bounced")
    private boolean previouslyBounced;

    private boolean cached;

    @JsonProperty("checked_at")
    private String checkedAt;

    public String getEmail() { return email; }
    public String getStatus() { return status; }
    public int getScore() { return score; }
    public VerificationChecks getChecks() { return checks; }
    public String getReason() { return reason; }
    public boolean isMailboxVerified() { return mailboxVerified; }
    public boolean isSuppressed() { return suppressed; }
    public boolean isPreviouslyBounced() { return previouslyBounced; }
    public boolean isCached() { return cached; }
    public String getCheckedAt() { return checkedAt; }

    @Override
    public String toString() {
        return "VerificationResult{email='" + email + "', status='" + status +
                "', score=" + score + "}";
    }
}
