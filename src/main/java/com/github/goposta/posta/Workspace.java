package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Workspace is a tenant: the boundary that owns templates, domains, keys, and
 * every other resource in this API. Role is the caller's own role in it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Workspace {

    private long id;

    private String name;

    private String slug;

    private String description;

    @JsonProperty("owner_id")
    private long ownerId;

    private String role;

    @JsonProperty("is_personal")
    private boolean isPersonal;

    /**
     * System marks the workspace Posta itself sends from, such as
     * verification and password-reset mail.
     */
    private boolean system;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getName() { return name; }
    public String getSlug() { return slug; }
    public String getDescription() { return description; }
    public long getOwnerId() { return ownerId; }
    public String getRole() { return role; }
    public boolean isIsPersonal() { return isPersonal; }
    public boolean isSystem() { return system; }
    public String getCreatedAt() { return createdAt; }
}
