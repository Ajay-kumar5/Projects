package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@id='user-name']")
	public static WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	public static WebElement password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	public static WebElement Loginbuttom;

	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
}
