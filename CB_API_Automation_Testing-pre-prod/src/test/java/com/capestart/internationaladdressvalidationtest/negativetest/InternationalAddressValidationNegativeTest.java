package com.capestart.internationaladdressvalidationtest.negativetest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.apilayers.InternationalAddressValidationService;
import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AddressValidationV4NegativeService;
import com.capestart.negativeapilayers.InternationalAddressValidationNegativeService;

import io.restassured.response.Response;

public class InternationalAddressValidationNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}
	@Test
	void getInternationalAddressValidationWithoutQueryParam(){
		Response response = InternationalAddressValidationNegativeService.getInternationalAddressWithoutQueryParam(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("status", "failed")
		.hasKeyWithValue("message", "Please enter a country")
		.assertAll();
	}

	@Test
	void getInternationalAddressValidationWithInvalidCountry(){
		Response response = InternationalAddressValidationNegativeService.getInternationalAddressWithInvalidAddress(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("status", "failed")
		.hasKeyWithValue("message", "Please enter a country that is not USA")
		.assertAll();
	}
	@Test
	void getInternationalAddressWithInvalidHeader(){
		Response response = InternationalAddressValidationNegativeService.getInternationalAddressWithInvalidHeader(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}
	@Test
	void getAddressValidationWithInvalidResources(){
		Response response = InternationalAddressValidationNegativeService.getInternationalAddressWithInvalidResources(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}



}
