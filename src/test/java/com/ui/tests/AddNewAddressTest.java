package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.ui.pages.AddressNewFirstPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utilities.FakeAddressUtility;

public class AddNewAddressTest extends TestBase {
	private MyAccountPage myAccountPage;
	private AddressNewFirstPage addressPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid First time user logs into the application")
	public void setUp() {
		myAccountPage = homepg.navigateToLoginpage().loginWithvalidCredentials("neyef43651@azeriom.com", "naman@2026");
		address = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addnewAddress() {
		String newAddress = myAccountPage.navigateToAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());

	}
}
