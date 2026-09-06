package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * WorkspaceMember is a user's membership of a workspace. Role is one of
 * "owner", "admin", "editor", "viewer".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceMember {

    private long id;

    @JsonProperty("user_id")
    private long userId;

    private String email;

    private String name;

    private String role;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public long getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getCreatedAt() { return createdAt; }
}
