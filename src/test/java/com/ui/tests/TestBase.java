package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import com.utilities.LoggerUtility;

public class TestBase {

	protected HomePage homepg;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		logger.info("Load the homepage of the website");
		homepg = new HomePage(CHROME,true);

	}

	public BrowserUtility getInstance() {
		return homepg;
	}

}
