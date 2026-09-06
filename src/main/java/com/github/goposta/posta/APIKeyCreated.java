package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * APIKeyCreated is the one-time result of minting a key. Key holds the secret,
 * which is shown only here; Prefix is the fragment that identifies the key
 * afterwards.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIKeyCreated {

    private long id;

    private String name;

    private String key;

    private String prefix;

    private List<String> scopes;

    private String message;

    public long getId() { return id; }
    public String getName() { return name; }
    public String getKey() { return key; }
    public String getPrefix() { return prefix; }
    public List<String> getScopes() { return scopes; }
    public String getMessage() { return message; }
}
