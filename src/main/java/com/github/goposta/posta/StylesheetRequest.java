package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * StylesheetRequest creates or replaces a stylesheet.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StylesheetRequest {

    private String name;

    private String css;

    public StylesheetRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public StylesheetRequest css(String css) { this.css = css; return this; }
    public String getCss() { return css; }
}
