package com.ticketit.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ticketit.qa.base.TestBase;
import com.ticketit.qa.pages.HomePage;
import com.ticketit.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginTest extends TestBase{

	
	
	 LoginPage loginPage;
	 HomePage homePage;
	 
	 public LoginTest(){
	  super();
	 }
	 
	 @BeforeMethod
	 public void setUp(){
	  initialization();
	  loginPage = new LoginPage();  
	 }
	 
	 @Test(priority=1)
	 public void loginPageTitleTest(){
	  String title = loginPage.validateLoginPageTitle();
	  Assert.assertEquals(title, "Ticketing System"); 
	 }
	 
	 @Test(priority=2)
	 public void TicketImage(){
	  boolean flag = loginPage.validateTicketitimage();
	  Assert.assertTrue(flag);
	 }
	 
	 @Test(priority=3)
	 public void loginTest(){
	  homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	 
	 
	 
	 @AfterMethod
	 public void tearDown(){
	  driver.close();;
	 }
	 

	}





