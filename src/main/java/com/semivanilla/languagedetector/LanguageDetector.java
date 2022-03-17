package com.semivanilla.languagedetector;

import com.semivanilla.languagedetector.enums.ConfigurationKeys;
import com.semivanilla.languagedetector.handler.FileHandler;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.atomic.AtomicBoolean;

public final class LanguageDetector extends JavaPlugin {

    private FileHandler fileHandler;
    private DetectorAPI detectorAPI;

    @Override
    public void onEnable() {
        this.fileHandler = new FileHandler(this);
        this.detectorAPI = new DetectorAPI(this);

        if(!this.fileHandler.initHandler()){
            getLogger().severe("Unable to initialize a plugin file. The plugin will be disabled!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.fileHandler.loadConfiguration();

        if(StringUtils.isBlank(this.fileHandler.getConfigurationFile().getApiToken())){
            getLogger().severe("-----------------------------------------------------------------------------");
            getLogger().severe("The configuration field "+ ConfigurationKeys.API_KEY.path+" seems to be blank! You must provide a valid key for the API");
            getLogger().severe("The plugin will be disabled!");
            getLogger().severe("-----------------------------------------------------------------------------");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        AtomicBoolean currentStatus = new AtomicBoolean(false);
        this.detectorAPI.setupAPI().thenAccept(currentStatus::set);

        if(!currentStatus.get()){
            getLogger().severe("-----------------------------------------------------------------------------");
            getLogger().severe("The API Status Response returned inactive. This means that either the quota exceeded or your plan isn't active.");
            getLogger().severe("Since the plugin is dependent on the API, there isn't a point to run this if the API isn't active! Disabling plugin");
            getLogger().severe("-----------------------------------------------------------------------------");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


    }

    @Override
    public void onDisable() {

    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public DetectorAPI getDetectorAPI() {
        return detectorAPI;
    }
}
