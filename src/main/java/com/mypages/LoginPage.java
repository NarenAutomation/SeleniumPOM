package com.mypages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	//Page locators
	private By emailId=By.id("username");
	private By password=By.id("password");
	private By loginButton=By.id("loginBtn");
	private By header=By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//encapsulation
	//getters: accessing private variables using public getters


	public WebElement getEmailId() {
		return getElement(emailId);
	}

	
	public WebElement getPassword() {
		return getElement(password);
	}

	
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		return getPageHeader(header);
	}
	
	public HomePage doLogin(String username,String pwd) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginButton().click();
		
		return getInstance(HomePage.class);
	}
	
	public void doLogin() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginButton().click();
		
	}
	
}
