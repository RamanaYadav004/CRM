package com.CRM.QA.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.QA.Base.TestBase;
import com.CRM.QA.Utile.TestUtilClass;
import com.CRM.QA.pages.ContactsPage;
import com.CRM.QA.pages.HomePage;
import com.CRM.QA.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtilClass testutil;
	String sheetName="contacts";
	long Wait;

	public ContactsPageTest() throws Exception {
		super();
 		
  	}
	@BeforeMethod
	public void SetUp() throws Exception {
		initilization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactsPage();
		testutil=new TestUtilClass();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.SwitchTpFrame();
		contactpage=homepage.ClickOnContactsLink();
		
	}
	@Test(priority=1)
	public void verifyContactLableTest() {
		Assert.assertTrue(contactpage.verifyContactsLable());
	}
	@Test(priority=2)
	public void SelectContactTest() {
		contactpage.SelectContact("ram yad");
	}
	
	@DataProvider
	public Object[][] CRMtestData() throws Exception {
		 
		Object data[][]=TestUtilClass.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3, dataProvider="CRMtestData")
	public void ValidatenewContactTest(String title,String Fname, String Lname,String country) {
		//Wait=TestUtilClass.PAGE_LOAD_TIMEOUT;
		homepage.ClickOnNewContactLink();
		//contactpage.CreateNewContactLink("Mr.", "Tom", "Peter", "google");
		contactpage.CreateNewContact(title, Fname, Lname, country);
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
