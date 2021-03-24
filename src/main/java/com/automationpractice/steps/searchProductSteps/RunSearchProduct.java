package com.automationpractice.steps.searchProductSteps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/scenarios/com.automationpractice/searchProduct",
        plugin = {"pretty", "html:testReports/searchProductTest"})


public class RunSearchProduct {


}
