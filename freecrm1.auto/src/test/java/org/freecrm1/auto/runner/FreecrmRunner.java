package org.freecrm1.auto.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/freecrm1/auto/featurefiles", 
		glue = "org/freecrm1/auto/stepdefinations", 
		monochrome = true, 
		strict = true, // it will check if any steps is not defined in the step defination file
		dryRun = false, // to check the mapping between feature files and stepdefination
		plugin = "html:target/cucumber-html-report"
)
public class FreecrmRunner {

}
