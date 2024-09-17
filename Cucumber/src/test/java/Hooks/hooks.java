package Hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import Driver.Driverinstance;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class hooks extends Driverinstance
{
	
	@BeforeStep
	public void beforestep(Scenario scenario)
	{
		scenario.getStatus();
	}
	
	@AfterStep
	public void afterstep(Scenario scenario)
	{
		scenario.getId();
	}
	
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\128\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com");
	}
	
	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
	
		boolean failed = scenario.isFailed();
		System.out.println("Is failed: "+failed);
		
		if(scenario.isFailed())
		{
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
			  scenario.attach(fileContent, "image/png", scenario.getName());
		}
		driver.quit();
		
	}

}
