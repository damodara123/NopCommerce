package com.execution;

import java.time.Duration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.ExtentReport;
import com.Pages.nopCommerceLogin;
import com.aventstack.extentreports.ExtentTest;

public class NopCommerceLogin extends nopCommerceLogin{

	ExtentReport er = new ExtentReport("NopCommerce_Page");
	private ExtentTest report;
	private String statusPassDetails, statusFailDetails, imgName;
	
	@BeforeClass
	public void Login() throws Exception 
	{
		report = er.createTest("Verify Open Browser");
		driver=lunchUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean result = driver != null;
		er.logResults(result, driver, report, "OpenBrowser", "Browser opened successfully", "Failed to open Browser");
		
	}

	
	@Test(priority = 1)
	public void username() 
	{
		report = er.createTest("Verify Login Page fields", "To check whether Login page contains 'User Name' and 'Password' text input fields.");
		enterEmail();		
	}

	@Test(priority = 2)
	public void password() 
	{
		enterPassword();		
	}
	
	@Test(priority = 3)
	public void login() throws Exception 
	{
		boolean result;
		result =userLogin();
		statusPassDetails = "Login page verified successfully";
		statusFailDetails = "Failed to open Login page";
		imgName = "Loginpage1";
		er.logResults(result,driver, report, imgName, statusPassDetails, statusFailDetails);
				
	}

}
