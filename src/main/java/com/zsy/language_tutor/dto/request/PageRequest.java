package com.zsy.language_tutor.dto.request;

public class PageRequest {

    private static final int DEFAULT_PAGE_NO = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;

    private int pageNo;
    private int pageSize;

    public PageRequest() {
        this.pageNo = DEFAULT_PAGE_NO;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public PageRequest(int pageNo, int pageSize) {
        this.pageNo = pageNo <= 0 ? DEFAULT_PAGE_NO : pageNo;
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo <= 0 ? DEFAULT_PAGE_NO : pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public int getOffset() {
        return (pageNo - 1) * pageSize;
    }

    public int getLimit() {
        return pageSize;
    }
}

