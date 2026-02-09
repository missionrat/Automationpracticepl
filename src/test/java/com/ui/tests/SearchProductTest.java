package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listeners.TestListener.class })
public class SearchProductTest extends TestBase {
	private MyAccountPage myAccountPage;

	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description = "Valid user logs into the application")
	public void setUp() {
		myAccountPage = homepg.navigateToLoginpage().loginWithvalidCredentials("neyef43651@azeriom.com", "naman@2026");
	}

	@Test(description = "Verify if the logged in user is able to search for a product and correct products search"

			, groups = { "e2e", "sanity", "smoke" })
	public void veerifyProductSearchTest() {

		boolean actualResult = myAccountPage.searchForAproduct(SEARCH_TERM)
				.isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertTrue(actualResult, "true");
	}

}