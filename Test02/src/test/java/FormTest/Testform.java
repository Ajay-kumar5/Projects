package FormTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import FormPage.Form;
import Seleniumbase.Basic;
import utils.T02;

public class Testform extends Basic
{
	
	@Test(dataProvider = "data")
	public void form(String[] data) throws InterruptedException
	{
		PageFactory.initElements(driver,Form.class);
		
		Form.firstname.sendKeys(data[0]);
		Form.lastname.sendKeys(data[1]);
		Form.email.sendKeys(data[2]);
		Form.website.sendKeys(data[3]);
		Form.password.sendKeys(data[4]);
		Form.comfirmpassword.sendKeys(data[5]);
		
		JavascriptExecutor jjs = (JavascriptExecutor) driver;
		jjs.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		new Form().checkbox(data[6]);
		new Form().ratio(data[7]);

		new Form().country(data[8]);
		
		Form.textaera.sendKeys(data[9]);
		Form.number.sendKeys(data[10]);

		new Form().selects(data[11]);
		Form.inputfield.sendKeys(data[12]);

		
	}
	
	//@Test(groups = "smoke",dataProvider = "data")
	public void main(String[] data)
	{
		Form.email.sendKeys(data[2]);
		Form.password.sendKeys(data[4]);
		Form.comfirmpassword.sendKeys(data[5]);
	}
	
	@Test
	public void submit()
	{
		Form.submit.click();
	}
	
	
	@Test
	public void successdisplay() throws IOException, InterruptedException
	{
		Thread.sleep(5000);

		WebElement success = driver.findElement(By.xpath("//*[contains(text(),'User successfully registered.')]"));
		
		String Expectedvalue = success.getText();
		String Actualvalue = "User successfully registered.";
		
		Assert.assertEquals(Expectedvalue,Actualvalue);
		
		
		//		if(success.getText().contains("successfuuly"))
//		{
//			
//		}
//		else
//		{
//			
//		}
	}

}
