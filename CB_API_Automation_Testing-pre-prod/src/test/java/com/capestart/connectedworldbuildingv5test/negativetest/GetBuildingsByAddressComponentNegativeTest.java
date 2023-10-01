package com.capestart.connectedworldbuildingv5test.negativetest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.ConnectedWorldBuildingV5NegativeService;

import io.restassured.response.Response;

public class GetBuildingsByAddressComponentNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void getBuildingByAddressComponentWithoutParameters(){
		Response response = ConnectedWorldBuildingV5NegativeService.getGetBuildingsByAddressComponentWithoutParameters(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Make anyone as mandatory either city or state or street or (latitude,longitude,radius)")
		.assertAll();
	}
	@Test
	void getBuildingByAddressComponentInvalidHeader(){
		Response response = ConnectedWorldBuildingV5NegativeService.getGetBuildingsByAddressComponentInvalidHeader(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}

	@Test
	void getBuildingByAddressComponentInvalidResources(){
		Response response = ConnectedWorldBuildingV5NegativeService.getGetBuildingsByAddressComponentInvalidResources(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}
}
