package com.semivanilla.languagedetector.files;

import com.semivanilla.languagedetector.abstracts.AbstractConfiguration;
import com.semivanilla.languagedetector.handler.FileHandler;
import de.leonhard.storage.Yaml;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WhitelistFile extends AbstractConfiguration {

    private static final String WHITELIST_PATH;

    static {
        WHITELIST_PATH = "whitelist";
    }

    private final List<String> whitelistedUsers;

    public WhitelistFile(FileHandler handler) {
        super(handler);
        this.whitelistedUsers = new ArrayList<String>();
    }

    @Override
    public boolean initFile() {
        file = new Yaml("whitelist.yml",
                handler.getPlugin().getDataFolder().getPath());
        return file != null;
    }

    @Override
    public void loadFile() {
        this.whitelistedUsers.addAll(file.getStringList(WHITELIST_PATH));
    }

    @Override
    public void prepareForReload() {
        whitelistedUsers.clear();
    }

    public boolean isPlayerWhitelisted(@NotNull String name){
        return whitelistedUsers.contains(name);
    }

    public void removePlayerFromWhiteList(@NotNull String name){
        if(whitelistedUsers.contains(name)) {
            whitelistedUsers.remove(name);
            updateWhitelistList();
        }
    }

    public void addPlayerToWhiteList(@NotNull String name){
        if(!whitelistedUsers.contains(name)){
            whitelistedUsers.add(name);
            updateWhitelistList();
        }
    }

    private void updateWhitelistList(){
        file.set(WHITELIST_PATH, whitelistedUsers);
    }
}
