package com.utilities;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;
import java.util.Locale;

public class FakeAddressUtility {

	private static final String[] INDIAN_STATES = { "Andhra Pradesh", "Delhi", "Gujarat", "Karnataka", "Maharashtra",
			"Tamil Nadu", "Telangana", "Uttar Pradesh" };

	public static AddressPOJO getFakeAddress() {
		Faker faker = new Faker(new Locale("en", "IN"));
		Random random = new Random();

		String state = INDIAN_STATES[random.nextInt(INDIAN_STATES.length)];
		String pinCode = faker.numerify("######"); // Indian PIN
		String phone = "9" + faker.numerify("#########"); // Indian mobile

		AddressPOJO addressPojo = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetName(), faker.address().city(), pinCode, phone, phone, "other", "OFFICE ADDRESS",
				state);

		return addressPojo;
	}
}
