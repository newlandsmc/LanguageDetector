package com.semivanilla.languagedetector.interfaces;

public interface IDataStorage {

    boolean initConnection();

    void closeConnection();

    String connectionType();

}
