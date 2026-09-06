package com.github.goposta.posta;

import java.util.List;

/**
 * Paginated API response envelope. {@code data} holds the page of items and
 * {@code pageable} holds the pagination metadata.
 *
 * @param <T> the element type
 */
public class PageableResponse<T> {

    private boolean success;
    private List<T> data;
    private Pageable pageable;

    public boolean isSuccess() { return success; }
    public List<T> getData() { return data; }
    public Pageable getPageable() { return pageable; }

    @Override
    public String toString() {
        return "PageableResponse{success=" + success +
                ", data=" + data + ", pageable=" + pageable + "}";
    }
}
