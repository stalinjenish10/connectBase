package com.capestart.connectedworldbuildingv5test.negativetest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.apilayers.ConnectedWorldBuildingV5Service;
import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.config.negativeconfig.ConnectedWorldBuildingNegativeTestConfig;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.ConnectedWorldBuildingV5NegativeService;

import io.restassured.response.Response;

public class GetAllBuildingsNegativeTest {

	public static  String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}
	@Test
	void getAllBuildingWithoutParameters(){
		Response response = ConnectedWorldBuildingV5NegativeService.getAllBuilding(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(200)
		.hasContentType("application/json")
		.assertAll();
	}
	@Test
	void getGetBuildingInvalidCompanyId(){
		Response response = ConnectedWorldBuildingV5NegativeService.getAllBuildingInvalidCompanyId(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid input. Please ensure that the subscription key and companyId are accurate.")
		.assertAll();
	}
	@Test
	void getGetBuildingInvalidHeader(){
		Response response = ConnectedWorldBuildingV5NegativeService.getAllBuildingInvalidHeader(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(401)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.")
		.assertAll();
	}
	@Test
	void getGetBuildingInvalidResources(){
		Response response = ConnectedWorldBuildingV5NegativeService.getAllBuildingInvalidEndpoint(SESSION_TOKEN);

		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(404)
		.hasContentType("application/json")
		.hasKeyWithValue("message", "Resource not found")
		.assertAll();
	}

}
