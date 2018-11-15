package com.ticketit.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ticketit.qa.base.TestBase;
import com.ticketit.qa.pages.DepartmentPage;
import com.ticketit.qa.pages.HomePage;
import com.ticketit.qa.pages.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase 

   {

    LoginPage loginpage;
	
    HomePage homepage;
	
    DepartmentPage departmentpage;

	
    public HomePageTest() 
    {

    super();
	
    }

	
    @BeforeClass
	public void setUp() 
    {

	initialization();

	loginpage = new LoginPage();
		
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	departmentpage= new DepartmentPage();
	
    }
	
   @Test(priority=1)
	public void verifyHomePageTitleTest()
   
    {

    String homePageTitle = homepage.verifyHomePageTitle();

	Assert.assertEquals("Ticketing System", homePageTitle);

	}

	@Test(priority=2)
	public void verifyUserNameTest()
	
	{
	
	Assert.assertTrue(homepage.verifyCorrectUserName());
		
	}
	
	
	@Test(priority=3)
	public void clickAdminLink() 
	 
	{

	homepage.clickOnAdminLink();
		
	}

	@Test(priority=4)
	
	public void  verifyDepartmentLinkTest() 
	
	{
	
	departmentpage=	homepage.clickonDepartmentLink();
		
	}
	
	
	
	
	
	
	
	

	@AfterClass()
	public void tearDown() {
		
		driver.quit();

	}

}
