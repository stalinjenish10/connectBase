package com.capestart.advancecpqv2test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.AdvanceCpqDataProvider;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AdvanceCpqV2NegativeService;
import com.capestart.pojos.advancecpqv2.CreateBillingAccountDetails;
import com.capestart.testdata.AdvanceCpqV2TestData;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateBillingAccountNegativeTest {


  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Create Deal TestData", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void InvalidParameterTest(Object companyId, Object accountId) {
    CreateBillingAccountDetails createBillingAccountDetails = AdvanceCpqV2TestData.getCreateBillingAccountDetails();
    //CreateBillingAccountDetails createBillingAccountDetails1 = CreateBillingAccountDetails.builder().billingAccountName("zzzyyyy testing").build();

    Response response =
      AdvanceCpqV2NegativeService.createBillingAccount(createBillingAccountDetails, SESSION_TOKEN, companyId, accountId);
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

  @Test(dataProvider = "Post Create Deal TestData For 404", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void ResourceNotFoundTest(Object companyId, Object accountId) {
    CreateBillingAccountDetails createBillingAccountDetails = AdvanceCpqV2TestData.getCreateBillingAccountDetails();
    //CreateBillingAccountDetails createBillingAccountDetails1 = CreateBillingAccountDetails.builder().billingAccountName("zzzyyyy testing").build();

    Response response =
      AdvanceCpqV2NegativeService.createBillingAccount(createBillingAccountDetails, SESSION_TOKEN, companyId, accountId);
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
