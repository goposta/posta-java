package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Records which individual verification checks passed.
 */
public class VerificationChecks {

    private boolean syntax;
    private boolean mx;
    private boolean disposable;

    @JsonProperty("role_account")
    private boolean roleAccount;

    /** Always {@code "skipped"}; no SMTP probe is performed. */
    private String smtp;

    public boolean isSyntax() { return syntax; }
    public boolean isMx() { return mx; }
    public boolean isDisposable() { return disposable; }
    public boolean isRoleAccount() { return roleAccount; }
    public String getSmtp() { return smtp; }
}
