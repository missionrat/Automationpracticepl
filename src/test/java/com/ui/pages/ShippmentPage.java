package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public class ShippmentPage extends BrowserUtility {

	private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR = By.xpath("//div[@id='uniform-cgv']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR_SHIPPING = By.xpath("//button[@name='processCarrier']");

	public ShippmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public PaymentPage goToPaymentPage() {
		ClickOn(ACCEPT_TERMS_CHECKBOX_LOCATOR);
		ClickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR_SHIPPING);

		PaymentPage paymentPage = new PaymentPage(getDriver());
		return paymentPage;
	}

}
