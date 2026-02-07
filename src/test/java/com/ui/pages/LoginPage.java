package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']"); // WebElement

	static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']"); // WebElement

	static final By SUBMIT_LOGIN_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");

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

}
