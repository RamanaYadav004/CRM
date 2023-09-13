package com.CRM.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.QA.Base.TestBase;

public class LoginPage extends TestBase {
 
 
      //pageFactory
	 @FindBy(xpath="//input[@name='username']")
	 WebElement txtUsername;
	 
	 @FindBy(xpath="//input[@name='password']")
	 WebElement txtPassword;
	 
	 @FindBy(xpath="//input[@value='Login']")
	 WebElement Login;
//	 
	 @FindBy(xpath="//a[text()='Sign Up']")
	 WebElement signup;
//	 
	 @FindBy(xpath="/html/body/div[2]/div/div[1]/a")
	 WebElement logo;


 
public LoginPage() throws Exception {
	 super();
	PageFactory.initElements(driver, this);
	}

//Actoin Methods
   public String ValidatepageTitle() {
	   return driver.getTitle();
   }
   
   public boolean ValidateLogo() {
	   return logo.isDisplayed();
   }
//   
   public HomePage login(String Uname,String Pswd) throws Exception {
	   txtUsername.sendKeys(Uname);
	   txtPassword.sendKeys(Pswd);
	   Login.click();
	   return new HomePage();
   }

}
