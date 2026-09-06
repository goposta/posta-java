package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Configures the {@code List-Unsubscribe} (RFC 2369) and
 * {@code List-Unsubscribe-Post} (RFC 8058) headers for a send.
 * <p>
 * {@code listId} and {@code url} are mutually exclusive.
 */
public class Unsubscribe {

    /**
     * Reference an existing Posta-managed UnsubscribeList by id. Posta mints
     * the signed one-click URL and a click suppresses the recipient on this
     * list only. Mutually exclusive with {@link #url}.
     */
    @JsonProperty("list_id")
    private Long listId;

    /**
     * Caller-managed unsubscribe endpoint. Posta only emits the
     * {@code List-Unsubscribe} header; you own the endpoint. Also the
     * RFC 8058 POST target when {@link #oneClick} is true (which requires
     * https). Mutually exclusive with {@link #listId}.
     */
    private String url;

    /**
     * Optional {@code mailto:} URI emitted alongside the URL in
     * {@code List-Unsubscribe} (RFC 2369). A bare address is accepted; Posta
     * prepends {@code mailto:} if missing.
     */
    private String mailto;

    /**
     * Emit {@code List-Unsubscribe-Post: List-Unsubscribe=One-Click}
     * (RFC 8058). Applies to the https URL target only; the caller-managed
     * path requires an https URL. Implied true on the Posta-managed
     * ({@code listId}) path.
     */
    @JsonProperty("one_click")
    private Boolean oneClick;

    public Unsubscribe listId(Long listId) { this.listId = listId; return this; }
    public Unsubscribe url(String url) { this.url = url; return this; }
    public Unsubscribe mailto(String mailto) { this.mailto = mailto; return this; }
    public Unsubscribe oneClick(Boolean oneClick) { this.oneClick = oneClick; return this; }

    public Long getListId() { return listId; }
    public String getUrl() { return url; }
    public String getMailto() { return mailto; }
    public Boolean getOneClick() { return oneClick; }
}
