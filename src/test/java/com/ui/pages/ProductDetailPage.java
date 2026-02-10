package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utilities.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	private static final By SIZE_DROPDOWN_LOCATOR = By.xpath("//select[@id='group_1']");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailPage changeSize(Size size) {
		selectFromDropdown(SIZE_DROPDOWN_LOCATOR, size.toString());
		ProductDetailPage productDetailpage = new ProductDetailPage(getDriver());
		return productDetailpage;
	}

	public ProductDetailPage addProductToCart() {
		ClickOn(ADD_TO_CART_BUTTON_LOCATOR);
		ProductDetailPage productDetailpage = new ProductDetailPage(getDriver());
		return productDetailpage;
	}

	public ShoppingCartSummaryPage proceedToCheckout() {
		ClickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(getDriver());
		return shoppingCartSummaryPage;
	}

}
