package com.ui.tests;

import java.sql.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs into the application and searches for a product")
	public void setUp() {
		searchResultPage = homepg.navigateToLoginpage()
				.loginWithvalidCredentials("neyef43651@azeriom.com", "naman@2026").searchForAproduct(SEARCH_TERM);

	}

	@Test(description = "Verify if the logged in user is able to buy a dress", groups = { "e2e", "sanity", "smoke" })
	public void checkOutTest() {
		searchResultPage.clickonProductAtIndex(1).changeSize(L).addProductToCart().proceedToCheckout();

	}

}
