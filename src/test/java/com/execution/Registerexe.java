package com.execution;


import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Common.ExtentReport;
import com.Pages.RegisterPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Registerexe extends RegisterPage{
	
	ExtentReport er = new ExtentReport("NopCommerce_Page");
	private ExtentTest report;
	boolean result;
	SoftAssert sf = new SoftAssert();
	public static Logger log= LogManager.getLogger(Registerexe.class);
	@BeforeClass
	public void Login() throws Exception 
	{
		report = er.createTest("Verify Open Browser");
		driver=lunchUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		result = driver != null;
		er.logResults(result, driver, report, "OpenBrowser", "Browser opened successfully", "Failed to open Browser");	
		
	}
	
	@Test(priority = 1)
	public void registerPageNavigation()
	{
		report = er.createTest("Verify Register Page");
		registerLink();
		String Actual ="Your Personal Details";
		String Expectued = pageHeader();
		Assert.assertEquals(Actual, Expectued);
		
	}
	
	@Test(priority = 2)
	public void SelectGender()
	{
		report = er.createTest("Verify Select Gender Radio Button");
		registerLink();
		String Actual ="Gender:";
		String Expectued = genderHeader();
		log.info(Expectued);
		Assert.assertEquals(Actual, Expectued);
		log.info("Gender Selection");
		selectGender();	
	}
	
	@Test(priority = 3)
	public void EnterFname()
	{
		report = er.createTest("Verify First Name to be Enter Text Box");
		FirstName("Palacharla");	
	}
	
	@Test(priority = 4)
	public void EnterLname()
	{
		report = er.createTest("Verify Lat Name to be Enter Text Box");
		LastName("Damodara");	
	}
	
	@Test(priority = 5)
	public void DateSelection()
	{
		report = er.createTest("Verify Date Selection Dropdown");
		SelectDay("28");	
	}

	@Test(priority = 6)
	public void MonthSelection()
	{
		report = er.createTest("Verify Month Selection Dropdown");
		SelectMonth("November");	
	}
	
	@Test(priority = 7)
	public void YearSelection()
	{
		report = er.createTest("Verify Year Selection Dropdown");
		SelectYear("1993");
	}
	
	@Test(priority = 8)
	public void EmailEnter()
	{
		report = er.createTest("Verify Email enter text box");
		EnterEmail("damodara.palacharla@ramanasoft.com");
	}
	
	@Test(priority = 9)
	public void CompanyName()
	{
		report = er.createTest("Verify Email enter text box");
		EnterCompany("RamanaSoft");
	}
	
	@Test(priority = 10)
	public void EnterPWD()
	{
		report = er.createTest("Verify Password enter text box");
		EnterPd("Ram@123");
	}
	
	@Test(priority = 11)
	public void EnterCnfPWD()
	{
		report = er.createTest("Verify Confirm Password enter text box");
		EnterCnfPd("Ram@123");
	}
	
	@Test(priority = 12)
	public void RegisterButton() throws Exception
	{
		try
		{
			report = er.createTest("Verify Register Button");
			Register();
			String actual ="Your registration completed";
			String expcted =RegistrationConfirmation();
			Assert.assertEquals(actual, expcted);
			System.out.println(expcted);
		}
		
		catch(Exception e)
		{
			er.testfailScreenshot(driver, report, "Reg", "Registration is Failed");
	    	er.testfail(report, "Nopcommerce Registration Failed.");
			
		}
		
	}
	
		@AfterMethod
	 public void getResult(ITestResult result) throws Exception {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            report.log(Status.FAIL,result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	        	report.log(Status.PASS, result.getTestName());
	        }
	        else {
	        	report.log(Status.SKIP, result.getTestName());
	        }
	    }
	
	@AfterTest
	public void endReport()
	{
		er.flush();		
	}

}
