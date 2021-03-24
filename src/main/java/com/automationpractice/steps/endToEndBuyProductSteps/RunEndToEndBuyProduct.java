package com.automationpractice.steps.endToEndBuyProductSteps;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@Tot"},
        features = "src/scenarios/com.automationpractice/endToEndBuyProduct",
        plugin = {"pretty", "html:testReports/endToEndBuyProductTest"})

public class RunEndToEndBuyProduct {
}
