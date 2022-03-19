package com.semivanilla.languagedetector.files;

import com.semivanilla.languagedetector.abstracts.AbstractConfiguration;
import com.semivanilla.languagedetector.abstracts.AbstractHandler;
import com.semivanilla.languagedetector.enums.ConfigurationKeys;
import com.semivanilla.languagedetector.handler.FileHandler;
import de.leonhard.storage.Config;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationFile extends AbstractConfiguration {

    private String apiToken;
    private boolean apiSSL;

    private final List<String> regexToIgnore;

    public ConfigurationFile(FileHandler handler) {
        super(handler);
        regexToIgnore = new ArrayList<>();
    }

    @Override
    public boolean initFile() {
        file = new Config("config.yml",
                handler.getPlugin().getDataFolder().getPath(),
                handler.getPlugin().getResource("config.yml")
                );

        return file != null;
    }

    @Override
    public void loadFile() {
        this.apiToken = file.getString(ConfigurationKeys.API_KEY.path);
        this.apiSSL = file.getBoolean(ConfigurationKeys.API_SSL.path);

        this.regexToIgnore.addAll(file.getStringList(ConfigurationKeys.REGEX_TO_IGNORE.path));
    }

    @Override
    public void prepareForReload() {
        this.regexToIgnore.clear();
    }

    public String getApiToken() {
        return apiToken;
    }

    public boolean isApiSSL() {
        return apiSSL;
    }

    public List<String> getRegexToIgnore() {
        return regexToIgnore;
    }
}
