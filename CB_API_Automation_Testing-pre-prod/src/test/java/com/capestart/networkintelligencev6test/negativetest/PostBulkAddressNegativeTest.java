package com.capestart.networkintelligencev6test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.NetworkIntelligenceV6DataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.NetworkIntelligenceV6NegativeService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PostBulkAddressNegativeTest {
  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Bulk Address Test Data", dataProviderClass = NetworkIntelligenceV6DataProvider.class)
  void InvalidParameterTest(Object companyId) {
    Response response = NetworkIntelligenceV6NegativeService.getPostBulkAddress(SESSION_TOKEN, companyId);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("Invalid".equals(String.valueOf(companyId))) {
      message = "'query.[companyId]' must be a number";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }

  @Test(dataProvider = "Post Bulk Address Test Data For 404", dataProviderClass = NetworkIntelligenceV6DataProvider.class)
  void ResourceNotFoundTest(Object companyId) {
    Response response = NetworkIntelligenceV6NegativeService.getPostBulkAddress(SESSION_TOKEN, companyId);
    String responseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if (companyId.equals(String.valueOf(companyId))) {
      message = "Company with provided id '456321458' does not exist";
      //"The requested company with ID " + companyId + " does not exist.";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(404)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }
}
