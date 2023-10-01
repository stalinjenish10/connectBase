package com.capestart.addressvalidationv4test.positivetest;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.apilayers.AddressValidationV4Service;
import com.capestart.apilayers.ConnectedWorldBuildingV5Service;
import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.extractingvalues.AdvanceCpqUtility;
import com.capestart.extractingvalues.ConnectedWorldBuildingUtility;
import com.capestart.logintest.LoginSetup;

import io.restassured.response.Response;

public class AddressValidationV4Test {
	public static String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void getAddressValidationWithSingleAddress(){
		Response response = AddressValidationV4Service.getAddressValidationWithSingleAddress(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(200)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("status", "success")
		.hasKeyWithValue("inputs.inputAddress", AddressValidationV4Service.ADDRESS_VALIDATION_ADDRESS1)
		.assertAll();


	}
	@Test
	void getAddressValidationWithTwoAddress(){
		Response response = AddressValidationV4Service.getAddressValidationWithTwoAddress(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(200)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("status", "success")
		.hasKeyWithValue("inputs.inputAddress2", AddressValidationV4Service.ADDRESS_VALIDATION_ADDRESS2)
		.assertAll();

	}


}
