package com.CRM.QA.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.QA.Base.TestBase;
import com.CRM.QA.Utile.TestUtilClass;
import com.CRM.QA.pages.DealsPage;
import com.CRM.QA.pages.HomePage;
import com.CRM.QA.pages.LoginPage;

public class DealsPageTest extends TestBase {
	DealsPage dealspage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtilClass utilclass;
	String sheetName="dealsdata";

	public DealsPageTest() throws Exception {
		super();
		
 	}
	@BeforeMethod
	public void SetUp() throws Exception {
		initilization();
		dealspage=new DealsPage();
		loginpage=new LoginPage();
		homepage=new HomePage();
		utilclass=new TestUtilClass();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		utilclass.SwitchTpFrame();
 	}
	@Test(priority=1)
	public void VerifyDealsTest() throws Exception {
		dealspage=homepage.ClickOnDealslink();
		Assert.assertTrue(dealspage.verifyDeals());
	}
	
	@DataProvider
	public Object[][] getCRMtestData() throws Exception {
		Object data[][]=TestUtilClass.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMtestData")
	public void CreateNewDealTest(String type,String title,String company,String contact,String amount) {
		homepage.ClickOnNewDealsLink();
		dealspage.CreateNewDeal(type, title, company, contact, amount);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
