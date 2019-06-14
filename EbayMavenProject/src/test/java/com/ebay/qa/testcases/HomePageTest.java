package com.ebay.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginPage lp;
	HomePage hp;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		lp.signIn(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void dropDown() {
	List expected = hp.dropDownList();
	Assert.assertTrue(expected.equals(hp.actuallist));
	}

	
}
