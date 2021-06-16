package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage taskspage;
	String sheetName="contacts";
	public ExtentReports extent;
	public ExtentTest logger;
	
	public ContactsPageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() throws Throwable {
		
		Initialization();
		loginPage= new LoginPage();
		contactsPage=new ContactsPage();
		dealsPage=new DealsPage();
		taskspage=new TasksPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		contactsPage=homePage.clickOnContactLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact lable is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		
		contactsPage.selectContacts();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data [][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname) throws InterruptedException {
		
//		contactsPage.createNewContact("Kumar", "Kumar");
		//homePage.clickOnNewContactLink();
		contactsPage.createNewContact(firstname, lastname);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
