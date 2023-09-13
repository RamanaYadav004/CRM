package com.CRM.QA.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.QA.Base.TestBase;
import com.CRM.QA.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;

	public LoginPageTest() throws Exception {
        super();
 	}
     
	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		loginpage=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void ValidateloginpageTitleTest() {
		String title=loginpage.ValidatepageTitle();
		Assert.assertEquals(title,"Free CRM  - CRM software for customer relationship management, sales, and support.");
		//System.out.println(driver.getTitle());
	}
	
	@Test(priority=2)
	public void CrmlogoTest() {
		boolean flag=loginpage.ValidateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
    
}
