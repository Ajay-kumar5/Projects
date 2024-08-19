package LoginPgaeTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import LoginPageobject.LoginPage;
import LoginPageobject.LogoutPage;
import LoginPageobject.VerfityMenu;
import SeleiumBase.Basic;

public class T01Login extends Basic
{
	
	@Test
	public void Menu()
	{
		PageFactory.initElements(driver, VerfityMenu.class);
		
	    VerfityMenu.Home.click();
	    boolean hometitle = driver.getTitle().equalsIgnoreCase("Practice Test Automation | Learn Selenium WebDriver");
		Assert.assertTrue(hometitle, "click Home button ");
		Reporter.log("Homepage url: " + driver.getTitle());
		
		VerfityMenu.Practice.click();
		String Expectedtitle = "Practice | Practice Test Automation";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(Expectedtitle,actualtitle, "click Practice button ");
		Reporter.log("Practicepage url: " + driver.getTitle());

		
		VerfityMenu.Courses.click();
		Assert.assertTrue(true, "click Courses button ");
		Reporter.log("Coursespage url: " + driver.getTitle());

		
		VerfityMenu.Blog.click();
		Assert.assertTrue(true, "click Blog button ");
		Reporter.log("Blogpage url: " + driver.getTitle());


		VerfityMenu.Contact.click();
		Assert.assertTrue(true, "click Contact button ");
		Reporter.log("Contactpage  url: " + driver.getTitle());


		
	}

	@Parameters({"username","password"})
	@Test(groups = "Smoke")
	public void Login(String username,String Password) 
	{
		Reporter.log(driver.getTitle()); 
		
		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.username.sendKeys(username);
		LoginPage.password.sendKeys(Password);
		LoginPage.submit.click();
		Assert.assertTrue(true, "click submit button ");

	}
	
	@Test(groups = "Smoke")
	public void Logout() 
	{
		Reporter.log(driver.getTitle()); 
		
		PageFactory.initElements(driver, LogoutPage.class);

		LogoutPage.Logout.click();
		Assert.assertTrue(true, "click Logout button ");

	}
	
	@Test
	public void Logoutcomform()
	{
		Reporter.log(driver.getTitle()); 

	}



}
