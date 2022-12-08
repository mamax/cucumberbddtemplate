package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class MainHooks {

    TestContext testContext;

    public MainHooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {
         /*What all you can perform here
         Starting a webdriver
         Setting up DB connections
         Setting up test data
         Setting up browser cookies
         Navigating to certain page
         or anything before the test
         */
    }

    @BeforeSuite
    public void edwed() {
        System.out.println("---before suite");
    }

    @AfterSuite
    public void dwddw() {
        System.out.println("---after suite---");
    }

    @After
    public void AfterSteps() {
        testContext.getMyWebDriverManager().closeBrowser();
    }
}
