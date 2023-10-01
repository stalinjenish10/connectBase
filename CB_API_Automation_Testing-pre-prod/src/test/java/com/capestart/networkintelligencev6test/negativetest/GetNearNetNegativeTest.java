package com.capestart.networkintelligencev6test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.NetworkIntelligenceV6DataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.NetworkIntelligenceV6NegativeService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GetNearNetNegativeTest {
  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Get Near Net Test Data", dataProviderClass = NetworkIntelligenceV6DataProvider.class, invocationCount = 1)
  void InvalidParameterTest(Object companyId, Object latId, Object longtId, Object validationType) {
    Response response = NetworkIntelligenceV6NegativeService.getNearNet(SESSION_TOKEN, companyId, latId, longtId, validationType);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("Invalid".equals(String.valueOf(latId))) {
      message = "'query.lat' must be a number";
    } else if ("Invalid".equals(String.valueOf(longtId))) {
      message = "'query.lon' must be a number";
    } else if ("Invalid".equals(String.valueOf(validationType))) {
      message = "'query.validation' must be one of [true, false]";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }

  @Test(dataProvider = "Get Near Net Test Data For 404", dataProviderClass = NetworkIntelligenceV6DataProvider.class)
  void ResourceNotFoundTest(Object companyId, Object latId, Object longtId, Object validationType) {
    Response response = NetworkIntelligenceV6NegativeService.getNearNet(SESSION_TOKEN, companyId, latId, longtId, validationType);
    String responseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("900".equals(String.valueOf(latId))) {
      message = "Account with provided id '456321458' does not exist";
      //"The requested company with ID " + companyId + " does not exist.";
    } else if ("456321458".equals(String.valueOf(longtId))) {
      message = "Unable to find company: 456321458";
    } else if ("456321458".equals(String.valueOf(validationType))) {
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
