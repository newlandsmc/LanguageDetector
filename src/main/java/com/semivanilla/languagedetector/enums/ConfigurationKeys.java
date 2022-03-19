package com.semivanilla.languagedetector.enums;

public enum ConfigurationKeys {
    API_KEY("auth.api-key"),
    API_SSL("auth.ssl"),
    REGEX_TO_IGNORE("ignore-regex"),
    ;

    public String path;

    ConfigurationKeys(String path) {
        this.path = path;
    }



}
