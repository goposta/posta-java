package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * CreateLanguageRequest adds a language. Code is a BCP 47 tag such as "en" or
 * "pt-BR".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateLanguageRequest {

    private String code;

    private String name;

    @JsonProperty("is_default")
    private boolean isDefault;

    public CreateLanguageRequest code(String code) { this.code = code; return this; }
    public String getCode() { return code; }
    public CreateLanguageRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public CreateLanguageRequest isDefault(boolean isDefault) { this.isDefault = isDefault; return this; }
    public boolean isIsDefault() { return isDefault; }
}
