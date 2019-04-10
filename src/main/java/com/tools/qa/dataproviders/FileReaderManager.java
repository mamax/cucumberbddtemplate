package com.tools.qa.dataproviders;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager;
    private static ConfigFileReader configFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public static ConfigFileReader getConfigFileReader() {
        if (configFileReader == null) {
            configFileReader = new ConfigFileReader();
        }
        return configFileReader;
    }
}
