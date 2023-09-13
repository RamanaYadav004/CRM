package com.CRM.QA.pages;
 
	import org.openqa.selenium.WebElement;
 import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.CRM.QA.Base.TestBase;

	public class HomePage extends TestBase{
		
		
		@FindBy(xpath="//td[contains(text(), 'User: RAMANA YADAV ')]")
		WebElement homepageLable;
		
		@FindBy(xpath="//a[contains(text(), 'Contacts')]")
		WebElement contactslink;
		
		@FindBy(xpath="//a[text()='New Contact']")
		WebElement newcontactlink;
		
		@FindBy(xpath="//a[contains(text(), 'Deals')]")
		WebElement DealsLink;
		
		@FindBy(xpath="//a[text()='New Deal']")
		WebElement newDealsLink;
		
		 
		
		@FindBy(xpath="//a[contains(text(), 'Tasks')]")
		WebElement Tasklink;
		
		@FindBy(xpath="//a[contains(text(), 'Forms')]")
		WebElement Formlink;
		
		@FindBy(xpath="//a[contains(text(), 'Reports')]")
		WebElement Reportlink;

		public HomePage() throws Exception {
			//super();
			PageFactory.initElements(driver, this);
	 	}
		
		
		public String VarifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean varifyUserNameLable() {
			return homepageLable.isDisplayed();
		}
		
		public ContactsPage ClickOnContactsLink() throws Exception {
			contactslink.click();
			return new ContactsPage();
		}
		
		public DealsPage ClickOnDealslink() throws Exception {
			DealsLink.click();
			return new DealsPage();
		}
		
		public TaskPage ClickOnTasklink() throws Exception {
			Tasklink.click();
			return new TaskPage();
		}
		public FormPage ClickOnFormslink() throws Exception {
			Formlink.click();
			return new  FormPage();
		}
		public ReportsPage ClickOnReportslink() throws Exception {
			Reportlink.click();
			return new ReportsPage();
		}
		
		public void ClickOnNewContactLink() {
			Actions action=new Actions(driver);
			action.moveToElement(contactslink).build().perform();
			newcontactlink.click();
		}
		
		public void ClickOnNewDealsLink() {
			Actions action=new Actions(driver);
			action.moveToElement(DealsLink).build().perform();
			newDealsLink.click();
		}
		
		
}
