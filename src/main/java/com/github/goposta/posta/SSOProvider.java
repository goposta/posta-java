package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SSOProvider identifies the single sign-on provider an address should use.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SSOProvider {

    private String name;

    private String slug;

    private String type;

    public String getName() { return name; }
    public String getSlug() { return slug; }
    public String getType() { return type; }
}
