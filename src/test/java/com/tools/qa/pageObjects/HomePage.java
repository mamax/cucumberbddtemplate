package com.tools.qa.pageObjects;

import com.tools.qa.dataproviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    ConfigFileReader configFileReader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    public void perform_Search(String search) {
        driver.navigate().to(configFileReader.getBasePath() + "/?s=" + search + "&post_type=product");
    }

    public void navigateTo_HomePage() {
        driver.get(configFileReader.getBasePath());
    }

}
