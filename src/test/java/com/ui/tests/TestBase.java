package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import com.utilities.LambdaTestUtility;
import com.utilities.LoggerUtility;

public class TestBase {

	protected HomePage homepg;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	// private boolean isHeadless = true;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homepg = new HomePage(lambdaDriver);
		} else {// run the test on local machine
			logger.info("Load the homepage of the website");
			homepg = new HomePage(Browser.valueOf("chrome".toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homepg;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			homepg.quit();
		}

	}

}
