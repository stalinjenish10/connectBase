package com.capestart.advancecpqv2test.positivetest;

import com.capestart.apilayers.AdvanceCpqV2Service;
import com.capestart.assertwrapper.ResponseAssert;
import com.capestart.extractingvalues.AdvanceCpqUtility;
import com.capestart.factory.ApiConfigFactory;
import com.capestart.logintest.LoginSetup;
import com.capestart.pojos.advancecpqv2.*;
import com.capestart.testdata.AdvanceCpqV2TestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.capestart.variableutils.login.cpq.AdvanceCpqSharedValueHolder.*;


public class AdvanceCpqTest {

  public static String SESSION_TOKEN;

  public static List<Integer> EXTRACTED_LOCATIONS_ID = new ArrayList<>();

  public static int EXTRACTED_ACCOUNT_ID = getAccountId();
  public static String EXTRACTED_BILLING_ACCOUNT_ID = getBillingAccountId();

  public static int EXTRACTED_QUOTE_ID = getQuoteId();

  public static int EXTRACTED_DEAL_ACCOUNT_ID = getDealAccountId();

  public static String UPDATED_DEAL_NAME = ApiConfigFactory.getConfig().getUpdatedDealName();

  @BeforeSuite
  public void setUp() {
    // Ensure that the login setup runs only once for the entire suite
    LoginSetup.setUp();
    SESSION_TOKEN = LoginSetup.getSessionToken();
  }


  @Test
  void postCreateAccount() throws IOException {
    CreateAccountDetails createAccountDetails = AdvanceCpqV2TestData.getCreateAccountDetails();
    //CreateAccountDetails createAccountDetails1 = CreateAccountDetails.builder().company_name("zzzyyyy testing").build();
    Response response = AdvanceCpqV2Service.postCreateAccount(createAccountDetails, SESSION_TOKEN);
    response.then().log().all();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .canBeDeserializedTo(CreateAccountResponseDetails.class)
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "postCreateAccount")
  void GetAccountsList() throws JsonProcessingException {
    Response response = AdvanceCpqV2Service.getAccountsList(SESSION_TOKEN);
    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

    String keyPath = "data.companies";
    String keyToFind = "company_name";
    String dataToFind = "id";
    List<Map<String, Object>> companies = AdvanceCpqUtility.extractCompanies(ResponseBody, keyPath);
    String companyNameToFind = "API Automation Testing";
    EXTRACTED_ACCOUNT_ID = AdvanceCpqUtility.findDesiredID(companies, companyNameToFind, keyToFind, dataToFind);

    System.out.println("Extracted account ID: " + EXTRACTED_ACCOUNT_ID);
  }

  @Test(dependsOnMethods = "GetAccountsList")
  void GetAccountListById() {
    Response response = AdvanceCpqV2Service.getAccountListById(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetAccountListById")
  void CreateBillingAccount() {
    CreateBillingAccountDetails createBillingAccountDetails = AdvanceCpqV2TestData.getCreateBillingAccountDetails();
    //CreateBillingAccountDetails createBillingAccountDetails1 = CreateBillingAccountDetails.builder().billingAccountName("zzzyyyy testing").build();

    Response response = AdvanceCpqV2Service.createBillingAccount(createBillingAccountDetails, SESSION_TOKEN, EXTRACTED_ACCOUNT_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "CreateBillingAccount")
  void GetBillingAccountDetails() {
    Response response = AdvanceCpqV2Service.getBillingAccountDetails(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    String keyPath = "data";
    List<Map<String, Object>> companies = AdvanceCpqUtility.extractCompanies(ResponseBody, keyPath);

    String companyNameToFind = "API Bills Testing";
    EXTRACTED_BILLING_ACCOUNT_ID = AdvanceCpqUtility.findBillingAccountID(companies, companyNameToFind);

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

  }

  @Test(dependsOnMethods = "GetBillingAccountDetails")
  void CreateDealAccountDetails() {
    CreateDealAccountDetails createDealAccountDetails = AdvanceCpqV2TestData.getCreateDealAccountDetails();
//        CreateDealAccountDetails createDealAccountDetails  = CreateDealAccountDetails
//                .builder()
//                .SetDeal_name("zzzyyyy testing")
//                .build();
    Response response = AdvanceCpqV2Service.createDealAccountDetails(createDealAccountDetails, SESSION_TOKEN, EXTRACTED_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

  }

  @Test(dependsOnMethods = "CreateDealAccountDetails")
  void GetDealsAccountDetails() {
    Response response = AdvanceCpqV2Service.getDealAccountDetails(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

    String keyPath = "data.deals";
    String keyToFind = "deal_name";
    String dataToFind = "id";
    List<Map<String, Object>> companies = AdvanceCpqUtility.extractCompanies(ResponseBody, keyPath);

    String dealNameToFind = "API Deals Testing";
    EXTRACTED_DEAL_ACCOUNT_ID = AdvanceCpqUtility.findDesiredID(companies, dealNameToFind, keyToFind, dataToFind);
  }

  @Test(dependsOnMethods = "GetDealsAccountDetails")
  void GetDealAccountById() {
    Response response = AdvanceCpqV2Service.getDealAccountById(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

  }

  @Test(dependsOnMethods = "GetDealAccountById")
  void UpdateDealName() {
    //CreateDealAccountDetails createDealAccountDetails = AdvanceCpqV2TestData.getCreateDealAccountDetails();
    UpdateDealAccountDetails updateDealAccountDetails = UpdateDealAccountDetails
      .builder()
     .SetDealName(UPDATED_DEAL_NAME)
      .build();
    Response response = AdvanceCpqV2Service.updateDealAccountName(updateDealAccountDetails, SESSION_TOKEN, EXTRACTED_ACCOUNT_ID,
      EXTRACTED_DEAL_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "UpdateDealName")
  void UpdateAccountName() {
    UpdateAccountDetails updateAccountDetails = AdvanceCpqV2TestData.getUpdateAccountDetails();

    Response response = AdvanceCpqV2Service.updateAccountDetails(updateAccountDetails, SESSION_TOKEN, EXTRACTED_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "UpdateAccountName")
  void AddLocationsToDeal() {
    AddLocationDetails addLocationDetails = AdvanceCpqV2TestData.getAddLocationDetails();

    Response response =
      AdvanceCpqV2Service.addLocationToDeal(addLocationDetails, SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "AddLocationsToDeal")
  void GetLocations() {
    Response response = AdvanceCpqV2Service.getLocations(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID);

    String ResponseBody = response.then().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

    String keyPath = "data.locations";
    String keyToFind = "address";
    String dataToFind = "id";
    List<Map<String, Object>> locations = AdvanceCpqUtility.extractCompanies(ResponseBody, keyPath);

    String locationNameToFind1 = "1961 Chain Bridge Rd";
    String locationNameToFind2 = "5700 Rue St-zotique E";
    String locationNameToFind3 = "101 Englewood Pkwy, Englewood, CO 80110, United States";

    List<String> locationsNamesToFind = new ArrayList<>();
    locationsNamesToFind.add(locationNameToFind1);
    locationsNamesToFind.add(locationNameToFind2);
    locationsNamesToFind.add(locationNameToFind3);

    EXTRACTED_LOCATIONS_ID = AdvanceCpqUtility.findMultipleDesiredValues(locations, locationsNamesToFind, keyToFind, dataToFind);

    System.out.println("Extracted Location Id: " + EXTRACTED_LOCATIONS_ID);
  }

  @Test(dependsOnMethods = "GetLocations")
  void DeleteLocation() {
    List<Integer> locationIds = EXTRACTED_LOCATIONS_ID;
    int index = 0; // specify the index you want to extract

    int extracted_location_Id = locationIds.get(index);

    Response response =
      AdvanceCpqV2Service.deleteLocation(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID, extracted_location_Id);
    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

  }

  @Test(dependsOnMethods = "DeleteLocation")
  void PostCreatePricing() {
    CreatePricingDetails createPricingDetails = AdvanceCpqV2TestData.getCreatePricingDetails();

    Response response =
      AdvanceCpqV2Service.postCreatePricing(createPricingDetails, SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "PostCreatePricing")
  void GetListOfQuotes() {
    Response response = AdvanceCpqV2Service.getListOfQuotes(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID);

    String ResponseBody = response.then().log().all().extract().asPrettyString();

    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
//                .matchingRule(response1 ->
//                        response1.jsonPath().getString("quotes.quote_name").equalsIgnoreCase("Post create pricing test"))
      .assertAll();

    String keyPath = "data.quotes";
    String keyToFind = "quote_name";
    String dataToFind = "id";
    List<Map<String, Object>> companies = AdvanceCpqUtility.extractCompanies(ResponseBody, keyPath);

    String dealNameToFind = "Post create pricing test";
    EXTRACTED_QUOTE_ID = AdvanceCpqUtility.findDesiredID(companies, dealNameToFind, keyToFind, dataToFind);

    System.out.println("Extracted Quote ID: " + EXTRACTED_QUOTE_ID);
  }

  @Test(dependsOnMethods = "GetListOfQuotes", alwaysRun = true)
  void GetPrices() {
    Response response = AdvanceCpqV2Service.getPrices(SESSION_TOKEN, EXTRACTED_QUOTE_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetPrices", alwaysRun = true)
  void GetQuotePrices() {
    Response response =
      AdvanceCpqV2Service.getQuotePrice(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID, EXTRACTED_QUOTE_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetQuotePrices", alwaysRun = true)
  void GetQuoteConfig() {
    Response response = AdvanceCpqV2Service.getQuoteConfig(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetQuoteConfig", alwaysRun = true)
  void GetSelectedPrice() {
    Response response = AdvanceCpqV2Service.getSelectedPrice(SESSION_TOKEN, EXTRACTED_QUOTE_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetSelectedPrice", alwaysRun = true)
  void CreateOrder() {
    CreateOrderDetails createOrderDetails = AdvanceCpqV2TestData.getCreateOrderDetails();
    Response response = AdvanceCpqV2Service.createOrder(createOrderDetails, SESSION_TOKEN, EXTRACTED_QUOTE_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "CreateOrder", alwaysRun = true)
  void GetFallOut() {
    Response response = AdvanceCpqV2Service.getFallOut(SESSION_TOKEN, EXTRACTED_QUOTE_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "GetFallOut", alwaysRun = true)
  void GetUsersCompanies() {
    Response response = AdvanceCpqV2Service.getUsersCompanies(SESSION_TOKEN);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();

  }

  @Test(dependsOnMethods = "GetUsersCompanies", alwaysRun = true)
  void DeleteDeal() {
    Response response = AdvanceCpqV2Service.deleteDeal(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID, EXTRACTED_DEAL_ACCOUNT_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

  @Test(dependsOnMethods = "DeleteDeal", alwaysRun = true)
  void DeleteAccount() {
    Response response = AdvanceCpqV2Service.deleteAccount(SESSION_TOKEN, EXTRACTED_ACCOUNT_ID);
    String ResponseBody = response.then().log().all().extract().asPrettyString();
    ResponseAssert.assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .hasKeyWithValue("status", "success")
      .assertAll();
  }

}
