package com.capestart.advancecpqv2test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.AdvanceCpqDataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AdvanceCpqV2NegativeService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetBillingAccountDetailsNegativeTest {

  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Create Deal TestData", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void InvalidParameterTest(Object companyId, Object accountId) {
    Response response = AdvanceCpqV2NegativeService.getBillingAccountDetails(SESSION_TOKEN, companyId, accountId, true, false);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("900".equals(String.valueOf(companyId))) {
      message = "'params.accountId' must be a number";
      //"The requested company with ID " + companyId + " does not exist.";
    } else if ("Invalid".equals(String.valueOf(companyId))) {
      message = "params.companyId' must be a number";
    }
    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();

  }

  @Test(dataProvider = "Account List By Id Invalid Key Data For 401", dataProviderClass = AdvanceCpqDataProvider.class)
  void InvalidKeyUnauthorizedTest(Object COMPANY_ID, Object AccountId, boolean isPositive) throws IOException {
    Response response = AdvanceCpqV2NegativeService.getBillingAccountDetails(SESSION_TOKEN, COMPANY_ID, AccountId, false, false);
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

  @Test(dataProvider = "Post Create Deal Test Other User Data For 401", dataProviderClass = AdvanceCpqDataProvider.class)
  void AccessOtherUsersDataUnauthorizedTest(Object COMPANY_ID, Object Account_ID, boolean isPositive) throws IOException {
    Response response = AdvanceCpqV2NegativeService.getBillingAccountDetails(SESSION_TOKEN, COMPANY_ID, Account_ID, false, true);
    response.then().log().all();
    String expectedMessage = "User doesn't have access for the other user data";
    //: "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.";

    ResponseAssert.assertthat(response)
      .statusCodeIs(401)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("message", expectedMessage)
      .assertAll();
  }

  @Test(dataProvider = "Post Create Deal TestData For 404", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void ResourceNotFoundTest(Object companyId, Object accountId) {
    Response response = AdvanceCpqV2NegativeService.getBillingAccountDetails(SESSION_TOKEN, companyId, accountId, true, false);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("900".equals(String.valueOf(companyId))) {
      message = "Account with provided id '456321458' does not exist";
      //"The requested company with ID " + companyId + " does not exist.";
    } else if ("456321458".equals(String.valueOf(companyId))) {
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
