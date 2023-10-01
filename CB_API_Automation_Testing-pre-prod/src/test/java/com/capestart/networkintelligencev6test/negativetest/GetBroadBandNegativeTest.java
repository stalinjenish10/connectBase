package com.capestart.networkintelligencev6test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.NetworkIntelligenceV6DataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.NetworkIntelligenceV6NegativeService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GetBroadBandNegativeTest {
  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Get Broad Band Test Data", dataProviderClass = NetworkIntelligenceV6DataProvider.class)
  void InvalidParameterTest(Object latId, Object longtId) {
    Response response = NetworkIntelligenceV6NegativeService.getBroadBand(SESSION_TOKEN, latId, longtId);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("Invalid".equals(String.valueOf(latId))) {
      message = "'query.lat' must be a number";
    } else if ("Invalid".equals(String.valueOf(longtId))) {
      message = "'query.lon' must be a number";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }

  @Test(dataProvider = "Get Broad Band Test Data For 404", dataProviderClass = NetworkIntelligenceV6DataProvider.class)
  void ResourceNotFoundTest(Object latId, Object longtId) {
    Response response = NetworkIntelligenceV6NegativeService.getBroadBand(SESSION_TOKEN, latId, longtId);
    String responseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if (latId.equals(String.valueOf(latId))) {
      message = "Account with provided id '456321458' does not exist";
      //"The requested company with ID " + companyId + " does not exist.";
    } else if (longtId.equals(String.valueOf(longtId))) {
      message = "Unable to find company: 456321458";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(404)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }
}
