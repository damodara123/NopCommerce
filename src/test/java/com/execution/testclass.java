package com.execution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Pages.nopCommerceLogin;

public class testclass extends nopCommerceLogin{
	
	@Test
	public void testex()
	{
		driver.findElement(By.linkText("Digital downloads ")).click();
	}

}
