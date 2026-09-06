package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * BulkImportResult reports what a bulk import did. Errors names the rows that
 * were rejected and why.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BulkImportResult {

    private int total;

    private int imported;

    private int updated;

    private int skipped;

    private int failed;

    private List<String> errors;

    public int getTotal() { return total; }
    public int getImported() { return imported; }
    public int getUpdated() { return updated; }
    public int getSkipped() { return skipped; }
    public int getFailed() { return failed; }
    public List<String> getErrors() { return errors; }
}
