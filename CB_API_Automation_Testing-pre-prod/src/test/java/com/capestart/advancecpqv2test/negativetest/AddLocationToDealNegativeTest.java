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

import java.util.Objects;

public class AddLocationToDealNegativeTest {

  public static String SESSION_TOKEN;

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Get Deal By Id TestData", dataProviderClass = AdvanceCpqDataProvider.class)
  void InvalidParameterTest(Object companyId, Object AccountId, Object DealId) {
    AddLocationDetails addLocationDetails = AdvanceCpqV2TestData.getAddLocationDetails();
    Response response = AdvanceCpqV2NegativeService.addLocationToDeal(addLocationDetails, SESSION_TOKEN, companyId, AccountId, DealId);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if ("Invalid".equals(String.valueOf(AccountId))) {
      message = "'params.accountId' must be a number";
    } else if ("Invalid".equals(String.valueOf(companyId)) & AccountId.equals(String.valueOf(AccountId))) {
      message = "'params.companyId' must be numbers";
    } else if ("900".equals(String.valueOf(companyId)) & AccountId.equals(String.valueOf(AccountId)) &
      "Invalid".equals(String.valueOf(DealId))) {
      message = "'params.dealId' must be a number";
    }

    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "fail")
      .hasKeyWithValue("message", message)
      .assertAll();
  }

  @Test(dataProvider = "Post Get Deal By Id TestData For 404", dataProviderClass = AdvanceCpqDataProvider.class)
  void ResourceNotFoundTest(Object companyId, Object AccountId, Object DealId) {
    AddLocationDetails addLocationDetails = AdvanceCpqV2TestData.getAddLocationDetails();

    Response response = AdvanceCpqV2NegativeService.addLocationToDeal(addLocationDetails, SESSION_TOKEN, companyId, AccountId, DealId);

    String responseBody = response.then().log().all().extract().asPrettyString();
    String message = null;
    if (Objects.equals(companyId, companyId) & Objects.equals(AccountId, AccountId) & Objects.equals(DealId, DealId)) {
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
