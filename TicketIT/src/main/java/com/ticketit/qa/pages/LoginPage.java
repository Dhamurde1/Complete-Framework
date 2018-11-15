

package com.ticketit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ticketit.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	 //Page Factory - OR:
	 @FindBy(name="EmailAddress")
	 WebElement username;
	 
	 @FindBy(name="UserPassword")
	 WebElement password;
	 
	 @FindBy(xpath= "//button[contains(text(),'Login')]")
	 WebElement loginBtn;
	 
	// to get TicketLogo
	 @FindBy(xpath="//img[@src=\"assets/img/loginpagelogo.png\"]")
	 WebElement ticketlogo;
	 
	 //Initializing the Page Objects:
	 public LoginPage(){
	  PageFactory.initElements(driver, this);
	 }
	 
	 //Actions:
	 public String validateLoginPageTitle(){
	  return driver.getTitle();
	 }
	 
	 public boolean validateTicketitimage(){
	  return ticketlogo.isDisplayed();
	 }
	 
	 public HomePage login(String un, String pwd){
	  username.sendKeys(un);
	  password.sendKeys(pwd);
	  loginBtn.click();
	     
	       
	  return new HomePage();
	 }
	}


