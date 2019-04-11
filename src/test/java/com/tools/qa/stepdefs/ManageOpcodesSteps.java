package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import com.tools.qa.pageobjects.ManageOpcodePage;
import com.tools.qa.util.ApiHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ManageOpcodesSteps {

    TestContext testContext;
    ManageOpcodePage manageOpcodePage;
    private List<RuntimeException> exceptions = new ArrayList<>();

    public ManageOpcodesSteps(TestContext testContext) {
        this.testContext = testContext;
        manageOpcodePage = testContext.getPageObjectManager().getManageOpcodePage();
    }

    @When("^user navigates to (.+) tab$")
    public void iNavigateAtTeamAssignmentsTab(String tabName) throws Throwable {
        manageOpcodePage.goToTab(tabName);
    }

    @Then("^(\\[Not\\] )?the button (.+) should be enabled$")
    public void theButtonShouldBeEnabled(String state, String name) {
        boolean scriptState = ApiHelper.ScriptStateReturn(state);
        if (!exceptions.isEmpty()){
            scriptState = false;
        }

        if (scriptState){
            assertTrue(manageOpcodePage.getButton(name).isEnabled());
        }else {
            assertFalse(manageOpcodePage.getButton(name).isEnabled());
        }
    }

    @When("^user check all Checkbox$")
    public void userCheckAllCheckbox() throws Throwable {
        manageOpcodePage.checkAllCheckbox();
        manageOpcodePage.wait_until_true_or_timeout(ExpectedConditions.elementToBeClickable(manageOpcodePage.getCheckAllChkb()));

    }
}
