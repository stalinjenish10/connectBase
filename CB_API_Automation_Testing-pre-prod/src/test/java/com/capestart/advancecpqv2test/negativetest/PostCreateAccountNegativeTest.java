package com.capestart.advancecpqv2test.negativetest;

import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.dataproviders.AdvanceCpqDataProvider;
import com.capestart.factory.ApiConfigFactory;
import com.capestart.logintest.LoginSetup;
import com.capestart.negativeapilayers.AdvanceCpqV2NegativeService;
import com.capestart.pojos.advancecpqv2.CreateAccountDetails;
import com.capestart.testdata.AdvanceCpqV2TestData;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostCreateAccountNegativeTest {

  public static String SESSION_TOKEN;
  private static final String OTHER_USER_CPQ_OCP_KEY = ApiConfigFactory.getCpqNegativeTestApiConfig().getOtherUserCpqOcpKey();

  private static final String INVALID_OCP_KEY = ApiConfigFactory.getCpqNegativeTestApiConfig().getGeneralInvalidOcpKey();

  private static final String INVALID_DATA = ApiConfigFactory.getCpqNegativeTestApiConfig().getInvalidData();

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }

  @Test(dataProvider = "Post Create Account TestData", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void InvalidParameterTest(Object companyId) throws IOException {
    CreateAccountDetails createAccountDetails = AdvanceCpqV2TestData.getCreateAccountDetails();
    Response response = AdvanceCpqV2NegativeService.postCreateAccount(createAccountDetails, SESSION_TOKEN, companyId, true, false);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(400)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("message", "'params.companyId' must be a number")
      .assertAll();
  }


  @Test(dataProvider = "Invalid Key", dataProviderClass = AdvanceCpqDataProvider.class)
  void InvalidKeyUnauthorizedTest(Object COMPANY_ID, boolean isPositive) throws IOException {
    CreateAccountDetails createAccountDetails = AdvanceCpqV2TestData.getCreateAccountDetails();
    Response response = AdvanceCpqV2NegativeService.postCreateAccount(createAccountDetails, SESSION_TOKEN, COMPANY_ID, false, false);
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

  @Test(dataProvider = "Post Create Account TestData For 404", dataProviderClass = AdvanceCpqDataProvider.class, invocationCount = 1)
  void ResourceNotFoundTest(Object companyId) throws IOException {
    CreateAccountDetails createAccountDetails = AdvanceCpqV2TestData.getCreateAccountDetails();

    Response response = AdvanceCpqV2NegativeService.postCreateAccount(createAccountDetails, SESSION_TOKEN, companyId, true, false);
    response.then().log().all();
    ResponseAssert.assertthat(response)
      .statusCodeIs(404)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("message", "Unable to find company: 56789")
      .assertAll();
  }
}
