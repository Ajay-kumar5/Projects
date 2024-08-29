package FormTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExtentReport.Report;
import FormPage.Form;
import utils.Basic;

public class Testform extends Report
{
	
	public static WebDriver driver;
	
	Basic setup = new Basic();
	
	@DataProvider(name="data")
	@BeforeTest
	public String[][] start() throws IOException, ClassNotFoundException
	{		 
		
		this.driver = setup.driver;
		
		 String [][] excelread = Basic.Read();
			return excelread;
	}
	


//	@BeforeTest
//	@Parameters("Browser")
//	public void brows(String Browser)
//	{
//		switch (Browser) {
//		case "chrome": 
//		{
//			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\128\\chromedriver.exe");
//			driver = new ChromeDriver();
//			break;
//			
//		}
//		case "edge":
//		{
//			System.setProperty("webdriver.msedge.driver", "C:\\Selenium\\Driver\\Edge\\msedgedriver.exe");
//			driver = new EdgeDriver();
//			break;
//		}
//		default:
//		{
//			System.out.println("Not matched any browser");
//		}
//		}
//	}
	
	
	@Test(groups = "regression",dataProvider = "data")
	public void form(String[] data) throws InterruptedException
	{
		PageFactory.initElements(driver,Form.class);
		
		Form.firstname.sendKeys(data[0]);
 		Form.lastname.sendKeys(data[1]);
		Form.email.sendKeys(data[2]);
		Form.website.sendKeys(data[3]);
		Form.password.sendKeys(data[4]);
		Form.comfirmpassword.sendKeys(data[5]);
		
		JavascriptExecutor jjs = (JavascriptExecutor) driver;
		jjs.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		new Form().checkbox(data[6]);
		new Form().ratio(data[7]);

		new Form().country(data[8]);
		
		Form.textaera.sendKeys(data[9]);
		Form.number.sendKeys(data[10]);

		new Form().selects(data[11]);
		Form.inputfield.sendKeys(data[12]);
		


		
	}
	
	@Test(groups = "smoke",dataProvider = "data")
	public void main(String[] data)
	{
		PageFactory.initElements(driver,Form.class);

		Form.email.sendKeys(data[2]);
		Form.password.sendKeys(data[4]);
		Form.comfirmpassword.sendKeys(data[5]);
		
		JavascriptExecutor jjs = (JavascriptExecutor) driver;
		jjs.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	@Test(groups = {"smoke","regression"})
	public void submit()
	{
		Form.submit.click();
	}
	
	
	@Test(groups = {"smoke","regression"})
	public void successdisplay() throws IOException, InterruptedException
	{
		Thread.sleep(5000);

		WebElement success = driver.findElement(By.xpath("//*[contains(text(),'User successfully registered.')]"));
		
		String Expectedvalue = success.getText();
		String Actualvalue = "User successfully registered.";
		
		Assert.assertEquals(Expectedvalue,Actualvalue);

	}
	
	@AfterTest
	public void clear()
	{
		driver.quit();
	}

}
