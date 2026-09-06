package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pagination metadata returned alongside a {@link PageableResponse}.
 */
public class Pageable {

    @JsonProperty("current_page")
    private int currentPage;

    private int size;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_elements")
    private long totalElements;

    private boolean empty;

    public int getCurrentPage() { return currentPage; }
    public int getSize() { return size; }
    public int getTotalPages() { return totalPages; }
    public long getTotalElements() { return totalElements; }
    public boolean isEmpty() { return empty; }

    @Override
    public String toString() {
        return "Pageable{currentPage=" + currentPage + ", size=" + size +
                ", totalPages=" + totalPages + ", totalElements=" + totalElements +
                ", empty=" + empty + "}";
    }
}
