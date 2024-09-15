package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage
{
	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@id='first-name']")
	public static WebElement firstname;
	
	@FindBy(xpath = "//input[@id='last-name']")
	public static WebElement lastname;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	public static WebElement postalcode;
	
	@FindBy(xpath = "//input[@id='continue']")
	public static WebElement continues;
	
	
	@FindBy(xpath = "//button[@id='cancel']")
	public static WebElement cancel;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}

}
