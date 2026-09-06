package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * HTTP transport shared by every resource client.
 *
 * <p>Unwraps Posta's {@code {"success": …, "data": …}} envelope and turns
 * non-2xx responses into {@link PostaException}. Built on {@code java.net.http},
 * so the only dependency is Jackson.</p>
 */
public class Http {

    /** Header that selects the active workspace for workspace-scoped endpoints. */
    public static final String WORKSPACE_HEADER = "X-Posta-Workspace-Id";

    /** Header carrying a webhook delivery's HMAC signature. */
    public static final String SIGNATURE_HEADER = "X-Posta-Signature";

    /** Path prefix shared by every workspace-scoped endpoint. */
    public static final String WS = "/workspaces/current";

    /** Client library version, reported in the User-Agent header. */
    public static final String VERSION = "2.0.0";

    private final String baseUrl;
    private final String rootUrl;
    private final String credential;
    private final HttpClient httpClient;
    private final ObjectMapper mapper;
    private final Map<String, String> extraHeaders;
    private final Duration timeout;

    Http(String baseUrl, String credential, Duration timeout,
         Long workspaceId, Map<String, String> headers, String userAgent) {
        this.rootUrl = baseUrl.replaceAll("/+$", "");
        this.baseUrl = this.rootUrl + "/api/v1";
        this.credential = credential;
        this.timeout = timeout;
        this.httpClient = HttpClient.newBuilder().connectTimeout(timeout).build();
        this.mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Map<String, String> h = new LinkedHashMap<>();
        if (headers != null) {
            h.putAll(headers);
        }
        h.put("User-Agent", userAgent != null ? userAgent : "posta-java/" + VERSION);
        if (workspaceId != null) {
            h.put(WORKSPACE_HEADER, String.valueOf(workspaceId));
        }
        this.extraHeaders = h;
    }

    /** The versioned API root, e.g. {@code https://posta.example.com/api/v1}. */
    public String baseUrl() {
        return baseUrl;
    }

    /** The Jackson mapper, for callers decoding a {@link JsonNode} themselves. */
    public ObjectMapper mapper() {
        return mapper;
    }

    /**
     * Builds a query string from alternating key/value pairs, omitting any whose
     * value is null or empty.
     *
     * <pre>{@code query("page", 0, "size", 50, "q", search)}</pre>
     */
    public static String query(Object... pairs) {
        if (pairs.length % 2 != 0) {
            throw new IllegalArgumentException("query() takes alternating key/value pairs");
        }
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < pairs.length; i += 2) {
            Object value = pairs[i + 1];
            if (value == null || "".equals(value)) {
                continue;
            }
            parts.add(enc(String.valueOf(pairs[i])) + "=" + enc(String.valueOf(value)));
        }
        return parts.isEmpty() ? "" : "?" + String.join("&", parts);
    }

    /** URL-encodes a path segment. */
    public static String seg(Object value) {
        return enc(String.valueOf(value));
    }

    private static String enc(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    /** GET, decoding the envelope's {@code data} into {@code type}. */
    public <T> T get(String path, Class<T> type) throws PostaException, IOException {
        return data(send("GET", baseUrl + path, null, "application/json"), type);
    }

    /** GET, decoding the envelope's {@code data} into a {@code List<T>}. */
    public <T> List<T> getList(String path, Class<T> element) throws PostaException, IOException {
        JsonNode node = tree(send("GET", baseUrl + path, null, "application/json")).get("data");
        if (node == null || node.isNull()) {
            return List.of();
        }
        return mapper.convertValue(node,
                mapper.getTypeFactory().constructCollectionType(List.class, element));
    }

    /** GET, returning the full paginated envelope ({@code data} plus {@code pageable}). */
    public <T> PageableResponse<T> getPage(String path, Class<T> element)
            throws PostaException, IOException {
        String body = send("GET", baseUrl + path, null, "application/json");
        return mapper.readValue(body,
                mapper.getTypeFactory().constructParametricType(PageableResponse.class, element));
    }

    /** POST, decoding the envelope's {@code data} into {@code type}. */
    public <T> T post(String path, Object body, Class<T> type) throws PostaException, IOException {
        return data(send("POST", baseUrl + path, json(body), "application/json"), type);
    }

    /** POST, decoding the envelope's {@code data} into a {@code List<T>}. */
    public <T> List<T> postList(String path, Object body, Class<T> element)
            throws PostaException, IOException {
        JsonNode node = tree(send("POST", baseUrl + path, json(body), "application/json")).get("data");
        if (node == null || node.isNull()) {
            return List.of();
        }
        return mapper.convertValue(node,
                mapper.getTypeFactory().constructCollectionType(List.class, element));
    }

    /** PUT, decoding the envelope's {@code data} into {@code type}. */
    public <T> T put(String path, Object body, Class<T> type) throws PostaException, IOException {
        return data(send("PUT", baseUrl + path, json(body), "application/json"), type);
    }

    /** PUT, decoding the envelope's {@code data} into a {@code List<T>}. */
    public <T> List<T> putList(String path, Object body, Class<T> element)
            throws PostaException, IOException {
        JsonNode node = tree(send("PUT", baseUrl + path, json(body), "application/json")).get("data");
        if (node == null || node.isNull()) {
            return List.of();
        }
        return mapper.convertValue(node,
                mapper.getTypeFactory().constructCollectionType(List.class, element));
    }

    /** PATCH, decoding the envelope's {@code data} into {@code type}. */
    public <T> T patch(String path, Object body, Class<T> type) throws PostaException, IOException {
        return data(send("PATCH", baseUrl + path, json(body), "application/json"), type);
    }

    /** DELETE, decoding the envelope's {@code data} into {@code type}. */
    public <T> T delete(String path, Object body, Class<T> type) throws PostaException, IOException {
        return data(send("DELETE", baseUrl + path, json(body), "application/json"), type);
    }

    /** DELETE, discarding the response body. */
    public void delete(String path) throws PostaException, IOException {
        send("DELETE", baseUrl + path, null, "application/json");
    }

    /** DELETE with a request body, discarding the response. */
    public void delete(String path, Object body) throws PostaException, IOException {
        send("DELETE", baseUrl + path, json(body), "application/json");
    }

    /** Issues a request and returns the raw envelope as a tree. */
    public JsonNode tree(String method, String path, Object body)
            throws PostaException, IOException {
        return tree(send(method, baseUrl + path, json(body), "application/json"));
    }

    /**
     * Fetches a URL outside the versioned API and decodes the body as-is.
     *
     * <p>The health probes answer with a bare object, not the
     * {@code {"success", "data"}} envelope every /api/v1 endpoint uses.</p>
     */
    public <T> T getRoot(String path, Class<T> type) throws PostaException, IOException {
        String body = send("GET", rootUrl + path, null, "application/json");
        return mapper.readValue(body, type);
    }

    /**
     * Downloads a binary body, for endpoints that answer with a file rather than
     * JSON — message and inbound attachments, and raw {@code .eml} messages.
     */
    public Download download(String path) throws PostaException, IOException {
        try {
            HttpRequest request = builder(baseUrl + path)
                    .GET()
                    .build();
            HttpResponse<byte[]> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw errorFor(response.statusCode(), new String(response.body(), StandardCharsets.UTF_8));
            }
            String type = response.headers().firstValue("Content-Type")
                    .orElse("application/octet-stream");
            return new Download(response.body(), type);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Request interrupted", e);
        }
    }

    /**
     * POSTs a {@code multipart/form-data} body, decoding the envelope's
     * {@code data} into {@code type}.
     */
    public <T> T upload(String path, String field, String filename, byte[] content,
                        Map<String, String> fields, Class<T> type)
            throws PostaException, IOException {
        String boundary = "posta" + java.util.UUID.randomUUID().toString().replace("-", "");
        var out = new java.io.ByteArrayOutputStream();
        try {
            if (fields != null) {
                for (Map.Entry<String, String> e : fields.entrySet()) {
                    out.write(("--" + boundary + "\r\nContent-Disposition: form-data; name=\""
                            + e.getKey() + "\"\r\n\r\n" + e.getValue() + "\r\n")
                            .getBytes(StandardCharsets.UTF_8));
                }
            }
            out.write(("--" + boundary + "\r\nContent-Disposition: form-data; name=\"" + field
                    + "\"; filename=\"" + filename + "\"\r\n"
                    + "Content-Type: application/octet-stream\r\n\r\n")
                    .getBytes(StandardCharsets.UTF_8));
            out.write(content);
            out.write(("\r\n--" + boundary + "--\r\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IOException("Failed to build multipart body", e);
        }

        String body = sendBytes("POST", baseUrl + path, out.toByteArray(),
                "multipart/form-data; boundary=" + boundary);
        return data(body, type);
    }

    private String json(Object body) throws IOException {
        return body == null ? null : mapper.writeValueAsString(body);
    }

    private <T> T data(String body, Class<T> type) throws PostaException, IOException {
        if (type == Void.class || body == null || body.isEmpty()) {
            return null;
        }
        JsonNode node = tree(body).get("data");
        if (node == null || node.isNull()) {
            return null;
        }
        return mapper.treeToValue(node, type);
    }

    private JsonNode tree(String body) throws IOException {
        return body == null || body.isEmpty()
                ? mapper.createObjectNode()
                : mapper.readTree(body);
    }

    private String send(String method, String url, String body, String contentType)
            throws PostaException, IOException {
        return sendBytes(method, url,
                body == null ? null : body.getBytes(StandardCharsets.UTF_8), contentType);
    }

    private String sendBytes(String method, String url, byte[] body, String contentType)
            throws PostaException, IOException {
        try {
            HttpRequest.BodyPublisher publisher = body != null
                    ? HttpRequest.BodyPublishers.ofByteArray(body)
                    : HttpRequest.BodyPublishers.noBody();
            HttpRequest.Builder b = builder(url).method(method, publisher);
            if (contentType != null) {
                b.header("Content-Type", contentType);
            }
            HttpResponse<String> response =
                    httpClient.send(b.build(), HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw errorFor(response.statusCode(), response.body());
            }
            return response.body();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Request interrupted", e);
        }
    }

    private HttpRequest.Builder builder(String url) {
        HttpRequest.Builder b = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(timeout)
                .header("Accept", "application/json");
        if (credential != null && !credential.isEmpty()) {
            b.header("Authorization", "Bearer " + credential);
        }
        for (Map.Entry<String, String> e : extraHeaders.entrySet()) {
            b.header(e.getKey(), e.getValue());
        }
        return b;
    }

    private PostaException errorFor(int statusCode, String body) {
        try {
            JsonNode error = mapper.readTree(body).get("error");
            if (error != null && !error.isNull()) {
                String message = text(error, "message");
                if (message == null || message.isEmpty()) {
                    message = text(error, "error");
                }
                if (message == null || message.isEmpty()) {
                    message = "Unexpected status " + statusCode;
                }
                return new PostaException(statusCode, message, text(error, "code"));
            }
        } catch (Exception ignored) {
            // An error response need not carry a JSON envelope; the status still does.
        }
        return new PostaException(statusCode, "Unexpected status " + statusCode);
    }

    private static String text(JsonNode node, String field) {
        JsonNode value = node.get(field);
        return value == null || value.isNull() ? null : value.asText();
    }

    /** A downloaded file: its bytes and the Content-Type the server sent. */
    public static class Download {
        private final byte[] data;
        private final String contentType;

        Download(byte[] data, String contentType) {
            this.data = data;
            this.contentType = contentType;
        }

        /** The file's bytes. */
        public byte[] getData() {
            return data;
        }

        /** The Content-Type header the server sent. */
        public String getContentType() {
            return contentType;
        }
    }
}
