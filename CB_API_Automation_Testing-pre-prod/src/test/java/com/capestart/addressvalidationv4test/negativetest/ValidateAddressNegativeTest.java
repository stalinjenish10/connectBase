package com.capestart.addressvalidationv4test.negativetest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AddressValidationV4NegativeService;

import io.restassured.response.Response;

public class ValidateAddressNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void getAddressValidationWithInvalidData(){
		Response response = AddressValidationV4NegativeService.getAddressValidationWithInvalidData(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("status", "fail")
		.hasKeyWithValue("message", "Address should be separated by comas as 'address, city, state'")
		.assertAll();
	}

	@Test
	void getAddressValidationWithInvalidHeader(){
		Response response = AddressValidationV4NegativeService.getAddressValidationWithInvalidHeader(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}

	@Test
	void getAddressValidationWithInvalidResources(){
		Response response = AddressValidationV4NegativeService.getAddressValidationWithInvalidResources(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}

}
