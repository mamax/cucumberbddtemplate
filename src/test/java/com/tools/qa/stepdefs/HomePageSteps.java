package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import com.tools.qa.pageobjects.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^user is on Home Page$")
    public void userIsOnTheHomePage() throws Throwable{
        homePage.navigateTo_HomePage();
    }

    @When("^he search for \"([^\"]*)\"$")
    public void heSearchForDress(String product) throws Throwable {
        homePage.perform_Search(product);
    }
}
