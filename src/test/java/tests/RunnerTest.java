package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty",
				"html:target/cucumber",
				"json:target/cucumber.json",
		"junit:target/cucumber.xml" },
		monochrome = true,
		features = "src/test/resources/" // refer to Feature file
		)


public class RunnerTest {

}
