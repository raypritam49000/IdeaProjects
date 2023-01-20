package com.oauth2.rest.api.config;

import java.util.List;
import java.util.Set;

public class ConsumeScopes {

    public void consumeScopes(Set<String> setOfStrings) {
        setOfStrings.addAll(List.of("read","write"));
    }
}