package com.capestart.internationaladdressvalidationtest.positivetest;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.apilayers.AddressValidationV4Service;
import com.capestart.apilayers.InternationalAddressValidationService;
import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.extractingvalues.AdvanceCpqUtility;
import com.capestart.extractingvalues.ConnectedWorldBuildingUtility;
import com.capestart.logintest.LoginSetup;

import io.restassured.response.Response;

public class InternationalAddressValidationTest {
	public static String SESSION_TOKEN ;
	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void getInternationalAddressValidation(){
		Response response = InternationalAddressValidationService.getInternationalAddress(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(200)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("inputAddress", InternationalAddressValidationService.INTERNATIONAL_ADDRESS)
		.hasKeyWithValue("result", "Found")
		.assertAll();

		String keyPath = "inputAddress" ; 
		String Address1 = ConnectedWorldBuildingUtility.extractuniquekey(ResponseBody, keyPath);

	}

}
