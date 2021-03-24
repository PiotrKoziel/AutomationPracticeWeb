package com.automationpractice.steps.userRegistrationSteps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@Neg"},
        features = "src/scenarios/com.automationpractice/userRegistration",
        plugin = {"pretty", "html:testReports/userRegistrationTest"})


public class RunUserRegistration {
}
