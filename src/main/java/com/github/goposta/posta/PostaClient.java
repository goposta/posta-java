package com.github.goposta.posta;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

/**
 * Client for the Posta email platform.
 *
 * <p>Its public fields group the API by resource. Every method returns the
 * decoded {@code data} from the API envelope and throws {@link PostaException}
 * on a non-2xx response.</p>
 *
 * <h2>Credentials</h2>
 *
 * <p>Most machine-facing endpoints take an API key. Account-level endpoints
 * ({@code /users/me/*}) and the platform admin surface accept only a user
 * session token, which {@link #withToken} supplies.</p>
 *
 * <h2>Workspaces</h2>
 *
 * <p>Workspace-scoped endpoints resolve the active workspace from the
 * {@code X-Posta-Workspace-Id} header. A workspace-bound API key carries its
 * workspace already; an account-wide key or a user session must name one.</p>
 *
 * <pre>{@code
 * PostaClient posta = new PostaClient("https://posta.example.com", "psk_your_api_key");
 *
 * SendResponse resp = posta.emails.send(new SendEmailRequest()
 *     .from("Acme <hello@example.com>")
 *     .to(List.of("user@example.com"))
 *     .subject("Hello from Posta")
 *     .html("<h1>Hello!</h1>"));
 * }</pre>
 */
public class PostaClient {

    private final Http http;

    /** Sends mail and reads the resulting delivery records. */
    public final Emails emails;
    /** Reads recorded bounces and complaints. */
    public final Bounces bounces;
    /** Manages the workspace suppression list. */
    public final Suppressions suppressions;
    /** Registers webhook endpoints and reads delivery attempts. */
    public final Webhooks webhooks;
    /** Manages templates, versions, and localizations. */
    public final Templates templates;
    /** Manages the workspace's template languages. */
    public final Languages languages;
    /** Manages reusable CSS for templates. */
    public final Stylesheets stylesheets;
    /** Manages sending domains and their DNS verification. */
    public final Domains domains;
    /** Manages the SMTP servers Posta delivers through. */
    public final SmtpServers smtpServers;
    /** Manages credentials for the SMTP relay listener. */
    public final SmtpCredentials smtpCredentials;
    /** Manages subscriber records and bulk imports. */
    public final Subscribers subscribers;
    /** Manages lists, their members, and opt-outs. */
    public final SubscriberLists subscriberLists;
    /** Manages the lists behind List-Unsubscribe headers. */
    public final UnsubscribeLists unsubscribeLists;
    /** Reads the derived contact view of everyone mailed. */
    public final Contacts contacts;
    /** Manages bulk campaigns and their lifecycle. */
    public final Campaigns campaigns;
    /** Reads delivery and engagement analytics. */
    public final Analytics analytics;
    /** Manages web form endpoints and their embed snippets. */
    public final Forms forms;
    /** Reads and triages web form submissions. */
    public final Messages messages;
    /** Manages the spam filters applied to submissions. */
    public final MessageFilters messageFilters;
    /** Reads inbound email received by Posta. */
    public final Inbound inbound;
    /** Manages the workspace's API keys. */
    public final ApiKeys apiKeys;
    /** Manages workspaces, members, invitations, and settings. */
    public final Workspaces workspaces;
    /** Manages the signed-in account (session credential only). */
    public final Users users;
    /** Login, registration, and password recovery. */
    public final Auth auth;
    /** Platform administration (admin session only). */
    public final Admin admin;
    /** Build and health information. */
    public final SystemInfo system;

    /**
     * Creates a client authenticated with an API key.
     *
     * @param baseUrl base URL of the Posta instance, e.g. https://posta.example.com
     * @param apiKey  an API key ({@code psk_…}), or a session token via {@link #withToken}
     */
    public PostaClient(String baseUrl, String apiKey) {
        this(baseUrl, apiKey, Duration.ofSeconds(30), null, null, null);
    }

    /**
     * Creates a client with a custom timeout.
     *
     * @param timeout HTTP request timeout
     */
    public PostaClient(String baseUrl, String apiKey, Duration timeout) {
        this(baseUrl, apiKey, timeout, null, null, null);
    }

    /**
     * Creates a client bound to a workspace.
     *
     * @param workspaceId active workspace for workspace-scoped endpoints
     */
    public PostaClient(String baseUrl, String apiKey, Duration timeout, Long workspaceId) {
        this(baseUrl, apiKey, timeout, workspaceId, null, null);
    }

    /**
     * Creates a fully configured client.
     *
     * @param headers   extra headers sent with every request
     * @param userAgent overrides the User-Agent header
     */
    public PostaClient(String baseUrl, String apiKey, Duration timeout, Long workspaceId,
                       Map<String, String> headers, String userAgent) {
        this.http = new Http(baseUrl, apiKey,
                timeout == null ? Duration.ofSeconds(30) : timeout,
                workspaceId, headers, userAgent);

        this.emails = new Emails(http);
        this.bounces = new Bounces(http);
        this.suppressions = new Suppressions(http);
        this.webhooks = new Webhooks(http);
        this.templates = new Templates(http);
        this.languages = new Languages(http);
        this.stylesheets = new Stylesheets(http);
        this.domains = new Domains(http);
        this.smtpServers = new SmtpServers(http);
        this.smtpCredentials = new SmtpCredentials(http);
        this.subscribers = new Subscribers(http);
        this.subscriberLists = new SubscriberLists(http);
        this.unsubscribeLists = new UnsubscribeLists(http);
        this.contacts = new Contacts(http);
        this.campaigns = new Campaigns(http);
        this.analytics = new Analytics(http);
        this.forms = new Forms(http);
        this.messages = new Messages(http);
        this.messageFilters = new MessageFilters(http);
        this.inbound = new Inbound(http);
        this.apiKeys = new ApiKeys(http);
        this.workspaces = new Workspaces(http);
        this.users = new Users(http);
        this.auth = new Auth(http);
        this.admin = new Admin(http);
        this.system = new SystemInfo(http);
    }

    /**
     * Creates a client authenticated with a user session token (JWT), as
     * returned by {@link Auth#login}. Account-level endpoints under
     * {@code /users/me} and the platform admin surface accept only this
     * credential.
     */
    public static PostaClient withToken(String baseUrl, String token) {
        return new PostaClient(baseUrl, token);
    }

    /** Creates a session-authenticated client bound to a workspace. */
    public static PostaClient withToken(String baseUrl, String token, Long workspaceId) {
        return new PostaClient(baseUrl, token, Duration.ofSeconds(30), workspaceId);
    }

    // ── Compatibility ────────────────────────────────────────────────────
    //
    // Kept for source compatibility with earlier releases, which exposed the
    // send surface directly on the client. New code should use the resource
    // fields, which cover the whole API rather than this subset.

    /** @deprecated Use {@code client.emails.send}. */
    @Deprecated
    public SendResponse sendEmail(SendEmailRequest request) throws PostaException, IOException {
        return emails.send(request);
    }

    /** @deprecated Use {@code client.emails.sendDryRun}. */
    @Deprecated
    public JsonNode sendEmailDryRun(SendEmailRequest request) throws PostaException, IOException {
        return emails.sendDryRun(request);
    }

    /** @deprecated Use {@code client.emails.sendTemplate}. */
    @Deprecated
    public SendResponse sendTemplateEmail(SendTemplateEmailRequest request)
            throws PostaException, IOException {
        return emails.sendTemplate(request);
    }

    /** @deprecated Use {@code client.emails.sendTemplateDryRun}. */
    @Deprecated
    public JsonNode sendTemplateEmailDryRun(SendTemplateEmailRequest request)
            throws PostaException, IOException {
        return emails.sendTemplateDryRun(request);
    }

    /** @deprecated Use {@code client.emails.sendBatch}. */
    @Deprecated
    public BatchResponse sendBatch(BatchRequest request) throws PostaException, IOException {
        return emails.sendBatch(request);
    }

    /** @deprecated Use {@code client.emails.sendBatchDryRun}. */
    @Deprecated
    public JsonNode sendBatchDryRun(BatchRequest request) throws PostaException, IOException {
        return emails.sendBatchDryRun(request);
    }

    /** @deprecated Use {@code client.emails.preview}. */
    @Deprecated
    public PreviewResponse previewTemplate(PreviewRequest request)
            throws PostaException, IOException {
        return emails.preview(request);
    }

    /** @deprecated Use {@code client.emails.verify}. */
    @Deprecated
    public VerificationResult verifyEmail(VerifyEmailRequest request)
            throws PostaException, IOException {
        return emails.verify(request.getEmail());
    }

    /** @deprecated Use {@code client.emails.status}. */
    @Deprecated
    public EmailStatusResponse getEmailStatus(String emailId) throws PostaException, IOException {
        return emails.status(emailId);
    }

    /** @deprecated Use {@code client.emails.retry}. */
    @Deprecated
    public SendResponse retryEmail(String emailId) throws PostaException, IOException {
        return emails.retry(emailId);
    }

    /** @deprecated Use {@code client.emails.list}, which can also filter and sort. */
    @Deprecated
    public PageableResponse<Email> listEmails(int page, int size)
            throws PostaException, IOException {
        return emails.list(page, size);
    }

    /** @deprecated Use {@code client.emails.get}. */
    @Deprecated
    public Email getEmail(String id) throws PostaException, IOException {
        return emails.get(id);
    }

    /** @deprecated Use {@code client.bounces.list}. */
    @Deprecated
    public PageableResponse<Bounce> listBounces(int page, int size)
            throws PostaException, IOException {
        return bounces.list(page, size);
    }

    /** @deprecated Use {@code client.webhooks.list}. */
    @Deprecated
    public PageableResponse<Webhook> listWebhooks(int page, int size)
            throws PostaException, IOException {
        return webhooks.list(page, size);
    }

    /** @deprecated Use {@code client.webhooks.create}. */
    @Deprecated
    public Webhook createWebhook(CreateWebhookRequest request) throws PostaException, IOException {
        return webhooks.create(request);
    }

    /** @deprecated Use {@code client.webhooks.delete}. */
    @Deprecated
    public void deleteWebhook(long id) throws PostaException, IOException {
        webhooks.delete(id);
    }

    /** @deprecated Use {@code client.webhooks.listDeliveries}. */
    @Deprecated
    public PageableResponse<WebhookDelivery> listWebhookDeliveries(int page, int size)
            throws PostaException, IOException {
        return webhooks.listDeliveries(page, size);
    }

    /** @deprecated Use {@code client.subscriberLists.subscribe}. */
    @Deprecated
    public ListSubscribeResponse subscribeToList(ListSubscribeRequest request)
            throws PostaException, IOException {
        return subscriberLists.subscribe(request);
    }

    /** @deprecated Use {@code client.subscriberLists.unsubscribe}. */
    @Deprecated
    public ListSubscribeResponse unsubscribeFromList(long listId, ListUnsubscribeRequest request)
            throws PostaException, IOException {
        return subscriberLists.unsubscribe(listId, request);
    }

    /** @deprecated Use {@code client.subscriberLists.resubscribe}. */
    @Deprecated
    public ListSubscribeResponse resubscribeToList(long listId, String email)
            throws PostaException, IOException {
        return subscriberLists.resubscribe(listId, email);
    }
}
