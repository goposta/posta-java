package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * UpdateInfo reports whether a newer Posta release is available.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateInfo {

    private boolean enabled;

    @JsonProperty("current_version")
    private String currentVersion;

    @JsonProperty("latest_version")
    private String latestVersion;

    @JsonProperty("update_available")
    private boolean updateAvailable;

    @JsonProperty("release_url")
    private String releaseUrl;

    @JsonProperty("published_at")
    private String publishedAt;

    @JsonProperty("checked_at")
    private String checkedAt;

    @JsonProperty("last_error")
    private String lastError;

    public boolean isEnabled() { return enabled; }
    public String getCurrentVersion() { return currentVersion; }
    public String getLatestVersion() { return latestVersion; }
    public boolean isUpdateAvailable() { return updateAvailable; }
    public String getReleaseUrl() { return releaseUrl; }
    public String getPublishedAt() { return publishedAt; }
    public String getCheckedAt() { return checkedAt; }
    public String getLastError() { return lastError; }
}
