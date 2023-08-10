package com.Pages;

import org.openqa.selenium.By;

import com.Base.Browser;
import com.Common.ExtentReport;
import com.aventstack.extentreports.ExtentTest;

public class nopCommerceLogin extends Browser{

	public By username = By.xpath("//input[@name='Email']");
	
	public By password = By.xpath("//input[@name='Password']");
	
	public By login = By.xpath("//button[text()='Log in']");
	
	
	
	
	public void enterEmail()
	{
		enterText(username,"admin@yourstore.com");
	}
	public void enterPassword()
	{
		enterText(password,"adminadmin");
	}
	
	public boolean userLogin() 
	{
		return clickElement(login);
	}
}
