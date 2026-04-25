package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Posta Java client for the public email API.
 *
 * <p>Supports sending emails, template emails, batch emails,
 * and checking email delivery status.</p>
 *
 * <pre>{@code
 * PostaClient client = new PostaClient("https://posta.example.com", "your-api-key");
 * SendResponse response = client.sendEmail(new SendEmailRequest()
 *     .from("sender@example.com")
 *     .to(List.of("recipient@example.com"))
 *     .subject("Hello")
 *     .html("<h1>Hello World</h1>"));
 * }</pre>
 */
public class PostaClient {

    private final String baseUrl;
    private final String apiKey;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    /**
     * Creates a new Posta client.
     *
     * @param baseUrl Base URL of the Posta instance (e.g. https://posta.example.com)
     * @param apiKey  API key for authentication
     */
    public PostaClient(String baseUrl, String apiKey) {
        this(baseUrl, apiKey, Duration.ofSeconds(30));
    }

    /**
     * Creates a new Posta client with a custom timeout.
     *
     * @param baseUrl Base URL of the Posta instance
     * @param apiKey  API key for authentication
     * @param timeout HTTP request timeout
     */
    public PostaClient(String baseUrl, String apiKey, Duration timeout) {
        this.baseUrl = baseUrl.replaceAll("/+$", "") + "/api/v1";
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(timeout)
                .build();
        this.objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Sends a single email.
     *
     * @param request the send email request
     * @return the send response containing email ID and status
     * @throws PostaException if the API returns an error
     * @throws IOException    if an I/O error occurs
     */
    public SendResponse sendEmail(SendEmailRequest request) throws PostaException, IOException {
        return post("/emails/send", request, SendResponse.class);
    }

    /**
     * Sends an email using a template.
     *
     * @param request the send template email request
     * @return the send response containing email ID and status
     * @throws PostaException if the API returns an error
     * @throws IOException    if an I/O error occurs
     */
    public SendResponse sendTemplateEmail(SendTemplateEmailRequest request) throws PostaException, IOException {
        return post("/emails/send-template", request, SendResponse.class);
    }

    /**
     * Sends batch emails using a template.
     *
     * @param request the batch request
     * @return the batch response with per-recipient results
     * @throws PostaException if the API returns an error
     * @throws IOException    if an I/O error occurs
     */
    public BatchResponse sendBatch(BatchRequest request) throws PostaException, IOException {
        return post("/emails/batch", request, BatchResponse.class);
    }

    /**
     * Gets the delivery status of an email.
     *
     * @param emailId the email UUID
     * @return the email status response
     * @throws PostaException if the API returns an error
     * @throws IOException    if an I/O error occurs
     */
    public EmailStatusResponse getEmailStatus(String emailId) throws PostaException, IOException {
        return get("/emails/" + emailId + "/status", EmailStatusResponse.class);
    }

    /**
     * Retries a failed email delivery.
     *
     * <p>Only emails with status "failed" can be retried, subject to the retry limit
     * configured on the SMTP server.</p>
     *
     * @param emailId the email UUID
     * @return the send response containing email ID and new status
     * @throws PostaException if the API returns an error (e.g. retry limit reached)
     * @throws IOException    if an I/O error occurs
     */
    public SendResponse retryEmail(String emailId) throws PostaException, IOException {
        return post("/emails/" + emailId + "/retry", null, SendResponse.class);
    }

    /**
     * Adds an email to a named subscriber list. The list is created on first
     * use. Any prior list-scoped opt-out for this (list, email) is cleared.
     * Idempotent.
     */
    public ListSubscribeResponse subscribeToList(ListSubscribeRequest req) throws PostaException, IOException {
        return post("/subscriber-lists/subscribe", req, ListSubscribeResponse.class);
    }

    /**
     * Opts an email out of a specific subscriber list. Idempotent; does not
     * change the subscriber's global status.
     *
     * @param listId list ID
     * @param email  recipient email address
     * @param reason optional audit reason (may be null)
     */
    public ListSubscribeResponse unsubscribeFromList(long listId, String email, String reason) throws PostaException, IOException {
        java.util.Map<String, Object> body = new java.util.LinkedHashMap<>();
        body.put("email", email);
        if (reason != null && !reason.isEmpty()) {
            body.put("reason", reason);
        }
        return post("/subscriber-lists/" + listId + "/unsubscribe", body, ListSubscribeResponse.class);
    }

    /**
     * Reverses a list-scoped opt-out and (for static lists) re-adds the
     * subscriber. Idempotent.
     */
    public ListSubscribeResponse resubscribeToList(long listId, String email) throws PostaException, IOException {
        return post("/subscriber-lists/" + listId + "/resubscribe",
                java.util.Collections.singletonMap("email", email),
                ListSubscribeResponse.class);
    }


    private <T> T post(String path, Object body, Class<T> responseType) throws PostaException, IOException {
        try {
            HttpRequest.BodyPublisher publisher = body != null
                    ? HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(body))
                    : HttpRequest.BodyPublishers.noBody();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + path))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(publisher)
                    .build();
            return execute(request, responseType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Request interrupted", e);
        }
    }

    private <T> T get(String path, Class<T> responseType) throws PostaException, IOException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + path))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            return execute(request, responseType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Request interrupted", e);
        }
    }

    private <T> T execute(HttpRequest request, Class<T> responseType)
            throws IOException, InterruptedException, PostaException {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode < 200 || statusCode >= 300) {
            String message = "Unexpected status " + statusCode;
            try {
                var errorResp = objectMapper.readTree(response.body());
                var error = errorResp.get("error");
                if (error != null && error.has("message")) {
                    message = error.get("message").asText();
                }
            } catch (Exception ignored) {
            }
            throw new PostaException(statusCode, message);
        }

        var tree = objectMapper.readTree(response.body());
        var dataNode = tree.get("data");
        if (dataNode == null) {
            throw new PostaException(statusCode, "Invalid response: missing data field");
        }
        return objectMapper.treeToValue(dataNode, responseType);
    }
}
