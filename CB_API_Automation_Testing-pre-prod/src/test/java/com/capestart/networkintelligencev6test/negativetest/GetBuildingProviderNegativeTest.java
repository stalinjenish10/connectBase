package com.capestart.networkintelligencev6test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.NetworkIntelligenceV6DataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.NetworkIntelligenceV6NegativeService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GetBuildingProviderNegativeTest {
  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Get Building Provider Test Data", dataProviderClass = NetworkIntelligenceV6DataProvider.class, invocationCount = 1)
  void InvalidParameterTest(Object companyId, Object addressParameter, Object validationType) {
    Response response =
      NetworkIntelligenceV6NegativeService.getBuildingProviders(SESSION_TOKEN, companyId, addressParameter, validationType);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("Invalid".equals(String.valueOf(companyId))) {
      message = "'params.companyId' must be a number";
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

  @Test(dataProvider = "Get Building Provider Test Data For 404", dataProviderClass = NetworkIntelligenceV6DataProvider.class)
  void ResourceNotFoundTest(Object companyId, Object addressParameter, Object validationType) {
    Response response =
      NetworkIntelligenceV6NegativeService.getBuildingProviders(SESSION_TOKEN, companyId, addressParameter, validationType);
    String responseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("Invalid".equals(String.valueOf(companyId))) {
      message = "Unable to find CompanyId: " + companyId;
      //"The requested company with ID " + companyId + " does not exist.";
    } else if (addressParameter.equals(String.valueOf(addressParameter))) {
      message =
        "Address not found for - : {\\\"address\\\":\\\"456321458\\\",\\\"city\\\":\\\"\\\",\\\"state\\\":\\\"\\\",\\\"country\\\":\\\"\\\"} in getGeocodeAPIResponse";
    } else if (addressParameter.equals(String.valueOf(addressParameter)) & addressParameter.equals(String.valueOf(addressParameter)) &
      validationType.equals(String.valueOf(validationType))) {
      message = "'query.validation' must be one of [true, false]";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(404)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }
}
