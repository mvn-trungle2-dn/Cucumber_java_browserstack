package com.duykhanhrc.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
        glue= {"com/duykhanhrc/stepsdef"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
		monochrome = true
		)
public class TestRunner {
	
}
