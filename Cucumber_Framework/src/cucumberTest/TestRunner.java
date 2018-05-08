package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature/LogIn_DataTable.feature", glue = { "stepDefinition" }, dryRun = false)

public class TestRunner {

}
