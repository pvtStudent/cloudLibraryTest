package by.htp.library.tests;

import org.testng.annotations.Test;

import by.htp.library.steps.Steps;
import by.htp.library.utils.PropertiesManager;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WrongLoginTest {

	private Steps steps;
	private String login = PropertiesManager.getProperty("library.wrongLogin");
	private String pass = PropertiesManager.getProperty("library.pass");
	private String pageTitle = PropertiesManager.getProperty("library.login.title");

	@BeforeMethod
	public void beforeMethod() {
		steps = new Steps();
		steps.initDriver();
	}

	@Test
	public void loginWithWrongLogin() {
		steps.authorize(login, pass);
		Assert.assertEquals(pageTitle, steps.getPageTitle(), "User gain access with wrong login!");
	}

	@AfterMethod
	public void afterMethod() {
		steps.closeDriver();
	}
}
