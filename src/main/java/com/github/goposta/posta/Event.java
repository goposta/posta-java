package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Event is an audit or system event recorded by the platform. Metadata is a
 * JSON document whose shape depends on Type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    private long id;

    private String type;

    private String category;

    private String message;

    @JsonProperty("actor_id")
    private Long actorId;

    @JsonProperty("actor_name")
    private String actorName;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("client_ip")
    private String clientIp;

    private String metadata;

    @JsonProperty("created_at")
    private String createdAt;

    public long getId() { return id; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public String getMessage() { return message; }
    public Long getActorId() { return actorId; }
    public String getActorName() { return actorName; }
    public Long getWorkspaceId() { return workspaceId; }
    public String getClientIp() { return clientIp; }
    public String getMetadata() { return metadata; }
    public String getCreatedAt() { return createdAt; }
}
