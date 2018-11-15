package com.ticketit.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ticketit.qa.base.TestBase;
import com.ticketit.qa.pages.HomePage;
import com.ticketit.qa.pages.LoginPage;
import com.ticketit.qa.pages.QuestionPage;
import com.ticketit.qa.testutil.TestUtil;

public class QuestionPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	QuestionPage questionpage;
	String sheetName="Question";
	
 
	
	
	public QuestionPageTest()
	{
	super();
	}
	
	
	
    @BeforeClass
 	public void setUp()
	{
	
	initialization();
		
	questionpage = new	QuestionPage();
	loginpage=new LoginPage();
	homepage=new HomePage();
		
	homepage=loginpage.login(prop.getProperty("username"),(prop.getProperty("password")));
	homepage.clickOnAdminLink();
	questionpage.clickOnAddQuestion();
		
	}
	
	@Test(priority=1)
	public void verfiyQuestionPageLabelTest()
	{
	
	Assert.assertTrue(questionpage.verfiyQuestionPageLabel(),"Question");

    }
	@Test(priority=2)	public void clickOnAddQuestionButton()
	{
		questionpage.clickOnAddQuestionButton();
	}
	
	@DataProvider
	public Object[][] getTicketItTestData() 
	{
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}
	@Test(priority = 3, dataProvider = "getTicketItTestData")
	public void ValidateAddNewQuestion(String QuestionName, String QuestionArabic) 
	{
    questionpage.addNewQuestion(QuestionName, QuestionArabic);
    }

	@Test(priority = 4)
	public void validateAddedQuestion()
	{
	String  text=	questionpage.verifyAddedQuestion()	;
     Assert.assertEquals(text,"any other problem");
	}
	
	@Test(priority = 5)

	public void validateUpdate()
	{
		questionpage.clickOnUpdateButton();
	}
    
	/*@AfterClass
    public void tearDown() 
    {
    }*/
    }
