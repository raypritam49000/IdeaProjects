package com.rest.criteriaquery.api.search.dto.base;

import org.apache.commons.lang3.StringUtils;


public class PageSearchParameters {

    private String sort = "creationDate";
    private String sortOrder = "asc";
    private int pageNumber = 0;
    private int pageSize = 15;

    public PageSearchParameters() {
    }

    public PageSearchParameters(String sort) {
        this.sort = sort;
    }

    public PageSearchParameters(String sort, String sortOrder) {
        this.sort = sort;
        this.sortOrder = sortOrder;
    }

    public PageSearchParameters(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public PageSearchParameters(String sort, String sortOrder, int pageNumber, int pageSize) {
        this.sort = sort;
        this.sortOrder = sortOrder;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

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

    public void addPageParameters(String sort, String sortOrder, int pageNumber, int pageSize) {
        this.sort = StringUtils.isBlank(sort) ? this.sort : sort;
        this.sortOrder = StringUtils.isBlank(sortOrder) ? this.sortOrder : sortOrder;
        this.pageNumber = Math.max(0, pageNumber);
        this.pageSize = Math.max(1, pageSize);
    }

    @Override
    public String toString() {
        return "PageSearchParameters{" +
                "sort='" + sort + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
