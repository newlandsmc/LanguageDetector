package com.semivanilla.languagedetector;

import com.semivanilla.languagedetector.handler.FileHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class LanguageDetector extends JavaPlugin {

    private FileHandler fileHandler;

    @Override
    public void onEnable() {
        this.fileHandler = new FileHandler(this);

        if(!this.fileHandler.initHandler()){
            getLogger().severe("Unable to initialize a plugin file. The plugin will be disabled!");
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
}
