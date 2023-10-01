package com.capestart.negativeapilayers;

import com.capestart.apilayers.BaseRequestSpecification;
import com.capestart.factory.ApiConfigFactory;
import com.capestart.pojos.advancecpqv2.*;
import com.capestart.pojos.login.LoginResponseDetails;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public final class AdvanceCpqV2NegativeService {

  private AdvanceCpqV2NegativeService() {
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

  private static final String OTHER_USER_CPQ_OCP_KEY = ApiConfigFactory.getCpqNegativeTestApiConfig().getOtherUserCpqOcpKey();

  private static final String INVALID_OCP_KEY = ApiConfigFactory.getCpqNegativeTestApiConfig().getGeneralInvalidOcpKey();

  private static final String COMPANY_ID = ApiConfigFactory.getConfig().companyId();
  static int USER_ID = LoginResponseDetails.User.id;


  public static Response postCreateAccount(CreateAccountDetails createAccountDetails, String SESSIONTOKEN, Object specificCompanyId,
                                           Boolean isPositive, boolean b) {
    if (isPositive) {
      return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
        .queryParam("companyId", specificCompanyId)
        .body(createAccountDetails)
        .post(CPQ_VERSION_ENDPOINT + CREATE_ACCOUNT_ENDPOINT);
    } else {
      if (b) {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .queryParam("companyId", COMPANY_ID)
          .body(createAccountDetails)
          .post(CPQ_VERSION_ENDPOINT + CREATE_ACCOUNT_ENDPOINT);
      } else {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .queryParam("companyId", COMPANY_ID)
          .body(createAccountDetails)
          .post(CPQ_VERSION_ENDPOINT + CREATE_ACCOUNT_ENDPOINT);
      }
    }

  }

  public static Response getAccountsList(String SESSIONTOKEN, Object companyId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("companyId", companyId)
      .get(CPQ_VERSION_ENDPOINT + CREATE_ACCOUNT_ENDPOINT);
  }

  public static Response getAccountListById(String SESSIONTOKEN, Object companyId, Object accountId, Boolean isPositive, boolean b) {
    if (isPositive) {
      return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
        .pathParam("account_id", accountId)
        .queryParam("companyId", companyId)
        .get(CPQ_VERSION_ENDPOINT + ACCOUNT_ID_ENDPOINT);
    } else {
      if (b) {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("account_id", accountId)
          .queryParam("companyId", COMPANY_ID)
          .get(CPQ_VERSION_ENDPOINT + ACCOUNT_ID_ENDPOINT);
      } else {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("account_id", accountId)
          .queryParam("companyId", COMPANY_ID)
          .get(CPQ_VERSION_ENDPOINT + ACCOUNT_ID_ENDPOINT);
      }
    }
  }

  public static Response createBillingAccount(CreateBillingAccountDetails createBillingAccountDetails, String SESSIONTOKEN,
                                              Object companyId, Object accountId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(createBillingAccountDetails)
      .pathParam("accountId", accountId)
      .queryParam("companyId", companyId)
      .post(CPQ_VERSION_ENDPOINT + CREATE_BILLING_ACCOUNT_ENDPOINT);
  }

  public static Response getBillingAccountDetails(String SESSIONTOKEN, Object companyId, Object accountId, Boolean isPositive,
                                                  boolean b) {
    if (isPositive) {
      return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
        .pathParam("accountId", accountId)
        .queryParam("companyId", companyId)
        .get(CPQ_VERSION_ENDPOINT + CREATE_BILLING_ACCOUNT_ENDPOINT);
    } else {
      if (b) {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("accountId", accountId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + CREATE_BILLING_ACCOUNT_ENDPOINT);
      } else {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("accountId", accountId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + CREATE_BILLING_ACCOUNT_ENDPOINT);
      }
    }
  }

  public static Response createDealAccountDetails(CreateDealAccountDetails createDealAccountDetails, String SESSIONTOKEN,
                                                  Object companyId, Object extractedAccountId) {
    RequestSpecification requestSpec = BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN);

    requestSpec.queryParam("companyId", companyId);
    requestSpec.pathParam("accountId", extractedAccountId);

    return requestSpec
      .body(createDealAccountDetails)
      .post(CPQ_VERSION_ENDPOINT + CREATE_DEAL_ACCOUNT_ENDPOINT);
  }

  public static Response getDealAccountDetails(String SESSIONTOKEN, Object companyId, Object AccountId, Boolean isPositive, boolean b) {
    if (isPositive) {
      return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
        .pathParam("accountId", AccountId)
        .queryParam("companyId", companyId)
        .get(CPQ_VERSION_ENDPOINT + CREATE_DEAL_ACCOUNT_ENDPOINT);
    } else {
      if (b) {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("accountId", AccountId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + CREATE_DEAL_ACCOUNT_ENDPOINT);
      } else {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("accountId", AccountId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + CREATE_DEAL_ACCOUNT_ENDPOINT);
      }
    }
  }

  public static Response getDealAccountById(String SESSIONTOKEN, Object companyId, Object accountId, Object dealId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", accountId)
      .pathParam("dealId", dealId)
      .queryParam("companyId", companyId)
      .get(CPQ_VERSION_ENDPOINT + GET_DEAL_ACCOUNT_BY_ID_ENDPOINT);
  }

  public static Response updateDealAccountName(UpdateDealAccountDetails updateDealAccountDetails, String SESSIONTOKEN, Object companyId,
                                               Object accountId, Object dealId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(updateDealAccountDetails)
      .pathParam("accountId", accountId)
      .pathParam("dealId", dealId)
      .queryParam("companyId", companyId)
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

  public static Response addLocationToDeal(AddLocationDetails addLocationDetails, String SESSIONTOKEN, Object companyId,
                                           Object accountId, Object dealId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(addLocationDetails)
      .pathParam("accountId", accountId)
      .pathParam("dealId", dealId)
      .queryParam("companyId", companyId)
      .post(CPQ_VERSION_ENDPOINT + POST_LOCATION_ENDPOINT);
  }

  public static Response postCreatePricing(CreatePricingDetails createPricingDetails, String SESSIONTOKEN, Object companyId,
                                           Object accountId, Object dealId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(createPricingDetails)
      .pathParam("accountId", accountId)
      .pathParam("dealId", dealId)
      .queryParam("companyId", companyId)
      .post(CPQ_VERSION_ENDPOINT + GET_DEAL_ACCOUNT_BY_ID_ENDPOINT);
  }


  public static Response getLocations(String SESSIONTOKEN, Object companyId, Object accountId, Object dealId, Boolean isPositive,
                                      boolean b) {
    if (isPositive) {
      return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
        .pathParam("accountId", accountId)
        .pathParam("dealId", dealId)
        .queryParam("companyId", companyId)
        .get(CPQ_VERSION_ENDPOINT + POST_LOCATION_ENDPOINT);
    } else {
      if (b) {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("accountId", accountId)
          .pathParam("dealId", dealId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + POST_LOCATION_ENDPOINT);
      } else {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("accountId", accountId)
          .pathParam("dealId", dealId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + POST_LOCATION_ENDPOINT);
      }
    }
  }

  public static Response getListOfQuotes(String SESSIONTOKEN, Object companyId, Object accountId, Object dealId, Boolean isPositive,
                                         boolean b) {
    if (isPositive) {
      return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
        .pathParam("account_id", accountId)
        .pathParam("deal_id", dealId)
        .queryParam("companyId", companyId)
        .get(CPQ_VERSION_ENDPOINT + GET_LIST_OF_QUOTES_ENDPOINT);

    } else {
      if (b) {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("account_id", accountId)
          .pathParam("deal_id", dealId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + GET_LIST_OF_QUOTES_ENDPOINT);
      } else {
        return BaseRequestSpecification.getHeader(SESSIONTOKEN, b)
          .pathParam("account_id", accountId)
          .pathParam("deal_id", dealId)
          .queryParam("companyId", companyId)
          .get(CPQ_VERSION_ENDPOINT + GET_LIST_OF_QUOTES_ENDPOINT);
      }
    }
  }

  public static Response deleteLocation(String SESSIONTOKEN, Object companyId, Object accountId, Object dealId, Object locationId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", accountId)
      .pathParam("deal_id", dealId)
      .pathParam("location_id", locationId)
      .queryParam("companyId", companyId)
      .delete(CPQ_VERSION_ENDPOINT + DELETE_LOCATION_ENDPOINT);

  }

  public static Response getPrices(String SESSIONTOKEN, Object companyId, Object QuoteId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("quoteId", QuoteId)
      .queryParam("companyId", companyId)
      .get(CPQ_VERSION_ENDPOINT + GET_PRICES_ENDPOINT);
  }

  public static Response getQuotePrice(String SESSIONTOKEN, Object companyId, Object accountId, Object dealId, Object quoteId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", accountId)
      .pathParam("deal_id", dealId)
      .pathParam("quote_id", quoteId)
      .queryParam("companyId", companyId)
      .get(CPQ_VERSION_ENDPOINT + GET_QUOTE_PRICE_ENDPOINT);
  }

  public static Response getQuoteConfig(String SESSIONTOKEN, Object companyId, Object accountId, Object dealId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", accountId)
      .pathParam("dealId", dealId)
      .queryParam("companyId", companyId)
      .get(CPQ_VERSION_ENDPOINT + GET_QUOTE_CONFIG_ENDPOINT);
  }

  public static Response getSelectedPrice(String SESSIONTOKEN, Object companyId, Object quoteId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("quoteId", quoteId)
      .queryParam("companyId", companyId)
      .get(CPQ_VERSION_ENDPOINT + GET_SELECTED_PRICES_ENDPOINT);
  }

  public static Response createOrder(CreateOrderDetails createOrderDetails, String SESSIONTOKEN, Object companyId, Object quoteId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .body(createOrderDetails)
      .pathParam("quoteId", quoteId)
      .queryParam("companyId", companyId)
      .post(CPQ_VERSION_ENDPOINT + CREATE_ORDER_ENDPOINT);
  }

  public static Response deleteDeal(String SESSIONTOKEN, Object companyId, Object accountId, Object dealId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("account_id", accountId)
      .pathParam("deal_id", dealId)
      .queryParam("companyId", companyId)
      .delete(CPQ_VERSION_ENDPOINT + DELETE_DEAL_ENDPOINT);
  }

  public static Response deleteAccount(String SESSIONTOKEN, Object companyId, Object accountId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("accountId", accountId)
      .queryParam("companyId", companyId)
      .delete(CPQ_VERSION_ENDPOINT + UPDATE_ACCOUNT_ENDPOINT);
  }

  public static Response getFallOut(String SESSIONTOKEN, Object companyId, Object quoteId) {
    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("quoteId", quoteId)
      .queryParam("companyId", companyId)
      .get(CPQ_VERSION_ENDPOINT + GET_FALL_OUT_ENDPOINT);
  }

  public static Response getUsersCompanies(String SESSIONTOKEN, Object userId) {

    return BaseRequestSpecification.getCpqDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("userId", userId)
      .get(CPQ_VERSION_ENDPOINT + GET_USERS_COMPANIES_ENDPOINT);
  }

}
