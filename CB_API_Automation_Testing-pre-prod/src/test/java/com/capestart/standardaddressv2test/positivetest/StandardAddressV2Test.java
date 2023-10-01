package com.capestart.standardaddressv2test.positivetest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.capestart.apilayers.ConnectedWorldBuildingV5Service;
import com.capestart.apilayers.StandardAddressV2Service;
import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.extractingvalues.ConnectedWorldBuildingUtility;
import com.capestart.logintest.LoginSetup;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressStringDetails;
import com.capestart.testdata.StandardAddressV2TestData;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StandardAddressV2Test {
	public static String SESSION_TOKEN ;

	@BeforeSuite
	public void setUp() {
		// Ensure that the login setup runs only once for the entire suite
		LoginSetup.setUp();
		SESSION_TOKEN = LoginSetup.getSessionToken();
	}

	@Test
	void getCoordsStandardAddres(){
		Response response = StandardAddressV2Service.getCoordsStandardAddress(SESSION_TOKEN);
		String ResponseBody = response.then().log().all().extract().asPrettyString();

		String keyPath = "addresses[0].latitude" ; 
		String lat = ConnectedWorldBuildingUtility.extractuniquekey(ResponseBody, keyPath);
		ResponseAssert.assertthat(response)
		.statusCodeIs(200)
		.hasContentType("application/json; charset=utf-8")
		.hasKeyWithValue(keyPath, "40.323553")
		.assertAll();		
	}

	@Test
	void postStandardAddress() throws StreamReadException, DatabindException, IOException {
		PostStandardAddressDetails postStandardAddressDetails = StandardAddressV2TestData.getPostStandardAddressDetails();  
		Response response = StandardAddressV2Service.getPostStandardAddress(postStandardAddressDetails, SESSION_TOKEN);
		String ResponseBody = response.then().log().all().extract().asPrettyString();

		String keyPath = "data[0].address" ; 
		String Address1 = ConnectedWorldBuildingUtility.extractuniquekey(ResponseBody, keyPath);
		ResponseAssert.assertthat(response)
		.statusCodeIs(200)
		.hasKeyWithValue(keyPath, "135 St George St")
		.hasContentType("application/json; charset=utf-8")
		.assertAll();

	}

	@Test
	void postStandardAddressString() throws StreamReadException, DatabindException, IOException {
		PostStandardAddressStringDetails postStandardAddressStringDetails = StandardAddressV2TestData.getPostStandardAddressStringDetails();  
		Response response = StandardAddressV2Service.getPostStandardAddressString(postStandardAddressStringDetails, SESSION_TOKEN);
		String ResponseBody = response.then().log().all().extract().asPrettyString();

		ResponseAssert.assertthat(response)
		.statusCodeIs(200)
		.hasContentType("application/json; charset=utf-8")
		.assertAll();
	}

}
