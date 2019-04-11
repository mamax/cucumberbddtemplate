package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import com.tools.qa.enums.Context;
import com.tools.qa.pageobjects.ArchivePage;
import cucumber.api.java.en.When;

public class ArchivePageSteps {

    ArchivePage archivePage;
    TestContext testContext;

    public ArchivePageSteps(TestContext testContext) {
        this.testContext = testContext;
        archivePage = testContext.getPageObjectManager().getArchivePage();
    }

    @When("^user enters host ([^\\\"]*) into search field :$")
    public void iFillHostCodeWithHostCodes(String host) {
        archivePage.setHost(host);
        testContext.getScenarioContext().setContext(Context.HOST, host);
//        log.info(String.format("put \"%s\" into local session", opcode));
    }

    @When("^user selects ([^\\\"]*) on calendar :$")
    public void theUserSelectsDateOnCalendar(String date) {
        archivePage.clickOnCalendarWidget();
        archivePage.waitForElement(archivePage.getCalendarWidget());
        archivePage.selectDate(date);
        testContext.getScenarioContext().setContext(Context.DATE, date);
//        log.info(String.format("put \"%s\" into local session", date));
    }
}
