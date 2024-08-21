package FormPage;

import java.sql.Driver;
import java.util.List;

import org.checkerframework.checker.units.qual.degrees;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Seleniumbase.Basic;

public class Form extends Basic
{

	@FindBy(id="first_name")
	public static WebElement firstname;
	
	@FindBy(id="last_name")
	public static WebElement lastname;
	
	@FindBy(id="user_email")
	public static WebElement email;
	
	@FindBy(id="user_url")
	public static WebElement website;
	
	@FindBy(id="user_pass")
	public static WebElement password;
	
	@FindBy(id="user_confirm_password")
	public static WebElement comfirmpassword;
	
	@FindBy(xpath="//input[@value='Choice1']")
	public static WebElement checkbox1;
	
	@FindBy(xpath="//input[@value='Choice2']")
	public static WebElement checkbox2;

	@FindBy(xpath="//input[@value='Choice3']")
	public static WebElement checkbox3;

	
	@FindBy(xpath="//input[@value='Male']")
	public static WebElement ratiobutton1;
	
	@FindBy(xpath="//input[@value='Femalie']")
	public static WebElement ratiobutton2;

	@FindBy(xpath="//select[@id='country_1507714747']")
	public static WebElement countrys;
	
	
	
	
	@FindBy(xpath="//textarea[@id='textarea_1507714757']")
	public static WebElement textaera;
	
	@FindBy(xpath="//input[@id='number_box_1507716030']")
	public static WebElement number;
	
	@FindBy(xpath="//select[@id='select_1507714760']")
	public static WebElement selbox;

	@FindBy(xpath="//input[@id='input_box_1507714764']")
	public static WebElement inputfield;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	public static WebElement submit;
	
	
	public  Form checkbox(String check)
	{
		if(Form.checkbox1.getAttribute("value").contains(check))
		{
			Form.checkbox1.click();
		}
		else if(Form.checkbox2.getAttribute("value").contains(check))
		{
			Form.checkbox2.click();
		}
		else
		{
			Form.checkbox3.click();
		}
		return this;
	}
	
	public  Form ratio(String ratio)
	{
		if(Form.ratiobutton1.getAttribute("Value").contains(ratio))
		{
			Form.ratiobutton1.click();
		}
		else
		{
			Form.ratiobutton2.click();
		}
		return this;

	}
	
	public  Form country(String coun)
	{
			Form.countrys.click();
			
			Select s = new Select(countrys);

			List<WebElement> country = s.getOptions();
			
			for(WebElement single : country)
			{
				String allvalues = single.getText();
				
				if(allvalues.equals(coun))
				{
					single.click();
				}
				
			}

			
			return this;

					
	}
	
	public  Form selects(String options)
	{
		Form.selbox.click();
		
		Select s1 = new Select(selbox);
		
		List<WebElement> op = s1.getOptions();
		
		for(WebElement Single : op)
		{
			String allvalues = Single.getText();

			if(allvalues.equals(options))
			{
				Single.click();
			}
		}
		return this;

}
	
	
	
}
