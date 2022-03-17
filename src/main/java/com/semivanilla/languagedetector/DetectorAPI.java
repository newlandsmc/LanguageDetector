package com.semivanilla.languagedetector;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;
import com.detectlanguage.responses.StatusResponse;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class DetectorAPI {

    private final LanguageDetector plugin;

    public DetectorAPI(LanguageDetector plugin) {
        this.plugin = plugin;
    }

    public CompletableFuture<Boolean> setupAPI(){
        DetectLanguage.apiKey = plugin.getFileHandler().getConfigurationFile().getApiToken();
        DetectLanguage.ssl = plugin.getFileHandler().getConfigurationFile().isApiSSL();

        return CompletableFuture.supplyAsync(new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                try {
                    String status = DetectLanguage.getStatus().getStatus();
                    if(status.equals("ACTIVE"))
                        return true;
                    else return false;
                } catch (APIError e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });
    }

    public CompletableFuture<Optional<StatusResponse>> getAPIStatus(){
        return CompletableFuture.supplyAsync(new Supplier<Optional<StatusResponse>>() {
            @Override
            public Optional<StatusResponse> get() {
                try {
                    return Optional.ofNullable(DetectLanguage.getStatus());
                } catch (APIError ignored) {
                    return Optional.empty();
                }
            }
        });
    }


}
