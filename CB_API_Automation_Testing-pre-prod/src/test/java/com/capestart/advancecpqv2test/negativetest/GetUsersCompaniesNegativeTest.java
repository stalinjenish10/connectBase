package com.capestart.advancecpqv2test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.AdvanceCpqDataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AdvanceCpqV2NegativeService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUsersCompaniesNegativeTest {
  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Create Account TestData", dataProviderClass = AdvanceCpqDataProvider.class)
  void InvalidParameterTest(Object userId) throws IOException {
    Response response = AdvanceCpqV2NegativeService.getUsersCompanies(SESSION_TOKEN, userId);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("message", "'params.userId' must be a number")
      .assertAll();
  }


//    @Test (dataProvider = "TestScenarios", dataProviderClass = AdvanceCpqDataProvider.class)
//    void AccessOtherUsersDataUnauthorizedTest(Object userId) throws IOException {
//        Response response = AdvanceCpqV2NegativeService.GetUsersCompanies(SESSION_TOKEN, userId);
//        response.then().log().all();
//        String expectedMessage = isPositive
//                ? "Access denied for other user account."
//                : "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.";
//
//        ResponseAssert.assertthat(response)
//                .statusCodeIs(401)
//                .hasContentType("application/json")
//                .hasKeyWithValue("message", expectedMessage)
//                .assertAll();
//    }

  @Test(dataProvider = "Post Create Account TestData For 404", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void ResourceNotFoundTest(Object userId) throws IOException {
    Response response = AdvanceCpqV2NegativeService.getUsersCompanies(SESSION_TOKEN, userId);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(404)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("message", "The requested user with ID " + userId + " does not exist.")
      .assertAll();
  }
}
