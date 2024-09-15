package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Basic 
{
	
	
	
     String url = "https://www.saucedemo.com/";
	
	public static WebDriver driver;
	
	public static Properties pros;
	
	public void Broswerstart(String Broswer) throws IOException
	{
		switch (Broswer) {
		case "chrome": 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\128\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			break;
			
		}
		case "edge":
		{
			System.setProperty("webdriver.msedge.driver", "C:\\Selenium\\Driver\\Edge\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			break;
		}
		default:
		{
			System.out.println("Not matched any browser");
		}
		}
	
	
		File file = new File("./Data.properties");
		FileInputStream data = new FileInputStream(file);
		pros = new Properties();
		pros.load(data);
		
	}

}
