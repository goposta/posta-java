package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DomainVerification is the outcome of one round of DNS checks. The Record
 * fields carry what was actually found, which is what makes a failed check
 * diagnosable.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainVerification {

    @JsonProperty("ownership_verified")
    private boolean ownershipVerified;

    @JsonProperty("spf_verified")
    private boolean spfVerified;

    @JsonProperty("dkim_verified")
    private boolean dkimVerified;

    @JsonProperty("dmarc_verified")
    private boolean dmarcVerified;

    @JsonProperty("spf_record")
    private String spfRecord;

    @JsonProperty("dkim_record")
    private String dkimRecord;

    @JsonProperty("dmarc_record")
    private String dmarcRecord;

    public boolean isOwnershipVerified() { return ownershipVerified; }
    public boolean isSpfVerified() { return spfVerified; }
    public boolean isDkimVerified() { return dkimVerified; }
    public boolean isDmarcVerified() { return dmarcVerified; }
    public String getSpfRecord() { return spfRecord; }
    public String getDkimRecord() { return dkimRecord; }
    public String getDmarcRecord() { return dmarcRecord; }
}
