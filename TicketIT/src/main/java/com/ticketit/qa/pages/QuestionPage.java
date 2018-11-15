package com.ticketit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ticketit.qa.base.TestBase;

public class QuestionPage extends TestBase {
	
	
    //clickOnQuestion
	
	@FindBy(xpath="//a[contains(text(), ' Question')]")
	WebElement clickOnAddQuestion;
	
	
	//verfiyTheLableofPage 
	@FindBy(xpath="//span[contains(text(), 'Question')]")
	
	WebElement QuestionPageLabel;
	
	
	//clickOnAddQUestion
    @FindBy(xpath="//button[contains(text(), 'Add Question')]")
	
	WebElement clickonAddQuestion;
    
    //enterTheQuestionName
	@FindBy(xpath="//input[@name='Questionname']")
	WebElement enterQuestionName;
	
	
	//enterTheQuestionName
	@FindBy(xpath="//input[@name='QuestionArabic']")
	WebElement enterQuestionArabic;
	
	//clickOnSaveButton
	@FindBy(xpath="//button[contains(text() , 'Save')]")
	WebElement clickOnSaveButton;
	
	//verifyAddedQuestion
	@FindBy(xpath="//table//tbody//tr[1]//td[2]")
	WebElement verifyAddedQuestion;
	
	
	//clickUpdateButton
	@FindBy(xpath="(//button[@class=\"btn-primary btn btn-sm btn-font\"])[1]")
	WebElement clikOnUpdateButton;
		
	//clickOnUpdateButton
	@FindBy(xpath="//button[contains(text() , 'Update')]")
	WebElement clickOnUpdateButton;
	
	
	
	public QuestionPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddQuestion()
	{
	clickOnAddQuestion.click();
	}
	public boolean verfiyQuestionPageLabel()
	{
		
	return  QuestionPageLabel.isDisplayed();
	}
	
	public void clickOnAddQuestionButton()
	{
	clickonAddQuestion.click();	
	}
	
	public void addNewQuestion(String QuestionName,String QuestionArabic)
	
	{
	enterQuestionName.sendKeys(QuestionName);	
	enterQuestionArabic.sendKeys(QuestionArabic);
	clickOnSaveButton.click();
	}
	
	public String verifyAddedQuestion()
	
	{
	driver.navigate().refresh();
	return verifyAddedQuestion.getText();
	}
	
	
	public void clickOnUpdateButton()
	{
		
	clikOnUpdateButton.click();
	enterQuestionName.clear();

	}
	
	}
