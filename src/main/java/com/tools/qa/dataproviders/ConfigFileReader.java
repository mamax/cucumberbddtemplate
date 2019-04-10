package com.tools.qa.dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String configPath = "configs//config.properties";

    public ConfigFileReader() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(configPath));
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config file was not found");
        }
    }

    public long getImplicityWait() {
        String implWait = properties.getProperty("implicity.wait.timeout.seconds");
        if (implWait!= null){
            return Long.parseLong(implWait);
        } else throw new RuntimeException("implicity wait property was not definned in configs");
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driver.path");
        if (driverPath != null) {
            return driverPath;
        } else throw new RuntimeException("driverpath wasn't defined in configs");
    }

    public String getBasePath() {
        String basePath = properties.getProperty("base.url");
        if (basePath != null) {
            return basePath;
        } else throw new RuntimeException("base path was not defined");
    }
}
