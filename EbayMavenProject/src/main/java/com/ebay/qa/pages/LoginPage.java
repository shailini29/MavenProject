package com.ebay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="userid")
	WebElement loginEmail;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="sgnBt")
	WebElement signIn;
	
	@FindBy(id="gh-logo")
	WebElement ebaylogo;
		
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoPresent() {
		return ebaylogo.isDisplayed();
	}
	
	public HomePage signIn(String s1, String s2) throws IOException {
		loginEmail.sendKeys(s1);
		password.sendKeys(s2);
		signIn.click();
		return new HomePage(); 
	}
	
	
			
}
