package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage taskspage;
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		Initialization();
		loginPage= new LoginPage();
		contactsPage=new ContactsPage();
		dealsPage=new DealsPage();
		taskspage=new TasksPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {		
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page Title Not Matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage=homePage.clickOnContactLink();
	}
	
	@Test(priority=4)
	public void verifyDealsLinkTest() {
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTasksLinkTest() {
		taskspage=homePage.clickOnTasksLink();
	}
	
	
	@Test(priority=6)
	public void clickOnNewContactTest() throws InterruptedException {
		homePage.clickOnNewContactLink();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
