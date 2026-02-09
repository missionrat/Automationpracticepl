package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utilities.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })


public class InvalidCredentialsLoginTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final String INVALID_EMAIL_ADDRESS = "spmaverick@gmail.com";
	private static final String INVALID_PASSWORD = "password";

	@Test(description = "Verify if the proper message is displayed when user enter invalid credentails", groups = {
			"e2e", "sanity", "smoke" })
	public void loginTest() {

		assertEquals(homepg.navigateToLoginpage().loginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");
	}

}
