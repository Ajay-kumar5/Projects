package PageObjectModel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage
{

	
	public static WebDriver driver;
	
	@FindBy(xpath = "//select[@class='product_sort_container']option")
	public static WebElement filter;
	
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	public static WebElement product1;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	public static WebElement product2;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	public static WebElement product3;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	public static WebElement product4;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	public static WebElement product5;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	public static WebElement product6;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public static WebElement cardbutton;


	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
	public void select() throws IOException, InterruptedException
	{
		Select s = new Select(filter);
		
		List<WebElement> allmenu = s.getOptions();
		
		for(WebElement selectmenu : allmenu)
		{
			if(selectmenu.equals("Name (A to Z)"))
			{
				s.selectByValue("az");
				
				TakesScreenshot src = (TakesScreenshot)driver;
				
				File file = src.getScreenshotAs(OutputType.FILE);
				File path = new File("D:\\screenshot\\POM\\a2z.png");
				FileHandler.copy(file, path);
				Thread.sleep(3000);

			}
			else if (selectmenu.equals("Name (Z to A)"))
			{
				s.selectByValue("za");
				
				TakesScreenshot src = (TakesScreenshot)driver;
				
				File file = src.getScreenshotAs(OutputType.FILE);
				File path = new File("D:\\screenshot\\POM\\z2a.png");
				FileHandler.copy(file, path);
				Thread.sleep(3000);

			}
			else if(selectmenu.equals("Price (low to high)"))
			{
				TakesScreenshot src = (TakesScreenshot)driver;
				
				File file = src.getScreenshotAs(OutputType.FILE);
				File path = new File("D:\\screenshot\\POM\\l2h.png");
				FileHandler.copy(file, path);
				Thread.sleep(3000);


			}
			else if(selectmenu.equals("Price (high to low)"))
			{
				s.selectByValue("hilo");
				
				TakesScreenshot src = (TakesScreenshot)driver;
				
				File file = src.getScreenshotAs(OutputType.FILE);
				File path = new File("D:\\screenshot\\POM\\h2l.png");
				FileHandler.copy(file, path);
				Thread.sleep(3000);

				
			}
	
			
		}
		
		
	}
	

}
