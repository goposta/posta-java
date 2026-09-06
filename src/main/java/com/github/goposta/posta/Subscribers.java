package com.github.goposta.posta;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Manages the people a workspace sends campaigns to. */
public class Subscribers {

    private final Http http;

    Subscribers(Http http) {
        this.http = http;
    }

    /** Adds a subscriber. */
    public Subscriber create(CreateSubscriberRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/subscribers", request, Subscriber.class);
    }

    /** Returns a page of subscribers. */
    public PageableResponse<Subscriber> list(int page, int size)
            throws PostaException, IOException {
        return list(page, size, null, null);
    }

    /**
     * Returns a page of subscribers.
     *
     * @param search free-text search over email and name
     * @param status keeps only subscribers in one status
     */
    public PageableResponse<Subscriber> list(int page, int size, String search, String status)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/subscribers"
                + Http.query("page", page, "size", size, "search", search, "status", status),
                Subscriber.class);
    }

    /** Returns one subscriber. */
    public Subscriber get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/subscribers/" + Http.seg(id), Subscriber.class);
    }

    /** Changes a subscriber. The email address itself cannot be changed. */
    public Subscriber update(long id, UpdateSubscriberRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/subscribers/" + Http.seg(id), request, Subscriber.class);
    }

    /** Removes a subscriber and its list memberships. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/subscribers/" + Http.seg(id));
    }

    /**
     * Adds or updates many subscribers at once. Existing addresses are updated
     * rather than duplicated.
     */
    public BulkImportResult importJson(List<CreateSubscriberRequest> subscribers)
            throws PostaException, IOException {
        return http.post(Http.WS + "/subscribers/import/json",
                Map.of("subscribers", subscribers), BulkImportResult.class);
    }

    /**
     * Adds or updates many subscribers from a CSV document, uploaded as
     * multipart/form-data.
     *
     * @param columnMapping maps zero-based column indexes to subscriber fields,
     *                      defaulting to {@code {0: "email", 1: "name"}}. A
     *                      {@code custom_fields.} prefix routes a column into
     *                      the subscriber's custom fields. The header row is
     *                      always skipped.
     */
    public BulkImportResult importCsv(String filename, byte[] csv,
                                      Map<Integer, String> columnMapping)
            throws PostaException, IOException {
        Map<String, String> fields = new LinkedHashMap<>();
        if (columnMapping != null && !columnMapping.isEmpty()) {
            Map<String, String> raw = new LinkedHashMap<>();
            for (Map.Entry<Integer, String> e : columnMapping.entrySet()) {
                raw.put(String.valueOf(e.getKey()), e.getValue());
            }
            try {
                fields.put("column_mapping", http.mapper().writeValueAsString(raw));
            } catch (JsonProcessingException e) {
                throw new IOException("Failed to encode column mapping", e);
            }
        }
        return http.upload(Http.WS + "/subscribers/import/csv", "file", filename, csv,
                fields, BulkImportResult.class);
    }

    /** Convenience overload for CSV supplied as a string. */
    public BulkImportResult importCsv(String filename, String csv)
            throws PostaException, IOException {
        return importCsv(filename, csv.getBytes(StandardCharsets.UTF_8), null);
    }
}
