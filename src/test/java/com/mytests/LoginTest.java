package com.mytests;

import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPageTitleTest() throws Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String title=page.getInstance(LoginPage.class).getLoginPageTitle();
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority=2)
	public void loginPageHeaderTest() throws Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String header=page.getInstance(LoginPage.class).getLoginPageHeader();
		Assert.assertEquals(header, "HubSpot Login");
	}
	
	@Test(priority=3)
	public void doLoginTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		HomePage homepage=page.getInstance(LoginPage.class).doLogin("naren", "asass");
		String headerHome=homepage.getHomePageHeader();
		Assert.assertEquals(headerHome, "Getting started with HubSpot");
	}
}
