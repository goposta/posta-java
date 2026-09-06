package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateLanguageRequest renames a language or makes it the default.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateLanguageRequest {

    private String code;

    private String name;

    @JsonProperty("is_default")
    private Boolean isDefault;

    public UpdateLanguageRequest code(String code) { this.code = code; return this; }
    public String getCode() { return code; }
    public UpdateLanguageRequest name(String name) { this.name = name; return this; }
    public String getName() { return name; }
    public UpdateLanguageRequest isDefault(Boolean isDefault) { this.isDefault = isDefault; return this; }
    public Boolean getIsDefault() { return isDefault; }
}
