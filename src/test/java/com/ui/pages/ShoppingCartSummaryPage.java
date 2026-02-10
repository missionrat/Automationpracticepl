package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public class ShoppingCartSummaryPage extends BrowserUtility {

	private static final By SHOPPING_CART_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By
			.xpath("//p[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");

	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ConfirmAddressPage goToConfirmAddressPage() {
		ClickOn(SHOPPING_CART_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ConfirmAddressPage confirmAddressPage = new ConfirmAddressPage(getDriver());
		return confirmAddressPage;

	}

}
