package com.rest.criteriaquery.api.search;

/**
 * @deprecated Use {@link org.apache.commons.lang3.StringUtils#trimToNull(String)} instead
 */
@Deprecated(forRemoval = true)
public class TrimString {

    /**
     * @deprecated Use {@link org.apache.commons.lang3.StringUtils#trimToNull(String)} instead
     */
    @Deprecated(forRemoval = true)
    public static String searchTrim(String data) {
        return data != null ? data.trim() : data;
    }
}

