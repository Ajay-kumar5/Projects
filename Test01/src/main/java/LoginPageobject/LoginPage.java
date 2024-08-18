package LoginPageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import SeleiumBase.Basic;

public class LoginPage extends Basic
{

	public LoginPage(RemoteWebDriver driver)
	{
		this.driver = driver;
		
	}

	public LoginPage username(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);;
		return this;
	}
	public  LoginPage password(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);;
		return this;
	}
	public LogoutPage submit() 
	{
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		return new LogoutPage(driver);
	}
}



