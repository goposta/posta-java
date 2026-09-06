import com.github.goposta.posta.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * Exercises a representative slice of the Posta Java client: sending,
 * templates, batches, verification, and webhook handling.
 */
public class SendEmailExample {

    public static void main(String[] args) throws Exception {
        PostaClient posta = new PostaClient(
                "https://posta.example.com", "psk_your_api_key",
                Duration.ofSeconds(30), 1L);

        // A plain transactional send.
        SendResponse resp = posta.emails.send(new SendEmailRequest()
                .from("Acme <hello@example.com>")
                .to(List.of("user@example.com"))
                .subject("Hello from Posta")
                .html("<h1>Hello!</h1><p>This is a test email.</p>")
                .text("Hello! This is a test email."));
        System.out.println("sent: id=" + resp.getId() + " status=" + resp.getStatus());

        // Poll its delivery status.
        EmailStatusResponse status = posta.emails.status(resp.getId());
        System.out.println("status: " + status.getStatus()
                + " (retries: " + status.getRetryCount() + ")");

        // Send from a stored template.
        posta.emails.sendTemplate(new SendTemplateEmailRequest()
                .template("welcome")
                .to(List.of("user@example.com"))
                .from("noreply@example.com")
                .templateData(Map.of("name", "Alice")));

        // Batch send with per-recipient variables.
        BatchResponse batch = posta.emails.sendBatch(new BatchRequest()
                .template("welcome")
                .from("noreply@example.com")
                .recipients(List.of(
                        new BatchRecipient().email("a@example.com")
                                .templateData(Map.of("name", "Ada")),
                        new BatchRecipient().email("b@example.com")
                                .templateData(Map.of("name", "Grace")))));
        System.out.println("batch: " + batch.getSent() + " sent, "
                + batch.getFailed() + " failed");

        // Check an address before adding it to a list.
        VerificationResult verdict = posta.emails.verify("user@example.com");
        System.out.println("verify: " + verdict.getStatus()
                + " (score " + verdict.getScore() + ")");

        // Page through recent emails.
        PageableResponse<Email> page = posta.emails.list(0, 10, null, "-created_at");
        System.out.println("emails: " + page.getData().size()
                + " of " + page.getPageable().getTotalElements());

        // Register a webhook. The secret is returned only here.
        Webhook hook = posta.webhooks.create(new CreateWebhookRequest()
                .url("https://example.com/hooks/posta")
                .events(List.of(WebhookEvents.EMAIL_SENT, WebhookEvents.EMAIL_FAILED)));
        System.out.println("webhook " + hook.getId()
                + " registered; store secret " + hook.getSecret());

        // Errors carry the API's status and message.
        try {
            posta.emails.get("does-not-exist");
        } catch (PostaException e) {
            if (e.isNotFound()) {
                System.out.println("no such email, as expected");
            } else {
                throw e;
            }
        }
    }

    /**
     * Authenticates an incoming Posta webhook and acts on it.
     *
     * <p>Verify the signature against the exact bytes received: decoding and
     * re-encoding the JSON changes them, and the HMAC will not match. Read the
     * raw request body, not a parsed one.</p>
     */
    static void handleWebhook(byte[] rawBody, String signature, String secret) throws Exception {
        if (!WebhookEvents.verifySignature(rawBody, signature, secret)) {
            throw new IllegalArgumentException("bad signature");
        }

        JsonNode event = new ObjectMapper().readTree(rawBody);
        String type = event.path("event").asText();
        if (WebhookEvents.EMAIL_SENT.equals(type)) {
            System.out.println("delivered: " + event.path("email_id").asText());
        } else if (WebhookEvents.EMAIL_FAILED.equals(type)) {
            System.out.println("failed: " + event.path("email_id").asText());
        }
    }
}
