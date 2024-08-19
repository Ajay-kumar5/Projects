package LoginPageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogoutPage
{

	@FindBy(xpath="//a[normalize-space()='Log out']")
	public static WebElement Logout;

//	public LogoutPage Logout()
//	{
////		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
////		return this;
//	}

}
