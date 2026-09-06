package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MessageData is the envelope returned by endpoints whose only result is a
 * confirmation string.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageData {

    private String message;

    public String getMessage() { return message; }
}
