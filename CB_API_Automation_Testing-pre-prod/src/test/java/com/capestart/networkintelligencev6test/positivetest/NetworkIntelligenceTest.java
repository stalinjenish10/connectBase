package com.capestart.networkintelligencev6test.positivetest;

import com.capestart.apilayers.NetworkIntelligenceV6Service;
import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.logintest.LoginSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NetworkIntelligenceTest {

  public static String SESSION_TOKEN;

  public static String EXTRACTED_REQUEST_ID;


  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test
  void GetAll() {
    Response response = NetworkIntelligenceV6Service.getAll(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetAll")
  void GetBroadBand() {
    Response response = NetworkIntelligenceV6Service.getBroadBand(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetBroadBand")
  void PostBulkAddress() {

    Response response = NetworkIntelligenceV6Service.getPostBulkAddress(SESSION_TOKEN);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "Completed")
      .assertAll();

    JsonPath jsonPath = response.jsonPath();
    // Extract the requestId using JSONPath
    EXTRACTED_REQUEST_ID = jsonPath.getString("requestId"); // Update the JSONPath expression
  }

  @Test(dependsOnMethods = "PostBulkAddress", alwaysRun = true)
  void GetBulkAddressCallBack() {
    Response response = NetworkIntelligenceV6Service.getBulkAddressCallBack(SESSION_TOKEN, EXTRACTED_REQUEST_ID);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "Completed")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetBulkAddressCallBack", alwaysRun = true)
  void GetCabLeco() {
    Response response = NetworkIntelligenceV6Service.getCabLeco(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetCabLeco")
  void GetConfirmedProvider() {
    Response response = NetworkIntelligenceV6Service.getConformedProvider(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "found")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetConfirmedProvider")
  void GetBuildingsProviders() {
    Response response = NetworkIntelligenceV6Service.getBuildingProviders(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetBuildingsProviders")
  void GetBuildingsProvidersByAddress() {
    Response response = NetworkIntelligenceV6Service.getBuildingProvidersByAddress(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetBuildingsProvidersByAddress")
  void GetNearNet() {
    Response response = NetworkIntelligenceV6Service.getNearNet(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetNearNet")
  void GetOnNet() {
    Response response = NetworkIntelligenceV6Service.getOnNet(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetOnNet")
  void GetTelco() {
    Response response = NetworkIntelligenceV6Service.getTelco(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetTelco")
  void GetWisp() {
    Response response = NetworkIntelligenceV6Service.getWisp(SESSION_TOKEN);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

}
