package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory OR;
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	@FindBy(xpath="//a[contains(text(),'Classic CRM')]")
	WebElement classicUrl;
	
	//Intializing the page Objects
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean ClassicCRMLink() {
		return classicUrl.isDisplayed();
	}
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
}
