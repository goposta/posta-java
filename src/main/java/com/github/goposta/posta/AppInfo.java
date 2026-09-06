package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AppInfo identifies the running build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInfo {

    private String name;

    private String version;

    @JsonProperty("commit_id")
    private String commitId;

    @JsonProperty("openapi_docs")
    private boolean openapiDocs;

    public String getName() { return name; }
    public String getVersion() { return version; }
    public String getCommitId() { return commitId; }
    public boolean isOpenapiDocs() { return openapiDocs; }
}
