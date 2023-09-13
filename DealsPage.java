package com.CRM.QA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.QA.Base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealslable;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(name="contact_lookup")
	WebElement contact;
	
	@FindBy(id="amount")
	WebElement amt;
	

	@FindBy(xpath="//*[@id=\"prospectForm\"]/table/tbody/tr[1]/td/input[1]\r\n")
	WebElement savebtn;
	
	//*[@id="prospectForm"]/table/tbody/tr[1]/td/input[1]
	
	

	public DealsPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
 	}
	
	
	public boolean verifyDeals() {
		return dealslable.isDisplayed();
	}
	
	public void CreateNewDeal( String Type,String Title,String Company,String Contact,String Amt) {
		Select select=new Select(driver.findElement(By.name("type")));
		title.sendKeys(Title);
		company.sendKeys(Company);
		contact.sendKeys(Contact);
		amt.sendKeys(Amt);
		select.selectByVisibleText(Type);
		savebtn.click();
		
 		
	}
	
	 

}
