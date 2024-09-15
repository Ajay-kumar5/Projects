package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage 
{
	public static WebDriver driver;
	
	@FindBy(xpath = "//button[@id='back-to-products']")
	public static WebElement backtohome;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	public static WebElement menubar;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	public static WebElement logout;
	
	public CompletePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}

}
