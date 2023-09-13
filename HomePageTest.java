package com.CRM.QA.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.QA.Base.TestBase;
import com.CRM.QA.Utile.TestUtilClass;
import com.CRM.QA.pages.ContactsPage;
import com.CRM.QA.pages.DealsPage;
import com.CRM.QA.pages.HomePage;
import com.CRM.QA.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtilClass TestUtil;
	ContactsPage contactpage;
	DealsPage dealspage;
	
	
	public HomePageTest() throws Exception {
		super();
	
 	}
	
	 @BeforeMethod
	 public void SetUp() throws Exception {
	     initilization();
	     loginpage=new LoginPage();
	     TestUtil=new TestUtilClass();
	     contactpage=new ContactsPage();
	     dealspage=new DealsPage();
	     homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	 }
	 
	 @Test(priority=1)
	 public void VerifyHomepageTitleTest() {
		String HPtitle= homepage.VarifyHomePageTitle();
		Assert.assertEquals(HPtitle, "CRMPRO","Home Page is not matched");
	 }
	 @Test(priority=2)
	 public void verifyUserPageableText() {
		 TestUtil.SwitchTpFrame();
		 Assert.assertTrue(homepage.varifyUserNameLable());
	 }
	 @Test(priority=3)
	 public void VerifyClickOnContactLink() throws Exception {
		 TestUtil.SwitchTpFrame();
		 contactpage= homepage.ClickOnContactsLink();
	 }
	 @Test(priority=4)
	 public void VerifyClickOnDealsLink() throws Exception {
		 TestUtil.SwitchTpFrame();
		 dealspage= homepage.ClickOnDealslink();
	 }
//	 @Test(priority=5)
//	 public void VerifyClickOnTaskLink() throws Exception {
//		 TestUtil.SwitchTpFrame();
//		 homepage.ClickOnTasklink();
//	 }
//	 @Test(priority=6)
//	 public void VerifyClickOnFormsLink() throws Exception {
//		 TestUtil.SwitchTpFrame();
//		 homepage.ClickOnFormslink();
//	 }
//	 @Test(priority=7)
//	 public void VerifyClickOnReportsLink() throws Exception {
//		 TestUtil.SwitchTpFrame();
//		 homepage.ClickOnReportslink();
//	 }
	 
	 
	 @AfterMethod
	public void TearDown() {
		driver.quit();
	}
	 
	 
}
