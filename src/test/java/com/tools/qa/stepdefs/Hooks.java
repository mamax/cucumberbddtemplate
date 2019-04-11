package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import com.tools.qa.dataproviders.MyWebDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    TestContext testContext;
    MyWebDriverManager myWebDriverManager;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps(Scenario scenario) {
        System.out.println("Test \"" + scenario.getName()+ "\" started");
//        myWebDriverManager = new MyWebDriverManager();
//        testContext.getMyWebDriverManager().getDriver();
         /*What all you can perform here
         Starting a webdriver
         Setting up DB connections
         Setting up test data
         Setting up browser cookies
         Navigating to certain page
         or anything before the test
         */
    }

    @After
    public void AfterSteps() {
        testContext.getMyWebDriverManager().closeBrowser();
    }

    @After(order = 2)
    public void takeScreenShot(Scenario result) {
        if (result.isFailed()) {
            result.embed(getScreenShotBytes(), "image/png");
        }
    }

    private byte[] getScreenShotBytes() {
        WebDriver driver = testContext.getMyWebDriverManager().getDriver();
        if(driver instanceof TakesScreenshot){
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[]{};
    }
}
