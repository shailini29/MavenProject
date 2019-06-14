package com.ebay.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException { // this is called constructor
		
		// Read Properties File
		FileInputStream fs = new FileInputStream("C:\\testing\\ebay_prop.properties"); 
		// To read from Properties file we need FileInputStream
		prop = new Properties();
		prop.load(fs);
		
	}
		public static void initialization(){
			
		String browser = prop.getProperty("browser"); // To read we use getProperty
		
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Jars\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}else if (browser.equals("chrome")) { // change chrome driver to 74.
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
			driver = new ChromeDriver(); // assume that this is the option for IE.
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		}
		
		
	
}
