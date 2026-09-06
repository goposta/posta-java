package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * WorkspaceFeatures reports which optional subsystems this deployment has
 * enabled, so a dashboard can hide what is not configured.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceFeatures {

    private boolean inbound;

    private boolean messages;

    private boolean relay;

    public boolean isInbound() { return inbound; }
    public boolean isMessages() { return messages; }
    public boolean isRelay() { return relay; }
}
