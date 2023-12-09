package com.Pages;

import org.openqa.selenium.By;

import com.Base.Browser;


public class RegisterPage extends Browser{

	public By RegisterLk =By.linkText("Register");
	
	public By PageHeader = By.xpath("//strong[text()='Your Personal Details']");
	
	public By  Gendertext = By.xpath("//label[text()='Gender:']");
	
	public By MaleGender = By.xpath("//input[@value='M']");
	public By FemaleGender = By.xpath("//input[@value='F']"); 
	
	public By FName = By.xpath("//input[@name='FirstName']"); 
	public By LName = By.xpath("//input[@name='LastName']"); 
	
	public By DaySelect = By.name("DateOfBirthDay");
	public By MonthSelect = By.name("DateOfBirthMonth");
	public By YearSelect = By.name("DateOfBirthYear");
	
	public By Email = By.xpath("//input[@name='Email']");
	
	public By Company = By.xpath("//input[@name='Company']");
	
	public By PWD = By.xpath("//input[@name='Password']");
	public By CnfPWD = By.xpath("//input[@name='ConfirmPassword']");
	
	public By RegButton = By.xpath("//button[@name='register-button']");
	
	public By Regconfirmation =By.xpath("//div[text()='Your registration completed']");
	
	public void registerLink()
	{
		clickElement(RegisterLk);
	}
	
	public String pageHeader()
	{
		return getText(PageHeader);
	}
	
	public String genderHeader()
	{
		return getText(Gendertext);
	}
	
	public void selectGender()
	{
		clickElement(FemaleGender);
		delay(3);
		clickElement(MaleGender);
	}
	
	public void FirstName(String fname)
	{
		enterText(FName, fname);
	}
	
	public void LastName(String lname)
	{
		enterText(LName, lname);
	}
	
	public void SelectDay(String day)
	{
		dropDownSelectText(DaySelect, day);
	}
	
	public void SelectMonth(String month)
	{
		dropDownSelectText(MonthSelect, month);
	}
	public void SelectYear(String year)
	{
		dropDownSelectText(YearSelect, year);
	}
	
	public void EnterEmail(String email)
	{
		enterText(Email, email);
	}
	
	public void EnterCompany(String name)
	{
		enterText(Company, name);
	}
	
	public void EnterPd(String pd)
	{
		enterText(PWD, pd);
	}
	
	public void EnterCnfPd(String cpd)
	{
		enterText(CnfPWD, cpd);
	}
	
	public void Register()
	{
		clickElement(RegButton);
	}
	
	public String RegistrationConfirmation()
	{
		return getText(Regconfirmation);
	}
	
	
	public void personalDetails(String fname, String lname, String day, String month, String year, String email, String name, String pd, String cpd) throws Exception
	{
		enterText(FName, fname);
		enterText(LName, lname);
		dropDownSelectText(DaySelect, day);
		dropDownSelectText(MonthSelect, month);
		dropDownSelectText(YearSelect, year);
		enterText(Email, email);
		enterText(Company, name);
		enterText(PWD, pd);
		enterText(CnfPWD, cpd);
		
	}
}
