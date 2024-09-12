package SeleiumBase;

import java.time.Duration;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Basic
{
	String urls = "https://practicetestautomation.com/practice-test-login/";

	public  RemoteWebDriver driver = null;

	@BeforeClass
	public void starup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\128\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(urls);


	}

	@AfterClass
	public void clear()
	{
		driver.quit();
	}

}
