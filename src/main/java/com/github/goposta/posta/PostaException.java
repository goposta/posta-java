package com.github.goposta.posta;

/**
 * Thrown when the Posta API answers with a non-2xx status.
 */
public class PostaException extends Exception {

    private static final long serialVersionUID = 1L;

    private final int statusCode;
    private final String errorCode;

    /**
     * @param statusCode HTTP status code
     * @param message    error message
     */
    public PostaException(int statusCode, String message) {
        this(statusCode, message, null);
    }

    /**
     * @param statusCode HTTP status code
     * @param message    error message
     * @param errorCode  the API's structured error code, e.g. {@code rate_limited}
     */
    public PostaException(int statusCode, String message, String errorCode) {
        super("posta: " + statusCode + " " + message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    /** The HTTP status code from the API response. */
    public int getStatusCode() {
        return statusCode;
    }

    /** The API's structured error code, or null when the response carried none. */
    public String getErrorCode() {
        return errorCode;
    }

    /** True when the API answered 404: no such record. */
    public boolean isNotFound() {
        return statusCode == 404;
    }

    /** True when the API answered 401: missing, malformed, or revoked credential. */
    public boolean isUnauthorized() {
        return statusCode == 401;
    }

    /**
     * True when the API answered 403.
     *
     * <p>For an API key this usually means the key lacks the scope the endpoint
     * requires.</p>
     */
    public boolean isForbidden() {
        return statusCode == 403;
    }

    /** True when the API answered 429: rate limited. */
    public boolean isRateLimited() {
        return statusCode == 429;
    }
}
