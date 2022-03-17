package com.semivanilla.languagedetector.handler;

import com.semivanilla.languagedetector.LanguageDetector;
import com.semivanilla.languagedetector.abstracts.AbstractHandler;
import com.semivanilla.languagedetector.files.ConfigurationFile;
import com.semivanilla.languagedetector.files.WhitelistFile;

public class FileHandler extends AbstractHandler {

    private final ConfigurationFile configurationFile;
    private final WhitelistFile whitelistFile;

    public FileHandler(LanguageDetector plugin) {
        super(plugin);
        this.configurationFile = new ConfigurationFile(this);
        this.whitelistFile = new WhitelistFile(this);
    }

    @Override
    public boolean initHandler() {
        return configurationFile.initFile() && whitelistFile.initFile();
    }

    public void loadConfiguration(){
        this.configurationFile.loadFile();
        this.whitelistFile.loadFile();
    }

    public ConfigurationFile getConfigurationFile() {
        return configurationFile;
    }

    public WhitelistFile getWhitelistFile() {
        return whitelistFile;
    }
}
