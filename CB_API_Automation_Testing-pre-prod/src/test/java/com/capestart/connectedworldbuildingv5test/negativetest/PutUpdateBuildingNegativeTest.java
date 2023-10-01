package com.capestart.connectedworldbuildingv5test.negativetest;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.ConnectedWorldBuildingV5NegativeService;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingInvalidInputDetails;
import com.capestart.pojos.connectedworldbuildingv5.PutUpdateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.PutUpdateBuildingInvalidInputDetails;
import com.capestart.testdata.ConnectedWorldBuildingV5TestData;

import io.restassured.response.Response;

public class PutUpdateBuildingNegativeTest {
	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();

	}
	@Test
	public void putUpdateBuildingWithInvalidInputDetails() throws  IOException {

		PutUpdateBuildingInvalidInputDetails putUpdateBuildingInvalidInputDetails = ConnectedWorldBuildingV5TestData.getPutUpdateBuildingInvalidInputDetails();
		String uniquekey = ConnectedWorldBuildingV5NegativeService.UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getPutUpdateBuildingInvalidInput(putUpdateBuildingInvalidInputDetails, SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json")
		.assertAll();
	}
	@Test
	public void putUpdateBuildingWithInvalidHeader() throws  IOException {

		PutUpdateBuildingDetails putUpdateBuildingDetails = ConnectedWorldBuildingV5TestData.getPutUpdateBuildingDetails();
		String uniquekey = ConnectedWorldBuildingV5NegativeService.UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getPutUpdateBuildingInvalidHeader(putUpdateBuildingDetails, SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}
	@Test
	public void putUpdateBuildingWithInvalidResources() throws  IOException {

		PutUpdateBuildingDetails putUpdateBuildingDetails = ConnectedWorldBuildingV5TestData.getPutUpdateBuildingDetails();
		String uniquekey = ConnectedWorldBuildingV5NegativeService.UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getPutUpdateBuildingInvalidResources(putUpdateBuildingDetails, SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}	    





}