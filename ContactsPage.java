package com.CRM.QA.pages;

 
 
 import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.QA.Base.TestBase;

public class ContactsPage extends TestBase {
	
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslable;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement  Savebtn;
	
	
//    @FindBy(xpath="//td[@class='datalistrow']//following-sibling::td[@class='datalistrow']"
//    + "//child::a[text()='ram yad']")
//	WebElement selectcontact;
 
	public ContactsPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);

		
 	}
	
	public boolean verifyContactsLable() {
		return contactslable.isDisplayed();
	}
	
	
	public void SelectContact(String name) {
		driver.findElement(By.xpath("//td[@class='datalistrow']//following-sibling::td[@class='datalistrow']"
	    + "//child::a[text()='"+name+"']")).click();
	}
	
    public void CreateNewContact( String name,String Fname,String Lname,String comp) {
    	Select select= new Select(driver.findElement(By.name("title")));
    	select.selectByVisibleText(name);
    	
    	firstname.sendKeys(Fname);
    	lastname.sendKeys(Lname);
    	company.sendKeys(comp);
    	Savebtn.click();
    	
    	
    }
	
 

}
