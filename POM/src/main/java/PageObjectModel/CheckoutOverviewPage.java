package PageObjectModel;

import java.net.http.WebSocket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage 
{
	
	public static WebDriver driver;


	@FindBy(xpath = "//button[@id='finish']")
	public static WebElement finish;
	
	
	@FindBy(xpath = "//button[@id='cancel']")
	public static WebElement cancel;

	
	public CheckoutOverviewPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
}
