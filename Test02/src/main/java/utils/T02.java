package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class T02 
{
	
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

