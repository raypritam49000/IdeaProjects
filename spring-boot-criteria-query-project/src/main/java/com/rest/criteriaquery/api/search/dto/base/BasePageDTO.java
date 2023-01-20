package com.rest.criteriaquery.api.search.dto.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class BasePageDTO<T> {
    private static final Logger logger = LoggerFactory.getLogger(BasePageDTO.class);

    public boolean hasContent;
    public boolean hasNext;
    public boolean hasPrevious;
    public boolean isFirst;
    public boolean isLast;
    public long totalElements;
    public int totalPages;
    public Collection<T> data;
    public int perPage;
    public int pageNumber;
    public int size;
    public String pluralResourceName;

    public boolean isSorted;
    public String sortColumn;
    public String sortOrder;

    public String getDisplayingText() {

        if (!hasContent) {
            logger.info("hasContent is false");
            return "There are no " + pluralResourceName + " to display";
        }

        String total = " of " + this.totalElements + " " + pluralResourceName;

        int startNumber = (size * pageNumber) + 1;
        int endNumber;

        if (isLast) {
            endNumber = startNumber + data.size() - 1;
        } else {
            endNumber = startNumber + size - 1;
        }

        return "Displaying " + startNumber + " through " + endNumber + total;
    }

    public BasePageDTO() {
    }

    public BasePageDTO(boolean hasContent, boolean hasNext, boolean hasPrevious, boolean isFirst, boolean isLast, long totalElements, int totalPages, Collection<T> data, int perPage, int pageNumber, int size, String pluralResourceName, boolean isSorted, String sortColumn, String sortOrder) {
        this.hasContent = hasContent;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
        this.isFirst = isFirst;
        this.isLast = isLast;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.data = data;
        this.perPage = perPage;
        this.pageNumber = pageNumber;
        this.size = size;
        this.pluralResourceName = pluralResourceName;
        this.isSorted = isSorted;
        this.sortColumn = sortColumn;
        this.sortOrder = sortOrder;
    }

    public boolean isHasContent() {
        return hasContent;
    }

    public void setHasContent(boolean hasContent) {
        this.hasContent = hasContent;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPluralResourceName() {
        return pluralResourceName;
    }

    public void setPluralResourceName(String pluralResourceName) {
        this.pluralResourceName = pluralResourceName;
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "BasePageDTO{" +
                "hasContent=" + hasContent +
                ", hasNext=" + hasNext +
                ", hasPrevious=" + hasPrevious +
                ", isFirst=" + isFirst +
                ", isLast=" + isLast +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", data=" + data +
                ", perPage=" + perPage +
                ", pageNumber=" + pageNumber +
                ", size=" + size +
                ", pluralResourceName='" + pluralResourceName + '\'' +
                ", isSorted=" + isSorted +
                ", sortColumn='" + sortColumn + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
