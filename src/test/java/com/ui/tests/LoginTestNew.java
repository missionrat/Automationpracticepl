package com.ui.tests;

import static com.constants.Browser.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.annotations.Test.*;

import org.apache.logging.log4j.Logger;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utilities.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTestNew extends TestBase{
	Logger logger = LoggerUtility.getLogger(this.getClass());



	@Test(description = "verifies with valid credentials user is able to login to the Application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homepg.navigateToLoginpage().loginWithvalidCredentials(user.getEmailAddress(), user.getPassword())
				.getUsername(), "Naman datte");
	}

	@Test(description = "verifies with valid credentials user is able to login to the Application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		assertEquals(homepg.navigateToLoginpage().loginWithvalidCredentials(user.getEmailAddress(), user.getPassword())
				.getUsername(), "Naman datte");
	}

	@Test(description = "verifies with valid credentials user is able to login to the Application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {

		assertEquals(homepg.navigateToLoginpage().loginWithvalidCredentials(user.getEmailAddress(), user.getPassword())
				.getUsername(), "Naman datte1");

	}

}
