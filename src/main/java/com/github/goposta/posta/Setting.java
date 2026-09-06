package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Setting is one platform or workspace configuration entry.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Setting {

    private long id;

    private String key;

    private String value;

    public Setting id(long id) { this.id = id; return this; }
    public long getId() { return id; }
    public Setting key(String key) { this.key = key; return this; }
    public String getKey() { return key; }
    public Setting value(String value) { this.value = value; return this; }
    public String getValue() { return value; }
}
