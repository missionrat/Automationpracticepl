package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//span[normalize-space()='Naman datte']");

	private static final By SEARCH_TEXT_BOX_LOCATOR = By.xpath("//input[@id='search_query_top']");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return getVisibleText(USER_NAME_LOCATOR);

	}

	public SearchResultPage searchForAproduct(String productName) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());

		return searchResultPage;

	}
}
