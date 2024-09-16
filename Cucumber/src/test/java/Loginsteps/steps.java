package Loginsteps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps 
{
	
	public static WebDriver driver;
	
//	@Given("user should naviagate to the application")
//	public void login()
//	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\128\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.saucedemo.com");
//		
//	}
	
	
//	@Given("User should enter the username as standard_user")
//	public void userShouldEnterTheUsernameAsStandardUser()
//	{
//	   WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
//	   username.sendKeys("standard_user");
//	}
//	
//	@Given("User should enter the password as secret_sauce")
//	public void userShouldEnterThePasswordAsSecretSauce() 
//	{
//		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//		password.sendKeys("secret_sauce");
//	}
	
	@When("User click on login button")
	public void userClickOnLoginButton()
	{

		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}
	
	@Then("login should be success")
	public void loginShouldBeSuccess() 
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.quit();

	}
	
	
	
	
	@Given("User should enter the username as {string}")
	public void userShouldEnterTheUsernameAs(String username) 
	{
		  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		
	}
	
	@Given("User should enter the password as {string}")
	public void userShouldEnterThePasswordAs(String password) 
	{
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		
	}
	    
	@But("login should be fail")
	public void usershouldfail()
	{
		
		String Expected = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		
		System.out.println(Expected);
		
		Assert.assertEquals(Expected,"Epic sadface: Username and password do not match any user in this service");
	}


}
