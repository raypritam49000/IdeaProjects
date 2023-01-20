package com.rest.criteriaquery.api.enumeration;

public enum Gender {
    MALE("MALE"),FEMALE("FEMALE"),OTHER("OTHER");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
