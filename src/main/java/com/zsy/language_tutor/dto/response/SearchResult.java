package com.zsy.language_tutor.dto.response;

import java.util.List;

public class SearchResult<T> extends APIResponse<List<T>> {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
