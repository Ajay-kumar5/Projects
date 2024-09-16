package Testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = {"src\\test\\java\\features\\Card.feature"},
		dryRun = !true,
		glue = "Loginsteps",
		snippets = SnippetType.CAMELCASE,
		monochrome = true
		)


public class Runner extends AbstractTestNGCucumberTests
{

	
}
