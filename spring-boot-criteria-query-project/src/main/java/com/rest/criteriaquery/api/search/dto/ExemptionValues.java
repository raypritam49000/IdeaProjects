package com.rest.criteriaquery.api.search.dto;

import javax.persistence.Embeddable;

@Embeddable
public class ExemptionValues {
    private Long flatAmount;
    private Double percentAmount;

    public ExemptionValues() {
    }

    public ExemptionValues(Long flatAmount, Double percentAmount) {
        this.flatAmount = flatAmount;
        this.percentAmount = percentAmount;
    }

    public Long getFlatAmount() {
        return flatAmount;
    }

    public void setFlatAmount(Long flatAmount) {
        this.flatAmount = flatAmount;
    }

    public Double getPercentAmount() {
        return percentAmount;
    }

    public void setPercentAmount(Double percentAmount) {
        this.percentAmount = percentAmount;
    }

    @Override
    public String toString() {
        return "ExemptionValues{" +
                "flatAmount=" + flatAmount +
                ", percentAmount=" + percentAmount +
                '}';
    }
}
