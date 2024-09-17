package Testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(
		features = {"src\\test\\java\\features\\"},
		dryRun = !true,
		glue = {"Loginsteps","Hooks"},
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		//tags = ("@smoke"),
//		plugin = {"pretty", 
//				"html:report/Cucumber-results.html",
//				"json:report/Cucumber/result.json",
//				"junit:report/Cucumber/result.xml"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class Runner extends AbstractTestNGCucumberTests
{

	
}
