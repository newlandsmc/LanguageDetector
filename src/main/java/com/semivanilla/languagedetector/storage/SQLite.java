package com.semivanilla.languagedetector.storage;

import com.semivanilla.languagedetector.LanguageDetector;
import com.semivanilla.languagedetector.interfaces.IDataStorage;

public class SQLite implements IDataStorage {

    private final LanguageDetector plugin;

    public SQLite(LanguageDetector plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean initConnection() {
        return false;
    }

    @Override
    public void closeConnection() {

    }

    @Override
    public String connectionType() {
        return "SQLite";
    }
}
