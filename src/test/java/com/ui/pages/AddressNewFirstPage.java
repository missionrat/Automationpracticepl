package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utilities.BrowserUtility;

public class AddressNewFirstPage extends BrowserUtility {

	private static final By COMPANY_TEXTBOX_LOCATOR = By.xpath("//input[@id='company']");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.xpath("//input[@id='address1']");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.xpath("//input[@id='address2']");
	private static final By CITY_TEXTBOX_LOCATOR = By.xpath("//input[@id='city']");
	private static final By ZIP_POST_CODE_TEXT_BOX_LOCATOR = By.xpath("//input[@id='postcode']");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.xpath("//input[@id='phone']");
	private static final By MOBILE_PHONE_TEXTBOX_LOCATOR = By.xpath("//input[@id='phone_mobile']");
	private static final By OTHER_INFORMATION_TEXTAREA_LOCATOR = By.xpath("//textarea[@id='other']");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.xpath("//input[@id='alias']");
	private static final By STATE_DROPDOWN_LOCATOR = By.xpath("//select[@id='id_state']");
	private static final By ADDRESS_SAVE_BUTTON_LOCATOR = By.xpath("//button[@id='submitAddress']");
	private static final By ADDRESS_HEADING = By.tagName("h3");

	public AddressNewFirstPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String saveAddress(AddressPOJO addressPojo) {
		enterText(COMPANY_TEXTBOX_LOCATOR, addressPojo.getCompany());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPojo.getAddressLine1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPojo.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPojo.getCity());
		enterText(ZIP_POST_CODE_TEXT_BOX_LOCATOR, addressPojo.getPostcode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, addressPojo.getHomePhoneNumber());
		enterText(MOBILE_PHONE_TEXTBOX_LOCATOR, addressPojo.getMobileNumber());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, addressPojo.getAddressAlias());
		enterText(OTHER_INFORMATION_TEXTAREA_LOCATOR, addressPojo.getOtherInformation());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, addressPojo.getState());
		ClickOn(ADDRESS_SAVE_BUTTON_LOCATOR);
		String newAddress = getVisibleText(ADDRESS_HEADING);
		return newAddress;

	}

}
