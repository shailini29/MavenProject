package com.ebay.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebay.qa.base.TestBase;

public class HomePage extends TestBase {
	public List actuallist;
	
	@FindBy(id="gh-cat")
	WebElement dropDownArrow;

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public List dropDownList() {
		
		Select arrow = new Select(dropDownArrow);
		
		actuallist = new ArrayList();
		List<WebElement> categoriesList = arrow.getOptions();
		
		for(WebElement ele:categoriesList) {
			String data = ele.getText();
			actuallist.add(data);
		}
		
		List sortedList = new ArrayList();
		sortedList.addAll(actuallist);
		
		//Sort the sortedList list in Ascending order
		Collections.sort(sortedList);
		return sortedList;
		
	}
	

}
