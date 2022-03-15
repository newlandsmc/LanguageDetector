package com.semivanilla.languagedetector.abstracts;

import com.semivanilla.languagedetector.LanguageDetector;
import de.leonhard.storage.internal.FlatFile;

public abstract class AbstractConfiguration {

    protected final AbstractHandler handler;

    protected FlatFile file;

    private boolean reloading;

    public AbstractConfiguration(AbstractHandler handler) {
        this.handler = handler;
    }

    public abstract boolean initFile();

    public abstract void loadFile();

    /**
     * Call this method if you need to clear any list or any maps or so!
     */
    public abstract void prepareForReload();

    public void flush(){
        file.getFileData().clear();
    }

    public long reload(){
        reloading = true;
        final long startTime = System.currentTimeMillis();
        prepareForReload();
        initFile();
        loadFile();
        reloading = false;
        return System.currentTimeMillis() - startTime;
    }

    public boolean isReloading() {
        return reloading;
    }
}
