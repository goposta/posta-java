# Posta Java Client

Official Java client for the [Posta](https://github.com/goposta/posta) email
platform.

It covers the whole Posta API: transactional and templated sending, batch
sends, address verification, templates with versions and localizations,
campaigns, subscribers and lists, suppressions and bounces, domains, SMTP
servers and relay credentials, webhooks, web forms and the messages they
collect, inbound email, workspace administration, and the platform admin
surface.

Built on `java.net.http`, with Jackson as the only dependency.

## Installation

```xml
<dependency>
    <groupId>com.github.goposta</groupId>
    <artifactId>posta-java</artifactId>
    <version>2.0.0</version>
</dependency>
```

**Requires:** Java 11+

## Quick start

```java
import com.github.goposta.posta.*;
import java.util.List;

PostaClient posta = new PostaClient("https://posta.example.com", "psk_your_api_key");

SendResponse resp = posta.emails.send(new SendEmailRequest()
        .from("Acme <hello@example.com>")
        .to(List.of("user@example.com"))
        .subject("Hello from Posta")
        .html("<h1>Hello!</h1>"));

System.out.println("sent: id=" + resp.getId() + " status=" + resp.getStatus());
```

## Credentials

Most machine-facing endpoints take an API key:

```java
PostaClient posta = new PostaClient("https://posta.example.com", "psk_...");
```

Account-level endpoints (`/users/me/*`) and the platform admin surface accept
only a user session token — an API key is never a valid credential there:

```java
AuthResponse auth = new PostaClient(baseUrl, "").auth.login("admin@example.com", password);
PostaClient admin = PostaClient.withToken(baseUrl, auth.getToken());
```

### Workspaces

Workspace-scoped endpoints resolve the active workspace from the
`X-Posta-Workspace-Id` header. A workspace-bound API key already carries its
workspace; an account-wide key or a user session must name one:

```java
PostaClient posta = new PostaClient(baseUrl, apiKey, Duration.ofSeconds(30), 42L);
```

### API key scopes

A key reaches only what its scopes allow. `Scopes.SEND` covers the public send
API; `READ` and `WRITE` cover reading and mutating workspace resources;
`WEBHOOKS` covers webhook management; `ADMIN` covers tenant administration
(keys, members, settings); `ALL` grants everything.

A 403 from an endpoint you expect to work usually means a missing scope —
`e.isForbidden()` distinguishes it.

## Client options

```java
PostaClient posta = new PostaClient(
        "https://posta.example.com",
        "psk_...",
        Duration.ofSeconds(15),                       // default 30s
        42L,                                          // active workspace
        Map.of("X-Request-Source", "batch-job"),      // extra headers
        "my-app/1.0");                                // User-Agent
```

## Resources

| Field | Covers |
|---|---|
| `emails` | send, sendTemplate, sendBatch, preview, verify, status, retry, list, get |
| `bounces` | list, record |
| `suppressions` | list, add, remove |
| `webhooks` | list, create, delete, deliveries |
| `templates` | CRUD, versions, localizations, preview, sendTest, import/export |
| `languages`, `stylesheets` | CRUD |
| `domains` | add, list, get, verify, delete |
| `smtpServers`, `smtpCredentials` | CRUD, test, revoke |
| `subscribers` | CRUD, JSON and CSV bulk import |
| `subscriberLists` | CRUD, members, segments, subscribe/unsubscribe/resubscribe |
| `unsubscribeLists`, `contacts` | CRUD / read |
| `campaigns` | CRUD, send, pause, resume, cancel, duplicate, messages, analytics |
| `analytics` | emails, dashboard, providers, dashboardStats |
| `forms` | CRUD, rotateKey, snippet, nonce, public submit |
| `messages`, `messageFilters` | list, triage, reply, attachments; filter CRUD and dry-run |
| `inbound` | list, get, retry, raw `.eml`, attachments |
| `apiKeys` | create, list, get, revoke, delete |
| `workspaces` | CRUD, members, invitations, settings, SSO, audit log, export/import, GDPR |
| `users` | profile, password, 2FA, sessions, settings, notifications (session credential) |
| `auth` | login, register, password reset, email verification, SSO discovery |
| `admin` | users, plans, shared servers, domains, settings, announcements, events, metrics |
| `system` | info, healthz, readyz (the class is `SystemInfo`, so `import …posta.*` does not clash with `java.lang.System`) |

Request objects are fluent builders; response objects expose getters.

## Examples

### Templated and batch sends

```java
posta.emails.sendTemplate(new SendTemplateEmailRequest()
        .template("welcome")
        .to(List.of("user@example.com"))
        .templateData(Map.of("name", "Ada")));

BatchResponse batch = posta.emails.sendBatch(new BatchRequest()
        .template("welcome")
        .recipients(List.of(
                new BatchRecipient().email("a@example.com").templateData(Map.of("name", "Ada")),
                new BatchRecipient().email("b@example.com").templateData(Map.of("name", "Grace")))));

System.out.println(batch.getSent() + " sent, " + batch.getFailed() + " failed");
```

Validate without sending:

```java
JsonNode report = posta.emails.sendDryRun(request);
```

### One-click unsubscribe

Reference a Posta-managed unsubscribe list and Posta mints the signed one-click
URL, recording opt-outs against that list alone:

```java
posta.emails.send(new SendEmailRequest()
        .from("news@example.com")
        .to(List.of("user@example.com"))
        .subject("This week")
        .html("<p>…</p>")
        .unsubscribe(new Unsubscribe().listId(7L)));
```

### Templates, versions, localizations

```java
Template tpl = posta.templates.create(
        new CreateTemplateRequest().name("welcome").defaultLanguage("en"));
TemplateVersion ver = posta.templates.createVersion(tpl.getId(), new CreateVersionRequest());
posta.templates.createLocalization(tpl.getId(), ver.getId(), new CreateLocalizationRequest()
        .language("en")
        .subjectTemplate("Welcome, {{.name}}")
        .htmlTemplate("<h1>Welcome, {{.name}}</h1>"));
posta.templates.activateVersion(tpl.getId(), ver.getId());
```

### Campaigns

```java
Campaign camp = posta.campaigns.create(new CreateCampaignRequest()
        .name("Launch").subject("We're live").fromEmail("news@example.com")
        .listId(listId).templateId(tpl.getId()));
posta.campaigns.send(camp.getId());

CampaignAnalyticsResponse stats = posta.campaigns.analytics(camp.getId());
System.out.println("open rate " + stats.getAnalytics().getOpenRate() + "%");
```

### Paging

`page` is zero-based.

```java
PageableResponse<Email> page = posta.emails.list(0, 50, "user@example.com", "-created_at");
System.out.println(page.getPageable().getTotalElements());
for (Email email : page.getData()) {
    System.out.println(email.getSubject());
}
```

### Verifying webhooks

Posta signs each delivery with HMAC-SHA256 over the raw body, in the
`X-Posta-Signature` header as `sha256=<hex>`. Verify against the exact bytes
received — re-serializing the JSON changes them:

```java
byte[] raw = request.getInputStream().readAllBytes();
String signature = request.getHeader(Http.SIGNATURE_HEADER);

if (!WebhookEvents.verifySignature(raw, signature, secret)) {
    response.setStatus(401);
    return;
}

JsonNode event = mapper.readTree(raw);
switch (event.path("event").asText()) {
    case WebhookEvents.EMAIL_SENT -> log.info("delivered {}", event.path("email_id").asText());
    case WebhookEvents.EMAIL_FAILED -> log.warn("failed {}", event.path("email_id").asText());
    default -> { }
}
response.setStatus(200);
```

Event constants live on `WebhookEvents`: `EMAIL_SENT`, `EMAIL_FAILED`,
`EMAIL_INBOUND`, `EMAIL_UNSUBSCRIBED`, `EMAIL_COMPLAINED`, `CAMPAIGN_STARTED`,
`CAMPAIGN_COMPLETED`, `MESSAGE_RECEIVED`, `MESSAGE_SPAM`. Typed payloads:
`WebhookEvent`, `CampaignWebhookEvent`, `ComplaintWebhookEvent`,
`UnsubscribeWebhookEvent`, `InboundWebhookEvent`, `MessageWebhookEvent`.

### Web forms

```java
Form form = posta.forms.create(new CreateFormRequest()
        .name("Contact")
        .allowedOrigins(List.of("https://example.com"))
        .strictOrigin(true)
        .notifyEmails(List.of("team@example.com")));

FormSnippet snippet = posta.forms.snippet(form.getId());
System.out.println(snippet.getHtml());

PageableResponse<Message> inbox = posta.messages.list(0, 20, null, null, "new", null);
```

## Errors

Non-2xx responses throw `PostaException`, carrying the status and the API's
structured error code:

```java
try {
    posta.emails.send(request);
} catch (PostaException e) {
    log.error("posta {}: {}", e.getStatusCode(), e.getMessage());
    if (e.isRateLimited()) {
        retryLater();
    }
}
```

Methods cover the common cases: `isNotFound()`, `isUnauthorized()`,
`isForbidden()`, `isRateLimited()`, plus `getErrorCode()`.

## License

Apache-2.0
