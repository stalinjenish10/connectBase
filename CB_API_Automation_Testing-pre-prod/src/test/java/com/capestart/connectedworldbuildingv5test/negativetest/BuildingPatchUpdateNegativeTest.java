package com.capestart.connectedworldbuildingv5test.negativetest;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.ConnectedWorldBuildingV5NegativeService;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingInvalidInputDetails;
import com.capestart.testdata.ConnectedWorldBuildingV5TestData;

import io.restassured.response.Response;

public class BuildingPatchUpdateNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	public void patchUpdateBuildingWithInvalidInputDetails() throws  IOException {

		PatchUpdateBuildingInvalidInputDetails patchUpdateBuildingInvalidInputDetails = ConnectedWorldBuildingV5TestData.getPatchUpdateBuildingInvalidInputDetails();
		String uniquekey = ConnectedWorldBuildingV5NegativeService.UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getPatchUpdateBuildingInvalidInputDetails(patchUpdateBuildingInvalidInputDetails, SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Building connection status is required")
		.assertAll();
	}
	@Test
	public void patchUpdateBuildingWithInvalidUniquekey() throws  IOException {

		PatchUpdateBuildingInvalidInputDetails patchUpdateBuildingInvalidInputDetails = ConnectedWorldBuildingV5TestData.getPatchUpdateBuildingInvalidInputDetails();
		String uniquekey = ConnectedWorldBuildingV5NegativeService.INVALID_UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getPatchUpdateBuildingInvalidInputDetails(patchUpdateBuildingInvalidInputDetails, SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Invalid Unique key:  Building not found")
		.assertAll();
	}
	@Test
	public void patchUpdateBuildingWithInvalidOcpKey() throws  IOException {

		PatchUpdateBuildingDetails patchUpdateBuildingDetails = ConnectedWorldBuildingV5TestData.getPatchUpdateBuildingDetails();
		String uniquekey = ConnectedWorldBuildingV5NegativeService.UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getPatchUpdateBuildingInvalidOcpKey(patchUpdateBuildingDetails, SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}
	@Test
	public void patchUpdateBuildingWithInvalidResources() throws  IOException {

		PatchUpdateBuildingDetails patchUpdateBuildingDetails = ConnectedWorldBuildingV5TestData.getPatchUpdateBuildingDetails();
		String uniquekey = ConnectedWorldBuildingV5NegativeService.UNIQUEKEY;
		Response response = ConnectedWorldBuildingV5NegativeService.getPatchUpdateBuildingInvalidEndpoint(patchUpdateBuildingDetails, SESSION_TOKEN,uniquekey);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}

}
