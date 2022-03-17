package com.semivanilla.languagedetector.enums;

public enum ConfigurationKeys {
    API_KEY("auth.api-key"),
    API_SSL("auth.ssl"),
    ;

    public String path;

    ConfigurationKeys(String path) {
        this.path = path;
    }



}
