package com.rest.criteriaquery.api.search.dto.base;

import java.util.Date;

public class AuditableBaseDTO extends BaseDTO{
    protected Date creationDate;
    protected Date modifiedDate;

    protected String createdBy;
    protected String modifiedBy;

    protected boolean deleted;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "AuditableBaseDTO{" +
                "creationDate=" + creationDate +
                ", modifiedDate=" + modifiedDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
