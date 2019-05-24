package com.tools.qa.run;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.tools.qa.stepdefs"},
        tags = {"~@Ignore"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class RunCucumberTest extends ExtendedAbstractTestNGCucumberTests{

}
