package com.semivanilla.languagedetector.handler;

import com.semivanilla.languagedetector.LanguageDetector;
import com.semivanilla.languagedetector.abstracts.AbstractHandler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexHandler extends AbstractHandler {

    private final List<Pattern> patternList;

    public RegexHandler(LanguageDetector plugin) {
        super(plugin);
        this.patternList = new ArrayList<>();
    }

    @Override
    public boolean initHandler() {
        for(String eachStr : this.plugin.getFileHandler().getConfigurationFile().getRegexToIgnore()){
            try {
                patternList.add(Pattern.compile(eachStr));
            }catch (PatternSyntaxException e){
                plugin.getLogger().severe("The following pattern has error in compilation, and won't be registered!");
            }
        }
        return true;
    }

    @Override
    public long reloadHandler() {
        long start = System.currentTimeMillis();
        this.patternList.clear();
        this.initHandler();
        return System.currentTimeMillis() - start;
    }

    public boolean isRegexPassed(@NotNull String message){
        boolean passed = false;
        for(Pattern pattern : patternList){
            if(pattern.matcher(message).matches()){
                passed = true;
                break;
            }
        }
        return passed;
    }


}
