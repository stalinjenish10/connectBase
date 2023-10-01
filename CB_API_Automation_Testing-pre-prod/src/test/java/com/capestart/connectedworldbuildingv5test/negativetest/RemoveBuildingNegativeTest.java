package com.capestart.connectedworldbuildingv5test.negativetest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.ConnectedWorldBuildingV5NegativeService;

import io.restassured.response.Response;

public class RemoveBuildingNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void removeBuldingWithInvalidHeader(){
		String uniquekey = ConnectedWorldBuildingV5NegativeService.UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getDeleteBuildingInvalidHeader(SESSION_TOKEN , uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}

	@Test
	void removeBuldingWithInvalidResources(){
		String uniquekey = ConnectedWorldBuildingV5NegativeService.INVALID_UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getDeleteBuildingInvalidEndpoint(SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.assertAll();
	}	

}
