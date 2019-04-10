package com.tools.qa.dataproviders;

import com.tools.qa.enums.DriverType;
import com.tools.qa.enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public WebDriverManager() {
        driverType = FileReaderManager.getConfigFileReader().getBrowserType();
        environmentType = FileReaderManager.getConfigFileReader().getEnvironment();
    }

    public WebDriver getDriver() {
        return (driver == null) ? driver = createDriver() : driver;
    }

    private WebDriver createDriver() {
        switch (environmentType){
            case LOCAL: driver = createLocalDriver();
                break;
            case REMOTE: driver = createRemoteDriver();
                break;
            default: driver = createLocalDriver();
        }
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType){
            case FIREFOX: driver = new FirefoxDriver();
            break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + FileReaderManager.getConfigFileReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case IE: driver = new InternetExplorerDriver();
                break;
            default: driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getConfigFileReader().getImplicityWait(), TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver createRemoteDriver() {
        System.out.println("Remote driver is not implemented yet");
        return null;
    }

    public void closeBrowser(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
