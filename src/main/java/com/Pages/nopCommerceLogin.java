package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.Base.Browser;
import com.Common.ExtentReport;
import com.aventstack.extentreports.ExtentTest;

public class nopCommerceLogin extends Browser{

	public By username = By.xpath("//input[@name='Email']");
	
	public By password = By.xpath("//input[@name='Password']");
	
	public By login = By.xpath("//button[text()='Log in']");
	
	
	
	
	public boolean enterEmail()
	{
		clickElement(username);
		driver.findElement(username).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		return enterText(username,"admin@yourstore.com");
	}
	public boolean enterPassword()
	{
		textClear(password);
		return enterText(password,"admin");
	}
	
	public boolean userLogin() 
	{
		return clickElement(login);
	}
}
