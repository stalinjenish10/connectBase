package com.capestart.connectedworldbuildingv5test.negativetest;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.ConnectedWorldBuildingV5NegativeService;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingWithInvalidBodyDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingWithInvalidInputDetails;
import com.capestart.testdata.ConnectedWorldBuildingV5TestData;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import io.restassured.response.Response;

public class PostCreateBuildingNegativeTest {


	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	public void postCreateBuildingWithInvalidBody() throws  IOException {

		CreateBuildingWithInvalidBodyDetails createBuildingWithInvalidBodyDetails = ConnectedWorldBuildingV5TestData.getCreateBuildingWithInvalidBodyDetails();

		Response response = ConnectedWorldBuildingV5NegativeService.getPostCreateAccountInvalidBody(createBuildingWithInvalidBodyDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "The Building Address value is required")
		.assertAll();
	}

	@Test
	public void postCreateBuildingWithInvalidInput() throws  IOException {

		CreateBuildingWithInvalidInputDetails createBuildingWithInvalidInputDetails = ConnectedWorldBuildingV5TestData.getCreateBuildingWithInvalidInputDetails();

		Response response = ConnectedWorldBuildingV5NegativeService.getPostCreateAccountInputDetails(createBuildingWithInvalidInputDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(400)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Building connection status is required")
		.assertAll();

	}
	@Test
	public void postCreateBuildingWithInvalidheader() throws  IOException {

		CreateBuildingDetails createBuildingDetails = ConnectedWorldBuildingV5TestData.getCreateBuildingDetails();

		Response response = ConnectedWorldBuildingV5NegativeService.getPostCreateAccountInvalidHeader(createBuildingDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();

	}
	@Test
	public void postCreateBuildingWithInvalidResources() throws  IOException {

		CreateBuildingDetails createBuildingDetails = ConnectedWorldBuildingV5TestData.getCreateBuildingDetails();

		Response response = ConnectedWorldBuildingV5NegativeService.getPostCreateAccountInvalidEndpoint(createBuildingDetails, SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();

	}



}
