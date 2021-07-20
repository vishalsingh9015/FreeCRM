package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//span[contains(text(),'Test User')]")
	@CacheLookup
	WebElement unserNameLabel;
	
	
	
	@FindBy(xpath="//*[contains(@class,'users icon')]")
	WebElement contactLink;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[5]/a[1]/i[1]")
	WebElement dealsLink;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[6]/a[1]/i[1]")
	WebElement tasksLink;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[3]/button[1]")
	WebElement newContactLink;
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div[5]/button/i")
	WebElement createNewDeals;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		
		System.out.println(driver.getTitle());
		return driver.getTitle();
	
		
	}
	
	public boolean verifyCorrectUsername() {
		return unserNameLabel.isDisplayed();
		
		
	}
	public ContactsPage clickOnContactLink() {
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() throws InterruptedException {
		
		Actions action=new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		Thread.sleep(4000);
		newContactLink.click();
		
		
	}
}
