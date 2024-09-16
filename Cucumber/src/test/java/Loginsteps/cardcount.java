package Loginsteps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class cardcount
{
	public static WebDriver driver;
	
	
	@Given("user should naviagate to the application")
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\128\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com");
		
	}
	@Given("User Should entre {string} and {string}")
	public void userShouldEntreAnd(String username, String password) 
	{
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

	}
	@Given("Click Add to card button")
	public void clickAddToCardButton() 
	{
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
	}
	  
	@Then("Card count should be updated")
	public void cardCountShouldBeUpdated() 
	{
		String count = driver.findElement(By.cssSelector("span.shopping_cart_badge")).getText();
		
		System.out.println(count);
		driver.quit();
	}

}
