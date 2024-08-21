package Seleniumbase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import utils.T02;

public class Basic
{

	String urls = "https://demo.wpeverest.com/user-registration/form-3/";

	public  RemoteWebDriver driver = null;
	
	
	@DataProvider(name="data")
	public String[][] dataProvider() throws IOException
	{
		String[][] excelread = T02.Read();
		return excelread;
	}

	@BeforeClass
	public void starup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\126\\chromedriver.exe");
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
