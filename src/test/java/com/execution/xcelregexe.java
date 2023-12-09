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
import com.Common.XcelReading;
import com.Pages.RegisterPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class xcelregexe extends XcelReading{
		
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
		public void RegisterButton() throws Exception
		{
				report = er.createTest("Verify Register functionality");
				registration();
				/*
				 * String actual ="Your registration completed"; String expcted
				 * =RegistrationConfirmation(); Assert.assertEquals(actual, expcted);
				 * System.out.println(expcted);
				 */
			
			
			
			
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
