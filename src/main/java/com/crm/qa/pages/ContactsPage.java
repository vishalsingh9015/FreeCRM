package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(xpath="//button[contains( text(),'Save')]")
	WebElement save;
	
	@FindBy(xpath="//button[contains( text(), 'Create')]")
	WebElement createNewConts;
	

	

	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
				
	}
	
	public boolean verifyContactsLabel() {
		
		return contactsLabel.isDisplayed();
	}

	public void selectContacts() {
		driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).click();
		
	}
	
	public void createNewContact(String firstname, String lastname) throws InterruptedException {
		
		createNewConts.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		Thread.sleep(5000);
		save.click();
	}
}