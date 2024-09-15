package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardPage 
{
	public static WebDriver driver;

	

	
	
	@FindBy(xpath = "//button[@id='continue-shopping']")
	public static WebElement continueshopping;
	
	
	@FindBy(xpath = "//button[@id='checkout']")
	public static WebElement checkout;
	
	
	
	
	public CardPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
	
	
}
