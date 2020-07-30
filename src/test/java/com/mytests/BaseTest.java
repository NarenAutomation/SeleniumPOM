package com.mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

public class BaseTest {

	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setup(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\narendran.r\\eclipse-workspace\\FreeCRMTest\\drivers\\chromedriver-83\\chromedriver.exe");
			driver=new ChromeDriver();			
		}
		else if(browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\narendran.r\\eclipse-workspace\\FreeCRMTest\\drivers\\IEDriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.get("https://app.hubspot.com/login?_ga=2.150563638.1623960099.1593086237-1294866172.1593086237");
		
		//pass driver to Page class so that it supplies throughout, here Page class object cannot be created as its an abstract class so creating it using the child class
		page = new BasePage(driver);
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
	
	
