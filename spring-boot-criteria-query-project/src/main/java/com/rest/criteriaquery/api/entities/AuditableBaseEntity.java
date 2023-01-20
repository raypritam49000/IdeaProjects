package com.rest.criteriaquery.api.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AuditableBaseEntity extends BaseEntity {
    @Column(updatable = false)
    @CreationTimestamp
    protected Date creationDate;

    @UpdateTimestamp
    protected Date modifiedDate;

    @Column(updatable = false)
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
        return "AuditableBaseEntity{" +
                "creationDate=" + creationDate +
                ", modifiedDate=" + modifiedDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
