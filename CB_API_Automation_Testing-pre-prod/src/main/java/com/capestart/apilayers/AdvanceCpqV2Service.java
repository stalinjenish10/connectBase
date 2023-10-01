package com.capestart.apilayers;

import com.capestart.factory.ApiConfigFactory;
import com.capestart.pojos.advancecpqv2.*;
import com.capestart.pojos.login.LoginResponseDetails;
import io.restassured.response.Response;


public final class AdvanceCpqV2Service {

  private AdvanceCpqV2Service() {
  }

  private static final String CPQ_VERSION_ENDPOINT = ApiConfigFactory.getConfig().cpqVersionEndpoint();

  private static final String ACCOUNT_ID_ENDPOINT = ApiConfigFactory.getConfig().accountIdEndpoint();

  private static final String CREATE_ACCOUNT_ENDPOINT = ApiConfigFactory.getConfig().createAccountEndpoint();

  private static final String CREATE_BILLING_ACCOUNT_ENDPOINT = ApiConfigFactory.getConfig().createBillingAccountEndpoint();

  private static final String CREATE_DEAL_ACCOUNT_ENDPOINT = ApiConfigFactory.getConfig().createDealAccountEndpoint();

  private static final String GET_DEAL_ACCOUNT_BY_ID_ENDPOINT = ApiConfigFactory.getConfig().getDealAccountByIdEndpoint();

  private static final String UPDATE_ACCOUNT_ENDPOINT = ApiConfigFactory.getConfig().getUpdateAccountEndPoint();

  private static final String POST_LOCATION_ENDPOINT = ApiConfigFactory.getConfig().getAddLocationEndPoint();

  private static final String DELETE_LOCATION_ENDPOINT = ApiConfigFactory.getConfig().getDeleteLocationEndPoint();

  private static final String GET_LIST_OF_QUOTES_ENDPOINT = ApiConfigFactory.getConfig().getListOfQuotesEndPoint();

  private static final String GET_PRICES_ENDPOINT = ApiConfigFactory.getConfig().getPricesEndPoint();

  private static final String GET_QUOTE_PRICE_ENDPOINT = ApiConfigFactory.getConfig().getQuotePriceEndPoint();

  private static final String GET_QUOTE_CONFIG_ENDPOINT = ApiConfigFactory.getConfig().getQuoteConfigEndPoint();

  private static final String GET_SELECTED_PRICES_ENDPOINT = ApiConfigFactory.getConfig().getSelectedPricesEndPoint();

  private static final String CREATE_ORDER_ENDPOINT = ApiConfigFactory.getConfig().getCreateOrderEndPoint();

  private static final String GET_FALL_OUT_ENDPOINT = ApiConfigFactory.getConfig().getFalloutEndPoint();

  private static final String GET_USERS_COMPANIES_ENDPOINT = ApiConfigFactory.getConfig().getUsersCompaniesEndPoint();

  private static final String DELETE_DEAL_ENDPOINT = ApiConfigFactory.getConfig().getDeleteDealEndPoint();


  private static final String COMPANY_ID = ApiConfigFactory.getConfig().companyId();
  static int USER_ID = LoginResponseDetails.User.id;

  public static Response postCreateAccount(CreateAccountDetails createAccountDetails, String SESSIONTOKEN) {
    {
      return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
        .queryParam("companyId", COMPANY_ID)
        .body(createAccountDetails)
        .post(CPQ_VERSION_ENDPOINT + CREATE_ACCOUNT_ENDPOINT);
    }
  }

  public static Response getAccountsList(String SESSIONTOKEN) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + CREATE_ACCOUNT_ENDPOINT);
  }

  public static Response getAccountListById(String SESSIONTOKEN, int EXTRACTEDACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", EXTRACTEDACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + ACCOUNT_ID_ENDPOINT);
  }

  public static Response createBillingAccount(CreateBillingAccountDetails createBillingAccountDetails, String SESSIONTOKEN,
                                              int EXTRACTEDACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(createBillingAccountDetails)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .post(CPQ_VERSION_ENDPOINT + CREATE_BILLING_ACCOUNT_ENDPOINT);
  }

  public static Response getBillingAccountDetails(String SESSIONTOKEN, int EXTRACTEDACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + CREATE_BILLING_ACCOUNT_ENDPOINT);
  }

  public static Response createDealAccountDetails(CreateDealAccountDetails createDealAccountDetails, String SESSIONTOKEN,
                                                  int EXTRACTEDACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(createDealAccountDetails)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .post(CPQ_VERSION_ENDPOINT + CREATE_DEAL_ACCOUNT_ENDPOINT);
  }

  public static Response getDealAccountDetails(String SESSIONTOKEN, int EXTRACTEDACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + CREATE_DEAL_ACCOUNT_ENDPOINT);

  }

  public static Response getDealAccountById(String SESSIONTOKEN, int EXTRACTEDACCOUNTID, int EXTRACTEDDEALACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .pathParam("dealId", EXTRACTEDDEALACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_DEAL_ACCOUNT_BY_ID_ENDPOINT);
  }

  public static Response updateDealAccountName(UpdateDealAccountDetails updateDealAccountDetails, String SESSIONTOKEN,
                                               int EXTRACTEDACCOUNTID, int EXTRACTEDDEALACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(updateDealAccountDetails)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .pathParam("dealId", EXTRACTEDDEALACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .patch(CPQ_VERSION_ENDPOINT + GET_DEAL_ACCOUNT_BY_ID_ENDPOINT);

  }

  public static Response updateAccountDetails(UpdateAccountDetails updateAccountDetails, String SESSIONTOKEN, int EXTRACTEDACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      //.queryParam("companyId", COMPANY_ID)
      .body(updateAccountDetails)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .patch(CPQ_VERSION_ENDPOINT + UPDATE_ACCOUNT_ENDPOINT);
  }

  public static Response addLocationToDeal(AddLocationDetails addLocationDetails, String SESSIONTOKEN, int EXTRACTEDACCOUNTID,
                                           int EXTRACTEDDEALACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(addLocationDetails)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .pathParam("dealId", EXTRACTEDDEALACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .post(CPQ_VERSION_ENDPOINT + POST_LOCATION_ENDPOINT);
  }

  public static Response postCreatePricing(CreatePricingDetails createPricingDetails, String SESSIONTOKEN, int EXTRACTEDACCOUNTID,
                                           int EXTRACTEDDEALACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(createPricingDetails)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .pathParam("dealId", EXTRACTEDDEALACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .post(CPQ_VERSION_ENDPOINT + GET_DEAL_ACCOUNT_BY_ID_ENDPOINT);
  }


  public static Response getLocations(String SESSIONTOKEN, int EXTRACTEDACCOUNTID, int EXTRACTEDDEALACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .pathParam("dealId", EXTRACTEDDEALACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + POST_LOCATION_ENDPOINT);
  }

  public static Response getListOfQuotes(String SESSIONTOKEN, int EXTRACTEDACCOUNTID, int EXTRACTEDDEALACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", EXTRACTEDACCOUNTID)
      .pathParam("deal_id", EXTRACTEDDEALACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_LIST_OF_QUOTES_ENDPOINT);

  }

  public static Response deleteLocation(String SESSIONTOKEN, int EXTRACTEDACCOUNTID, int EXTRACTEDDEALACCOUNTID,
                                        int extracted_location_id) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", EXTRACTEDACCOUNTID)
      .pathParam("deal_id", EXTRACTEDDEALACCOUNTID)
      .pathParam("location_id", extracted_location_id)
      .queryParam("companyId", COMPANY_ID)
      .delete(CPQ_VERSION_ENDPOINT + DELETE_LOCATION_ENDPOINT);

  }

  public static Response getPrices(String SESSIONTOKEN, int EXTRACTED_QUOTE_ID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("quoteId", EXTRACTED_QUOTE_ID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_PRICES_ENDPOINT);
  }

  public static Response getQuotePrice(String SESSIONTOKEN, int EXTRACTEDACCOUNTID, int EXTRACTEDDEALACCOUNTID,
                                       int EXTRACTED_QUOTE_ID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", EXTRACTEDACCOUNTID)
      .pathParam("deal_id", EXTRACTEDDEALACCOUNTID)
      .pathParam("quote_id", EXTRACTED_QUOTE_ID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_QUOTE_PRICE_ENDPOINT);
  }

  public static Response getQuoteConfig(String SESSIONTOKEN, int EXTRACTEDACCOUNTID, int EXTRACTEDDEALACCOUNTID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", EXTRACTEDACCOUNTID)
      .pathParam("dealId", EXTRACTEDDEALACCOUNTID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_QUOTE_CONFIG_ENDPOINT);
  }

  public static Response getSelectedPrice(String SESSIONTOKEN, int EXTRACTED_QUOTE_ID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("quoteId", EXTRACTED_QUOTE_ID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_SELECTED_PRICES_ENDPOINT);
  }

  public static Response createOrder(CreateOrderDetails createOrderDetails, String SESSIONTOKEN, int EXTRACTED_QUOTE_ID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(createOrderDetails)
      .pathParam("quoteId", EXTRACTED_QUOTE_ID)
      .queryParam("companyId", COMPANY_ID)
      .post(CPQ_VERSION_ENDPOINT + CREATE_ORDER_ENDPOINT);
  }

  public static Response deleteDeal(String SESSIONTOKEN, int EXTRACTED_ACCOUNT_ID, int EXTRACTED_DEAL_ID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", EXTRACTED_ACCOUNT_ID)
      .pathParam("deal_id", EXTRACTED_DEAL_ID)
      .queryParam("companyId", COMPANY_ID)
      .delete(CPQ_VERSION_ENDPOINT + DELETE_DEAL_ENDPOINT);
  }

  public static Response deleteAccount(String SESSIONTOKEN, int EXTRACTED_ACCOUNT_ID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", EXTRACTED_ACCOUNT_ID)
      .queryParam("companyId", COMPANY_ID)
      .delete(CPQ_VERSION_ENDPOINT + UPDATE_ACCOUNT_ENDPOINT);
  }

  public static Response getFallOut(String SESSIONTOKEN, int EXTRACTED_QUOTE_ID) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("quoteId", EXTRACTED_QUOTE_ID)
      .queryParam("companyId", COMPANY_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_FALL_OUT_ENDPOINT);
  }

  public static Response getUsersCompanies(String SESSIONTOKEN) {

    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("userId", USER_ID)
      .get(CPQ_VERSION_ENDPOINT + GET_USERS_COMPANIES_ENDPOINT);
  }

}
