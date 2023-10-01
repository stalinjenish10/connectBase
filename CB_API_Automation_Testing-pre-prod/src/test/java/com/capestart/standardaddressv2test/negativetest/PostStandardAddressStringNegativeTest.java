package com.capestart.standardaddressv2test.negativetest;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.StandardAddressV2NegativeService;
import com.capestart.pojos.standardaddressv2.PostStandardAddressStringDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressStringInvalidBodyDetails;
import com.capestart.testdata.StandardAddressV2TestData;

import io.restassured.response.Response;

public class PostStandardAddressStringNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void postStandardAddressStringWithInvalidBody() throws  IOException{
		PostStandardAddressStringInvalidBodyDetails postStandardAddressStringInvalidBodyDetails = StandardAddressV2TestData.getPostStandardAddressStringInvalidBodyDetails(); 
		Response response = StandardAddressV2NegativeService.getPostStandardAddressStringWithInvalidBody(postStandardAddressStringInvalidBodyDetails, SESSION_TOKEN);
		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("message", "'body.addresses' is required")
		.assertAll();
	}

	@Test
	void postStandardAddressStringWithInvalidHeader() throws IOException{
		PostStandardAddressStringDetails postStandardAddressStringDetails = StandardAddressV2TestData.getPostStandardAddressStringDetails();
		Response response = StandardAddressV2NegativeService.getPostStandardAddressStringWithInvalidHeader(postStandardAddressStringDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}

	@Test
	void postStandardAddressStringWithInvalidResources() throws  IOException{
		PostStandardAddressStringDetails postStandardAddressStringDetails = StandardAddressV2TestData.getPostStandardAddressStringDetails();
		Response response = StandardAddressV2NegativeService.getPostStandardAddressStringWithInvalidEndpoint(postStandardAddressStringDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}

}
