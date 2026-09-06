package com.github.goposta.posta;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Sends mail and reads the resulting delivery records.
 *
 * <p>Sending needs an API key with the {@code send} scope; {@link #list} and
 * {@link #get} need {@code read}.</p>
 */
public class Emails {

    private final Http http;

    Emails(Http http) {
        this.http = http;
    }

    /** Sends a single email. */
    public SendResponse send(SendEmailRequest request) throws PostaException, IOException {
        return http.post("/emails/send", request, SendResponse.class);
    }

    /**
     * Validates a send without delivering it. The payload reports what would
     * have happened: which recipients are suppressed, whether the sending domain
     * is verified, and how the template renders.
     */
    public JsonNode sendDryRun(SendEmailRequest request) throws PostaException, IOException {
        return http.tree("POST", "/emails/send?dry_run=true", request).path("data");
    }

    /**
     * Sends an email rendered from a stored template. Identify the template by
     * id (preferred) or by name.
     */
    public SendResponse sendTemplate(SendTemplateEmailRequest request)
            throws PostaException, IOException {
        return http.post("/emails/send-template", request, SendResponse.class);
    }

    /** Validates a template send without delivering it. */
    public JsonNode sendTemplateDryRun(SendTemplateEmailRequest request)
            throws PostaException, IOException {
        return http.tree("POST", "/emails/send-template?dry_run=true", request).path("data");
    }

    /**
     * Sends one template to many recipients, substituting per-recipient
     * variables. The response reports each recipient's outcome individually.
     */
    public BatchResponse sendBatch(BatchRequest request) throws PostaException, IOException {
        return http.post("/emails/batch", request, BatchResponse.class);
    }

    /** Validates a batch send without delivering it. */
    public JsonNode sendBatchDryRun(BatchRequest request) throws PostaException, IOException {
        return http.tree("POST", "/emails/batch?dry_run=true", request).path("data");
    }

    /** Renders a template with variables and returns it without sending. */
    public PreviewResponse preview(PreviewRequest request) throws PostaException, IOException {
        return http.post("/emails/preview", request, PreviewResponse.class);
    }

    /**
     * Checks whether an address is worth sending to: syntax, MX records,
     * disposable and role-account detection, and the caller's own suppression
     * and bounce history. Results are cached.
     */
    public VerificationResult verify(String email) throws PostaException, IOException {
        return verify(email, false);
    }

    /**
     * Checks an address, optionally bypassing the verifier cache.
     *
     * @param fresh re-check rather than reuse a cached verdict
     */
    public VerificationResult verify(String email, boolean fresh)
            throws PostaException, IOException {
        VerifyEmailRequest req = new VerifyEmailRequest().email(email);
        return http.post("/emails/verify" + Http.query("fresh", fresh ? "true" : null),
                req, VerificationResult.class);
    }

    /** Returns a lightweight delivery status, suitable for polling. */
    public EmailStatusResponse status(String uuid) throws PostaException, IOException {
        return http.get("/emails/" + Http.seg(uuid) + "/status", EmailStatusResponse.class);
    }

    /**
     * Re-enqueues a failed email. Only emails in the {@code failed} state can be
     * retried, and only up to the SMTP server's retry limit.
     */
    public SendResponse retry(String uuid) throws PostaException, IOException {
        return http.post("/emails/" + Http.seg(uuid) + "/retry", null, SendResponse.class);
    }

    /** Returns a page of emails. Needs an API key with the {@code read} scope. */
    public PageableResponse<Email> list(int page, int size) throws PostaException, IOException {
        return list(page, size, null, null);
    }

    /**
     * Returns a page of emails, filtered and sorted.
     *
     * @param q    free-text search over recipient and subject
     * @param sort column to sort by, with a leading {@code -} for descending
     */
    public PageableResponse<Email> list(int page, int size, String q, String sort)
            throws PostaException, IOException {
        return http.getPage("/emails" + Http.query("page", page, "size", size, "q", q, "sort", sort),
                Email.class);
    }

    /** Returns one email by UUID, including its rendered bodies. */
    public Email get(String uuid) throws PostaException, IOException {
        return http.get("/emails/" + Http.seg(uuid), Email.class);
    }

    /**
     * Returns a page of emails through the workspace-scoped endpoint, which a
     * session credential can also reach.
     */
    public PageableResponse<Email> listInWorkspace(int page, int size)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/emails" + Http.query("page", page, "size", size),
                Email.class);
    }

    /** Returns one email through the workspace-scoped endpoint. */
    public Email getInWorkspace(String uuid) throws PostaException, IOException {
        return http.get(Http.WS + "/emails/" + Http.seg(uuid), Email.class);
    }
}
