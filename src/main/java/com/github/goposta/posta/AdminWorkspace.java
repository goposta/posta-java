package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AdminWorkspace is a workspace as seen from platform administration, with the
 * plan assigned to it.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminWorkspace {

    private long id;

    private String name;

    private String slug;

    @JsonProperty("owner_id")
    private long ownerId;

    @JsonProperty("plan_id")
    private Long planId;

    @JsonProperty("plan_name")
    private String planName;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public long getId() { return id; }
    public String getName() { return name; }
    public String getSlug() { return slug; }
    public long getOwnerId() { return ownerId; }
    public Long getPlanId() { return planId; }
    public String getPlanName() { return planName; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
}
