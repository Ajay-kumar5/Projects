package LoginPgaeTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import LoginPageobject.LoginPage;
import LoginPageobject.LogoutPage;
import SeleiumBase.Basic;

public class T01Login extends Basic
{

	@Test
	public void Login() 
	{
		Reporter.log(driver.getTitle()); 

		new LoginPage(driver)
		.username("student")
		.password("Password123")
		.submit();
	}
	
	@Test
	public void Logout() 
	{
	
		LogoutPage lot = new LogoutPage(driver);
		Reporter.log(driver.getTitle()); 
		
		lot.Logout();
	}
	
	@Test
	public void Logoutcomform()
	{
		Reporter.log(driver.getTitle()); 

	}



}
