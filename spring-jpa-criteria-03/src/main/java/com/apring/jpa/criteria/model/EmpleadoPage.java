package com.apring.jpa.criteria.model;

import org.springframework.data.domain.Sort;

public class EmpleadoPage {

    private int pageNumber = 0;
    private int pageSize = 10;
    private Sort.Direction soDirection = Sort.Direction.ASC;
    private String sortBy = "lastName";

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getSoDirection() {
        return soDirection;
    }

    public void setSoDirection(Sort.Direction soDirection) {
        this.soDirection = soDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
