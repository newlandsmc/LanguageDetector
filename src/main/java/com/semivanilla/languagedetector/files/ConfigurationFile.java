package com.semivanilla.languagedetector.files;

import com.semivanilla.languagedetector.abstracts.AbstractConfiguration;
import com.semivanilla.languagedetector.abstracts.AbstractHandler;
import de.leonhard.storage.Config;

public class ConfigurationFile extends AbstractConfiguration {

    public ConfigurationFile(AbstractHandler handler) {
        super(handler);
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

    }

    @Override
    public void prepareForReload() {

    }
}
