package com.ticketit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ticketit.qa.base.TestBase;

public class DepartmentPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(), 'Departments')]")
	WebElement DepartmentLabel;

	// clickOnAddDepartment
	@FindBy(xpath = "//button[contains(text(), 'Add Department')]")
	WebElement clickOnAddDepartment;

	// Enter Department Name
	@FindBy(xpath = "//input[@name='DepartmentName']")
	WebElement EnterDepartmentName;

	// EnterSLA
	@FindBy(xpath = "//input[@name='SLA']")
	WebElement EnterSLA;

    //EnterShortCode
	@FindBy(xpath = "//input[@name='ShortCode']")
	WebElement EnterShortCode;

    //Enter Department Description
	@FindBy(xpath = "//textarea[@name='DepartmentDescription']")
	WebElement EnterDepartmentDescription;

    //ClickonSaveButton
	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	WebElement SaveButton;

    //Verify The Added Department
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")
	WebElement AddedDepartment;
  
	
	
	public DepartmentPage()
    {
	PageFactory.initElements(driver, this);
	}
    public boolean verfiyDepartmentPageLabel() 
	{
    return DepartmentLabel.isDisplayed();
	}

	public void clickOnAddDepartmentButton() {

	clickOnAddDepartment.click();
	}

	public void createNewDepartment(String DepartmentName, int SLA, String ShortCode, String DepartmentDescription) {

	EnterDepartmentName.sendKeys(DepartmentName);

	String name = Integer.toString(SLA);
	
	
	
	EnterSLA.sendKeys(name);

	EnterShortCode.sendKeys(ShortCode);

	EnterDepartmentDescription.sendKeys(DepartmentDescription);

	SaveButton.click();

	}
    public String verifyAddedDepartment() throws InterruptedException {
    driver.navigate().refresh();
    return AddedDepartment.getText();
	}

}
