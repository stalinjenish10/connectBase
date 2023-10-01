package com.capestart.advancecpqv2test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.AdvanceCpqDataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AdvanceCpqV2NegativeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GetAccountListsNegativeTest {

  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Create Account TestData", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void InvalidParameterTest(Object companyId) throws JsonProcessingException {
    Response response = AdvanceCpqV2NegativeService.getAccountsList(SESSION_TOKEN, companyId);
    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", "'params.accountId' must be a number")
      .assertAll();
  }

  @Test(dataProvider = "Post Create Account TestData For 404", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void ResourceNotFoundTest(Object companyId) throws JsonProcessingException {
    Response response = AdvanceCpqV2NegativeService.getAccountsList(SESSION_TOKEN, companyId);
    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(404)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", "Unable to find company: 56789")
      .assertAll();
  }
}
