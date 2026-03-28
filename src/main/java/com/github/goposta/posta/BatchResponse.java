package com.github.goposta.posta;

import java.util.List;

/**
 * Response after a batch email send.
 */
public class BatchResponse {

    private int total;
    private int sent;
    private int failed;
    private int skipped;
    private List<BatchResult> results;

    public int getTotal() { return total; }
    public int getSent() { return sent; }
    public int getFailed() { return failed; }
    public int getSkipped() { return skipped; }
    public List<BatchResult> getResults() { return results; }

    @Override
    public String toString() {
        return "BatchResponse{total=" + total + ", sent=" + sent +
                ", failed=" + failed + ", skipped=" + skipped + "}";
    }
}
