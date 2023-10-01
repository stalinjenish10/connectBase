package com.capestart.standardaddressv2test.negativetest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.StandardAddressV2NegativeService;

import io.restassured.response.Response;

public class GetCoordsNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void getCoordsWithInvalidLat(){
		Response response = StandardAddressV2NegativeService.getCoordsStandardAddressCoordsWithInvalidLat(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("message", "'query.lat' must be a safe number")
		.assertAll();
	}

	@Test
	void getCoordsWithInvalidLon(){
		Response response = StandardAddressV2NegativeService.getCoordsStandardAddressCoordsWithInvalidLon(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("message", "'query.lon' must be a safe number")
		.assertAll();
	}

	@Test
	void getCoordsWithInvalidHeader(){
		Response response = StandardAddressV2NegativeService.getCoordsStandardAddressCoordsWithInvalidHeader(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}

	@Test
	void getAddressValidationWithInvalidResources(){
		Response response = StandardAddressV2NegativeService.getCoordsStandardAddressCoordsWithInvalidResources(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}

}
