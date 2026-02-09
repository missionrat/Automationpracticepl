package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']"); // WebElement

	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']"); // WebElement

	private static final By SUBMIT_LOGIN_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");// WebElement

	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]/ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MyAccountPage loginWithvalidCredentials(String emailAddress, String pwd) {
		clearText(EMAIL_TEXT_BOX_LOCATOR);
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		clearText(PASSWORD_TEXT_BOX_LOCATOR);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, pwd);
		ClickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;

	}

	public LoginPage loginWithInvalidCredentials(String emailAddress, String pwd) {
		clearText(EMAIL_TEXT_BOX_LOCATOR);
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		clearText(PASSWORD_TEXT_BOX_LOCATOR);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, pwd);
		ClickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);

		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public String getErrorMessage() {

		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}

}
