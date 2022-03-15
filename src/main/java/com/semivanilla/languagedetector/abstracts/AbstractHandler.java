package com.semivanilla.languagedetector.abstracts;

import com.semivanilla.languagedetector.LanguageDetector;

public abstract class AbstractHandler {

    protected final LanguageDetector plugin;

    public AbstractHandler(LanguageDetector plugin) {
        this.plugin = plugin;
    }

    public abstract boolean initHandler();

    public LanguageDetector getPlugin() {
        return plugin;
    }
}
