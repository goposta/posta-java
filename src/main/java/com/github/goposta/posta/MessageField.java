package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MessageField is one submitted form field, preserved in submission order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageField {

    private String key;

    private String value;

    public String getKey() { return key; }
    public String getValue() { return value; }
}
