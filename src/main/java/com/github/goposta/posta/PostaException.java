package com.github.goposta.posta;

/**
 * Exception thrown when a Posta API call fails.
 */
public class PostaException extends Exception {

    private final int statusCode;

    /**
     * @param statusCode HTTP status code
     * @param message    error message
     */
    public PostaException(int statusCode, String message) {
        super("posta: " + statusCode + " " + message);
        this.statusCode = statusCode;
    }

    /** Returns the HTTP status code from the API response. */
    public int getStatusCode() {
        return statusCode;
    }
}
