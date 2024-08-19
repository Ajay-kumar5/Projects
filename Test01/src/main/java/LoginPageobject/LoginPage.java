package LoginPageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage
{

	
	//@FindBy(how = How.ID,using="username")
	public static WebElement username;
	
	//@FindBy(id="password")
	public static WebElement password;
	
	//@FindBy(xpath = "//button[@id='submit']")
	public static WebElement submit;

	

//	public LoginPage username(String username)
//	{
//		driver.findElement(By.id("username")).sendKeys(username);;
//		return this;
//	}
//	public  LoginPage password(String password)
//	{
//		driver.findElement(By.id("password")).sendKeys(password);;
//		return this;
//	}
//	public LogoutPage submit() 
//	{
//		driver.findElement(By.xpath("//button[@id='submit']")).click();
//		return new LogoutPage(driver);
//	}
}



