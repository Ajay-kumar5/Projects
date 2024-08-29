package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic
{
	
	
	static String urls = "https://demo.wpeverest.com/user-registration/form-3/";

	public static WebDriver driver;
		
	static
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\128\\chromedriver.exe");
			driver = new ChromeDriver();
		
			driver.manage().window().maximize();
			
			driver.get(urls);

		}
		
		
	public void screenshot(String screenshotname) throws IOException
		{
			Date d = new Date();
			
			String time = d.toString().replace(":","_").replace(" ","_"); 

			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("D:\\screenshot\\"+screenshotname+"_"+time+".PNG"));
		}
			
		
	public static String[][] Read() throws IOException
		{
		
		FileInputStream file = new FileInputStream("./Data/Test02.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int totalrow = sheet.getLastRowNum();
		int totalcell = sheet.getRow(1).getLastCellNum();
		
		String[][] data = new String[totalrow][totalcell];
		for(int i =1;i<=totalrow;i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			for(int j = 0; j<totalcell;j++)
			{
				XSSFCell cell = row.getCell(j);
				DataFormatter dafo = new DataFormatter();
				String value = dafo.formatCellValue(cell);
				data[i-1][j]=value;
			}
		}
		
		workbook.close();
		file.close();
		
	return data;

	}
}

