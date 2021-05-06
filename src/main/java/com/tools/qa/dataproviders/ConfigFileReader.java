package com.tools.qa.dataproviders;

import com.tools.qa.enums.DriverType;
import com.tools.qa.enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String configPath = "src//main//resources//config.properties";
    private DriverType driverType;
    private EnvironmentType environmentType;

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
        } else throw new RuntimeException("Implicity wait property was not defined in configs");
    }

    public String getBasePath() {
        String basePath = properties.getProperty("base.url");
        if (basePath != null) {
            return basePath;
        } else throw new RuntimeException("base path was not defined");
    }

    public DriverType getBrowserType(){
        String browser = properties.getProperty("default.browser");
        if (browser != null){
            switch (browser) {
                case "chrome":
                    driverType = DriverType.CHROME;
                    break;
                case "firefox":
                    driverType = DriverType.FIREFOX;
                    break;
                case "ie":
                    driverType = DriverType.IE;
                    break;
                default: driverType = DriverType.CHROME;
            }
            return driverType;
        } else throw new RuntimeException("browser is not defined in properties");
    }

    public EnvironmentType getEnvironment(){
        String env = properties.getProperty("environment.type");
        if (env != null){
            switch (env){
                case "local":
                    environmentType = EnvironmentType.LOCAL;
                    break;
                case "remote" :
                    environmentType = EnvironmentType.REMOTE;
                    break;
                default : environmentType= EnvironmentType.LOCAL;
            }
            return environmentType;
        } else throw new RuntimeException("env is not defined in properties");
    }
}
