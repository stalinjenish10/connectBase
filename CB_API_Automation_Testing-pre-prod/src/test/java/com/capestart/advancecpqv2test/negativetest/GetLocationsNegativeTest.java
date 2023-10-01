package com.capestart.advancecpqv2test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.AdvanceCpqDataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AdvanceCpqV2NegativeService;
import com.capestart.pojos.advancecpqv2.AddLocationDetails;
import com.capestart.testdata.AdvanceCpqV2TestData;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetLocationsNegativeTest {

  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Get Deal By Id TestData", dataProviderClass = AdvanceCpqDataProvider.class)
  void InvalidParameterTest(Object companyId, Object AccountId, Object DealId) {
    Response response = AdvanceCpqV2NegativeService.getLocations(SESSION_TOKEN, companyId, AccountId, DealId, true, false);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("Invalid".equals(String.valueOf(DealId))) {
      message = "'params.dealId' must be a number";
    } else if ("Invalid".equals(String.valueOf(companyId)) & AccountId.equals(String.valueOf(AccountId))) {
      message = "'params.companyId' must be numbers";
    } else if ("900".equals(String.valueOf(companyId))) {
      message = "'params.accountId' must be a number";
    }

    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }

  @Test(dataProvider = "Post Get Locations Invalid Key Test Data For 401", dataProviderClass = AdvanceCpqDataProvider.class)
  void InvalidKeyUnauthorizedTest(Object COMPANY_ID, Object AccountId, Object dealId, boolean isPositive) throws IOException {
    Response response = AdvanceCpqV2NegativeService.getLocations(SESSION_TOKEN, COMPANY_ID, AccountId, dealId, false, false);
    response.then().log().all();
    String expectedMessage =
      //? "Access denied for other user account."
      "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.";
    ResponseAssert.assertthat(response)
      .statusCodeIs(401)
      .hasContentType("application/json")
      .hasKeyWithValue("message", expectedMessage)
      .assertAll();
  }

  @Test(dataProvider = "Post Get Locations Others User Test Data For 401", dataProviderClass = AdvanceCpqDataProvider.class)
  void AccessOtherUsersDataUnauthorizedTest(Object COMPANY_ID, Object Account_ID, Object dealId, boolean isPositive)
    throws IOException {
    Response response = AdvanceCpqV2NegativeService.getLocations(SESSION_TOKEN, COMPANY_ID, Account_ID, dealId, false, true);
    response.then().log().all();
    String expectedMessage = "User doesn't have access for the other user data";
    //: "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.";

    ResponseAssert.assertthat(response)
      .statusCodeIs(401)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("message", expectedMessage)
      .assertAll();
  }

  @Test(dataProvider = "Post Get Deal By Id TestData For 404", dataProviderClass = AdvanceCpqDataProvider.class)
  void ResourceNotFoundTest(Object companyId, Object AccountId, Object DealId) {
    AddLocationDetails addLocationDetails = AdvanceCpqV2TestData.getAddLocationDetails();

    Response response = AdvanceCpqV2NegativeService.getLocations(SESSION_TOKEN, companyId, AccountId, DealId, true, false);

    String responseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("900".equals(String.valueOf(companyId)) & AccountId.equals(String.valueOf(AccountId)) &
      "456321458".equals(String.valueOf(DealId))) {
      message = "Deal with provided id '456321458' does not exist";
      //"The requested company with ID " + companyId + " does not exist.";
    } else if ("456321458".equals(String.valueOf(companyId))) {
      message = "Unable to find company: 456321458";
    } else if ("900".equals(String.valueOf(companyId))) {
      message = "Account with provided id '456321458' does not exist";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(404)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }
}
