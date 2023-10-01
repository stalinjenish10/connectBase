package com.capestart.standardaddressv2test.negativetest;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.StandardAddressV2NegativeService;
import com.capestart.pojos.standardaddressv2.PostStandardAddressDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressInvalidBodyDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressInvalidInputBodyDetails;
import com.capestart.testdata.StandardAddressV2TestData;

import io.restassured.response.Response;

public class PostStandardAddressNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void postStandardAddressWithInvalidBody() throws  IOException{
		PostStandardAddressInvalidBodyDetails postStandardAddressInvalidBodyDetails = StandardAddressV2TestData.getPostStandardAddressInvalidBodyDetails(); 
		Response response = StandardAddressV2NegativeService.getPostStandardAddressWithInvalidBody(postStandardAddressInvalidBodyDetails, SESSION_TOKEN);
		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("message", "'body.addresses[0].city' is required")
		.assertAll();
	}

	@Test
	void postStandardAddressWithInvalidInputBody() throws  IOException{
		PostStandardAddressInvalidInputBodyDetails postStandardAddressInvalidInputBodyDetails = StandardAddressV2TestData.getPostStandardAddressInvalidInputBodyDetails(); 

		Response response = StandardAddressV2NegativeService.getPostStandardAddressWithInvalidInputBody(postStandardAddressInvalidInputBodyDetails, SESSION_TOKEN);
		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue("message", "'body.addresses' is required")
		.assertAll();
	}

	@Test
	void postStandardAddressWithInvalidHeader() throws IOException{
		PostStandardAddressDetails postStandardAddressDetails = StandardAddressV2TestData.getPostStandardAddressDetails();
		Response response = StandardAddressV2NegativeService.getPostStandardAddressWithInvalidHeader(postStandardAddressDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}

	@Test
	void postStandardAddressWithInvalidResources() throws  IOException{
		PostStandardAddressDetails postStandardAddressDetails = StandardAddressV2TestData.getPostStandardAddressDetails();
		Response response = StandardAddressV2NegativeService.getPostStandardAddressWithInvalidresources(postStandardAddressDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}

}
