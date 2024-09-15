package Test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectModel.CardPage;
import PageObjectModel.CheckoutOverviewPage;
import PageObjectModel.CheckoutPage;
import PageObjectModel.CompletePage;
import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import utilities.Basic;

public class Test1 {
	
	public static WebDriver driver;
	public static Properties pros;
	
	Basic setup = new Basic();
	
	
	@BeforeTest(alwaysRun = true)
	@Parameters("broswer")
	public void Broswersetup(String broswer) throws IOException
	{
		setup.Broswerstart(broswer);

	}
	
	
	@BeforeClass(alwaysRun = true)
	  public void Intputdata() 
	  {
		  this.driver= setup.driver;
		  this.pros = setup.pros;;
	  }
	
	
  @Test(groups = "Smoke",priority = 1)
  public void Login()
  {
	  
	  LoginPage login = new LoginPage(Basic.driver);
	  
	  Reporter.log(driver.getCurrentUrl());
	  
	  login.username.sendKeys(pros.getProperty("Username"));
	  login.password.sendKeys(pros.getProperty("Password"));
	  login.Loginbuttom.click();
	  
	  Reporter.log(driver.getCurrentUrl());
	  String Expected = driver.getCurrentUrl();
	  String Actual = "https://www.saucedemo.com/inventory.html";
	  
	  Assert.assertEquals(Expected,Actual);
  }
  
  @Test(groups = "Smoke",priority = 2)
  public void Home()
  {
	  HomePage home = new HomePage(Basic.driver);
	  
	  Reporter.log(driver.getCurrentUrl());
	  
	  home.product1.click();
	  home.product2.click();
	  home.product3.click();
	  home.product4.click();
	  home.product5.click();
	  home.product6.click();
	  home.cardbutton.click();
	  
	  Reporter.log(driver.getCurrentUrl());
	  
	  
	  String Expected = driver.getCurrentUrl();
	  String Actual = "https://www.saucedemo.com/cart.html";
	  
	  Assert.assertEquals(Expected,Actual);
	  
  }
  
  @Test(groups = "Smoke",priority = 3)
  public void card()
  {
	  CardPage cards = new CardPage(Basic.driver);
	  cards.continueshopping.click();
	  String Expected = driver.getCurrentUrl();
	  String Actual = "https://www.saucedemo.com/inventory.html";
	  Assert.assertEquals(Expected,Actual);
	  
	  
	  HomePage home = new HomePage(Basic.driver);
	  home.cardbutton.click();
	  String Expected1 = driver.getCurrentUrl();
	  String Actual1 = "https://www.saucedemo.com/cart.html";
	  Assert.assertEquals(Expected1,Actual1);
	 
	  cards.checkout.click();
	  String Expected2 = driver.getCurrentUrl();
	  String Actual2 = "https://www.saucedemo.com/checkout-step-one.html";
	  Assert.assertEquals(Expected2,Actual2);
	  
  }
  
  @Test(groups = "Smoke",priority = 4)
  public void userdetails()
  {
	  CheckoutPage user = new CheckoutPage(Basic.driver);
	  Reporter.log(driver.getCurrentUrl());

	  
	  user.firstname.sendKeys(pros.getProperty("Firstname"));
	  user.lastname.sendKeys(pros.getProperty("Lastname"));
	  user.postalcode.sendKeys(pros.getProperty("Postcode"));
	  user.continues.click();
	  
	  Reporter.log(driver.getCurrentUrl());
	  
	  String Expected = driver.getCurrentUrl();
	  String Actual = "https://www.saucedemo.com/checkout-step-two.html";
	  Assert.assertEquals(Expected, Actual);
	  
  }
  
  @Test(groups = "Smoke",priority = 5)
  public void orderplaced()
  {
	  CheckoutOverviewPage order = new CheckoutOverviewPage(Basic.driver);
	  
	  Reporter.log(driver.getCurrentUrl());

	  order.finish.click();
	  
	  Reporter.log(driver.getCurrentUrl());

	  
	  String Expected = driver.getCurrentUrl();
	  String Actual = "https://www.saucedemo.com/checkout-complete.html";
	  Assert.assertEquals(Expected,Actual);
  }
  
  @Test(groups = "Smoke",priority = 6)
  public void Logout() throws InterruptedException
  {
	  CompletePage logout = new CompletePage(Basic.driver);
	  
	  Reporter.log(driver.getCurrentUrl());
	  
	  logout.backtohome.click();
	  String Expected = driver.getCurrentUrl();
	  String Actual = "https://www.saucedemo.com/inventory.html";
	  Assert.assertEquals(Expected,Actual);
	  
	  Thread.sleep(3000);
	  logout.menubar.click();
	  
	  logout.logout.click();
	  
	  String Expected1 = driver.getCurrentUrl();
	  String Actual1 = "https://www.saucedemo.com/";
	  Assert.assertEquals(Expected1,Actual1);
	  
	  
  }
  
  @AfterTest(alwaysRun = true)
  public void closebroswer()
  {
	  driver.quit();
  }
  
}
