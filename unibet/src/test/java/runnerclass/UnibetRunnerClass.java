package runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src\\test\\resources\\featurefiles"}
		,glue = {"src\\test\\java\\com\\unibet\\at\\stepdefinations"})
public class UnibetRunnerClass {

}
