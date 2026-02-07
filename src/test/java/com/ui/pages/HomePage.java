package com.ui.pages;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utilities.BrowserUtility;
import com.utilities.JSONUtility;
import com.utilities.LoggerUtility;

import static com.utilities.ReadConfig.*;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign')]");

	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		// navigateToApplication(readProperty(QA, "URL"));
		navigateToApplication(JSONUtility.readJSON(QA).getUrl());
		// to call the parent class constructor from the child class constructor we use
		// super keyword
	}

	public LoginPage navigateToLoginpage() {
		logger.info("Trying to perform click actio on sign in page");
		ClickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
}
