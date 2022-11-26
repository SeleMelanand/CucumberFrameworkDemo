package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = {"src/test/java/features/loginWithWrapper.feature"}, 
					glue = {"stepDefinition"}, 
					monochrome = true,
					tags="@endtoend",
					dryRun = false,
					publish = true,
					plugin = { "pretty",
							"json:target/cucumber/cucumberJsonReport.json",
							"junit:target/cucumber/cucumberXmlReport.xml",
							"html:target/cucumber/cucumberReport.html" })

public class Runner extends AbstractTestNGCucumberTests {

}
