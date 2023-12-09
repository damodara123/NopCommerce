package com.execution;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import com.Common.ExtentReport;
import com.Pages.RegisterPage;
import com.Pages.nopCommerceLogin;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class NopCommerceLogin extends nopCommerceLogin{

	ExtentReport er = new ExtentReport("NopCommerce_Page");
	private ExtentTest report;
	private String statusPassDetails, statusFailDetails, imgName;
	boolean result;
	SoftAssert sf = new SoftAssert();
	public static Logger log= LogManager.getLogger(NopCommerceLogin.class);
	@BeforeClass
	public void Login() throws Exception 
	{
		report = er.createTest("Verify Open Browser");
		driver=lunchUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		result = driver != null;
		er.logResults(result, driver, report, "OpenBrowser", "Browser opened successfully", "Failed to open Browser");
		
		driver.findElement(By.linkText("Log in")).click();
		
	}

	
	@Test
	public void NopLogin() throws Exception 
	{
		report = er.createTest("Verify Login Functionality..");
	    try
	    {
			enterEmail();	
		    enterPassword();
		    userLogin();
		    sf.assertEquals(driver.findElement(By.linkText("My account")).isDisplayed(),true);
		   //log.info("NopCommerce Login Suceesfull.");
		   er.testPass(report, "NopCommerce Login Suceesfull.");
	    }
	    catch(Exception e)
	    {
	    	er.testfailScreenshot(driver, report, "lgn1", "Login is Failed");
	    	er.testfail(report, "Nopcommerce Login Failed.");
	    	//String msg =driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
	    	//log.error(msg);
	        sf.fail();
	    	//log.error("Nopcommerce Login Failed.");
	    	
	    }
	    sf.assertAll();
		
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
