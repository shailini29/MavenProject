package com.ebay.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage lp;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority = 1)
	public void validateLogo() {
		lp.logoPresent();
		Assert.assertTrue(true);
	}
	
	@Test (priority = 2)
	public void validateSignIn() throws IOException {
		lp.signIn(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("HomePageURL"));
	}

}
