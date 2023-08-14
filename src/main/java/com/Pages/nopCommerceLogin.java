package com.Pages;

import org.openqa.selenium.By;

import com.Base.Browser;
import com.Common.ExtentReport;
import com.aventstack.extentreports.ExtentTest;

public class nopCommerceLogin extends Browser{

	public By username = By.xpath("//input[@name='Email']");
	
	public By password = By.xpath("//input[@name='Password']");
	
	public By login = By.xpath("//button[text()='Login']");
	
	
	
	
	public boolean enterEmail()
	{
		return enterText(username,"admin@yourstore.com");
	}
	public boolean enterPassword()
	{
		return enterText(password,"adminadmin");
	}
	
	public boolean userLogin() 
	{
		return clickElement(login);
	}
}
