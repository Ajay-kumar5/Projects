package LoginPageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import SeleiumBase.Basic;

public class LogoutPage extends LoginPage
{

	public LogoutPage(RemoteWebDriver driver) {
		super(driver);
	}


	public void Logout()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
	}

}
