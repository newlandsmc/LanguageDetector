package com.semivanilla.languagedetector.model;

import java.util.UUID;

public final class PlayerData {

    private final UUID playerUID;

    private int currentStrikes;
    private boolean inMute;

    private String messageForLastAction;

    public PlayerData(UUID playerUID) {
        this.playerUID = playerUID;
    }

    public PlayerData(UUID playerUID, int currentStrikes, boolean inMute) {
        this.playerUID = playerUID;
        this.currentStrikes = currentStrikes;
        this.inMute = inMute;
    }

    public void addStrike(){
        this.currentStrikes +=1;
    }

    public void resetStrike(){
        this.currentStrikes = 0;
    }

    public UUID playerUID() {
        return playerUID;
    }

    public int currentStrikes() {
        return currentStrikes;
    }

    public void setCurrentStrikes(int currentStrikes) {
        this.currentStrikes = currentStrikes;
    }

    public boolean inMute() {
        return inMute;
    }

    public void setInMute(boolean inMute) {
        this.inMute = inMute;
    }

    public String messageForLastAction() {
        return messageForLastAction;
    }

    public void setMessageForLastAction(String messageForLastAction) {
        this.messageForLastAction = messageForLastAction;
    }
}
