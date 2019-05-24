package com.tools.qa.run;

import cucumber.api.testng.PickleEventWrapper;
import cucumber.runtime.CucumberException;
import gherkin.pickles.Pickle;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.stream.Collectors;

/**
 * #Summary:
 * #Author: Andrii_Marchenko1
 * #Author’s Email:
 * #Creation Date: 11/9/2018
 * #Comments:
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger Log = Logger.getLogger(RetryAnalyzer.class.getSimpleName());

    private int counter = 0;
    private final int retryLimit = 0;
    private String scenarioSign = "";

//    public RetryAnalyzer() {
//        this.retryLimit = TestRunConfig.getInstance().FAILED_SCENARIO_RETRY_LIMIT();
//    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        rerunInfo(iTestResult);
        if (!isTheSameScenario(iTestResult)) {
            counter = 0;
        }
        if (counter < retryLimit) {
            scenarioSign = getScenarioSign(iTestResult);
            counter++;
            return true;
        } else {
            return false;
        }
    }

    private void rerunInfo(ITestResult iTestResult) {
        Pickle pickle = getCurrentPickleEvent(iTestResult);
        String scenarioName = pickle.getName();
        String partOfMsg;
        if (counter == 0) {
            partOfMsg = "Initial";
        } else {
            partOfMsg = String.format("'%s' of '%s'",
                    counter, retryLimit);
        }
        Log.info(String.format("%s run for scenario '%s' FAILED. Scenario details: '%s'",
                partOfMsg, scenarioName, getScenarioSign(iTestResult)));
    }

    private boolean isTheSameScenario(ITestResult iTestResult) {
        return scenarioSign.equals(getScenarioSign(iTestResult));
    }

    private String getScenarioSign(ITestResult iTestResult) {
        String name = getCurrentPickleEvent(iTestResult).getName();
        return getCurrentPickleEvent(iTestResult).getLocations().stream()
                .map(pickleLocation -> String.format("Name: '%s' [Line: %s, column %s]", name, pickleLocation.getLine(), pickleLocation.getColumn()))
                .collect(Collectors.toList())
                .toString();
    }

    private Pickle getCurrentPickleEvent(ITestResult iTestResult) {
        for (Object o : iTestResult.getParameters()) {
            if (o instanceof PickleEventWrapper) {
                return ((PickleEventWrapper) o).getPickleEvent().pickle;
            }
        }
        throw new CucumberException("No instance of scenario found.");
    }
}
