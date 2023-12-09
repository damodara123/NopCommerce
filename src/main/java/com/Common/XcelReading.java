package com.Common;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.Pages.RegisterPage;

public class XcelReading extends RegisterPage{
	
	public void registration() throws Exception
	{
		FileInputStream fs = new FileInputStream(".\\src\\main\\resources\\SpeardSheet\\nopdata.xlsx");//file loading
		XSSFWorkbook wb = new XSSFWorkbook(fs);//work book loading.
		
		XSSFSheet sheet = wb.getSheet("1");//get the sheet
		
		
		int numberofrows = sheet.getLastRowNum();
		String firstname;
		String  day;
		String  month;
		String  year;
		String  email;
		String  cname;
		String  pwd;
		String  cpwd;
		String  lastname;
		//String pass;
		for(int i=0;i<=numberofrows;i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			 firstname= row.getCell(0).toString();
		
			 lastname= row.getCell(1).toString();
			 Thread.sleep(5000);
			 day= row.getCell(2).toString();
			 month= row.getCell(3).toString();
			 year= row.getCell(4).toString();
			 email= row.getCell(5).toString();
			 cname= row.getCell(6).toString();
			 pwd= row.getCell(7).toString();
			 cpwd= row.getCell(8).toString();
			personalDetails(firstname, lastname, day, month, year, email, cname, pwd, cpwd);
			Register();
			System.out.println(cname);
			Thread.sleep(5000);
		
		}
		
	}

}