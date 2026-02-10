package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;
  
public class ConfirmAddressPage extends BrowserUtility {

	private static final By PROCEED_TO_CHECKOUT_ADDRESS_BUTTON_LOCATOR = By.xpath("//button[@name='processAddress']");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ShippmentPage goToShippmentPage() {
		ClickOn(PROCEED_TO_CHECKOUT_ADDRESS_BUTTON_LOCATOR);
		ShippmentPage shippmentPage = new ShippmentPage(getDriver());

		return shippmentPage;
	}
}
