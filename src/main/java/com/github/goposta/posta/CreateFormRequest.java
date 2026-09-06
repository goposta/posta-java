package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CreateFormRequest creates a form endpoint. Only Name is required; the
 * anti-spam defaults are sensible and can be tuned afterwards with
 * [FormsService.Update].
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateFormRequest {

    private String name;

    private String slug;

    private String description;

    /**
     * AllowedOrigins lists the site origins permitted to submit. Combined
     * with StrictOrigin it is the main defence against a copied endpoint.
     */
    @JsonProperty("allowed_origins")
    private List<String> allowedOrigins;

    @JsonProperty("strict_origin")
    private boolean strictOrigin;

    /**
     * RequireNonce demands a short-lived signed nonce with each submission,
     * obtained from [FormsService.Nonce].
     */
    @JsonProperty("require_nonce")
    private boolean requireNonce;

    /**
     * RedirectURL sends browser form posts back to a thank-you page.
     */
    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("allow_attachments")
    private boolean allowAttachments;

    /**
     * NotifyEmails receive an alert for each submission; NotifyMode is
     * "immediate", "hourly", "daily", or "off".
     */
    @JsonProperty("notify_emails")
    private List<String> notifyEmails;

    @JsonProperty("notify_mode")
    private String notifyMode;

    @JsonProperty("reply_from")
    private String replyFrom;

    @JsonProperty("reply_from_name")
    private String replyFromName;

    public CreateFormRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateFormRequest slug(String slug) { this.slug = slug; return this; }
    public String getSlug() { return slug; }
    public CreateFormRequest description(String description) { this.description = description; return this; }
    public String getDescription() { return description; }
    public CreateFormRequest allowedOrigins(List<String> allowedOrigins) { this.allowedOrigins = allowedOrigins; return this; }
    public List<String> getAllowedOrigins() { return allowedOrigins; }
    public CreateFormRequest strictOrigin(boolean strictOrigin) { this.strictOrigin = strictOrigin; return this; }
    public boolean isStrictOrigin() { return strictOrigin; }
    public CreateFormRequest requireNonce(boolean requireNonce) { this.requireNonce = requireNonce; return this; }
    public boolean isRequireNonce() { return requireNonce; }
    public CreateFormRequest redirectUrl(String redirectUrl) { this.redirectUrl = redirectUrl; return this; }
    public String getRedirectUrl() { return redirectUrl; }
    public CreateFormRequest allowAttachments(boolean allowAttachments) { this.allowAttachments = allowAttachments; return this; }
    public boolean isAllowAttachments() { return allowAttachments; }
    public CreateFormRequest notifyEmails(List<String> notifyEmails) { this.notifyEmails = notifyEmails; return this; }
    public List<String> getNotifyEmails() { return notifyEmails; }
    public CreateFormRequest notifyMode(String notifyMode) { this.notifyMode = notifyMode; return this; }
    public String getNotifyMode() { return notifyMode; }
    public CreateFormRequest replyFrom(String replyFrom) { this.replyFrom = replyFrom; return this; }
    public String getReplyFrom() { return replyFrom; }
    public CreateFormRequest replyFromName(String replyFromName) { this.replyFromName = replyFromName; return this; }
    public String getReplyFromName() { return replyFromName; }
}
