package com.ticketit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ticketit.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "/html/body/app-dashboard/div/main/ol/li/b")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "/html/body/app-dashboard/div/div/nav/ul/li[5]/a")
	WebElement AdminLink;


	 
	 
	 @FindBy(linkText ="Departments")
		
	 WebElement DepartmentsLink;

	 
	 

	 @FindBy(linkText ="Question ")
	
	 WebElement clickOnQuestionLink;
	 
	 
	public HomePage()

	{

	PageFactory.initElements(driver, this);
	
	}

	

	public String verifyHomePageTitle() 
	
	{
	
    return driver.getTitle();
	
	}
	
	
	public boolean verifyCorrectUserName()
	{
	
	return userNameLabel.isDisplayed();
		
	}
	

	
	public void clickOnAdminLink()

	{
	
	AdminLink.click();
	
	}

	
	public DepartmentPage clickonDepartmentLink() 
	
	{
 
    
	DepartmentsLink.click();

	return new DepartmentPage();
	
	
	
	}

	
	
	public QuestionPage clickOnQuestion()
	{
	
		clickOnQuestionLink.click();
		
		return new QuestionPage();
	}








	
    }
