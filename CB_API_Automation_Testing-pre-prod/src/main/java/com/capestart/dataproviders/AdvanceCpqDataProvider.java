package com.capestart.dataproviders;

import com.capestart.factory.ApiConfigFactory;
import org.testng.annotations.DataProvider;

public class AdvanceCpqDataProvider {

  private static final String INVALID_DATA = ApiConfigFactory.getCpqNegativeTestApiConfig().getInvalidData();
  private static final String INVALID_DATA_INTEGER = ApiConfigFactory.getCpqNegativeTestApiConfig().getInvalidIntegerData();

  private static final String VALID_COMPANY_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getValidCompanyId();

  private static final String VALID_ACCOUNT_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getValidAccountId();
  private static final String VALID_DEAL_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getValidDealId();

  private static final String VALID_QUOTE_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getValidQuoteId();

  private static final String VALID_LOCATION_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getValidLocationId();

  private static final String OTHER_USER_ACCOUNT_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getOtherUserValidAccountId();

  private static final String OTHER_USER_DEAL_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getOtherUserValidDealId();


  @DataProvider(name = "Invalid Key")
  public static Object[][] testScenarios() {
    // Define test scenarios with parameters
    return new Object[][] {
      {VALID_COMPANY_ID, true}
    };
  }

  @DataProvider(name = "Access Other Users Id")
  public static Object[][] testOtherUserId() {
    // Define test scenarios with parameters
    return new Object[][] {
      {VALID_COMPANY_ID, false}
    };
  }

  @DataProvider(name = "Post Create Account TestData")
  public static Object[][] createAccountTestData() {
    return new Object[][] {
      {INVALID_DATA}
      // {56789}// Invalid COMPANY_ID
    };
  }

  @DataProvider(name = "Post Create Account TestData For 404")
  public static Object[][] createAccountTestData404() {
    return new Object[][] {
      //{ INVALID_DATA }
      {56789}// Invalid COMPANY_ID
    };
  }

  @DataProvider(name = "Post Create Deal TestData")
  public Object[][] createDealTestData() {
    return new Object[][] {
      {VALID_COMPANY_ID, INVALID_DATA},             // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
      {INVALID_DATA, VALID_ACCOUNT_ID}  // Second iteration: "Incorrect data" to COMPANY_ID, 522313 to EXTRACTEDACCOUNTID
    };
  }

  @DataProvider(name = "Account List By Id Invalid Key Data For 401")
  public Object[][] getAccountListByIdInvalidKeyTestData401() {
    return new Object[][] {
      {VALID_COMPANY_ID, OTHER_USER_ACCOUNT_ID, true}          // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
    };
  }

  @DataProvider(name = "Post Create Deal Test Other User Data For 401")
  public Object[][] createDealTestData401() {
    return new Object[][] {
      {VALID_COMPANY_ID, OTHER_USER_ACCOUNT_ID, false}          // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
    };
  }

  @DataProvider(name = "Post Create Deal TestData For 404")
  public Object[][] createDealTestData404() {
    return new Object[][] {
      {VALID_COMPANY_ID, INVALID_DATA_INTEGER},             // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
      {INVALID_DATA_INTEGER, VALID_ACCOUNT_ID}  // Second iteration: "Incorrect data" to COMPANY_ID, 522313 to EXTRACTEDACCOUNTID
    };
  }

  @DataProvider(name = "Post Get Deal By Id TestData")
  public Object[][] getDealByIdTestData() {
    return new Object[][] {
      {VALID_COMPANY_ID, INVALID_DATA, VALID_DEAL_ID},             // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
      {INVALID_DATA, VALID_ACCOUNT_ID, VALID_DEAL_ID},
      // Second iteration: "Incorrect data" to COMPANY_ID, 522313 to EXTRACTEDACCOUNTID
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, INVALID_DATA}
    };
  }

  @DataProvider(name = "Post Get Locations Invalid Key Test Data For 401")
  public Object[][] getLocationsTestData401() {
    return new Object[][] {
      {VALID_COMPANY_ID, OTHER_USER_ACCOUNT_ID, OTHER_USER_DEAL_ID, true}
    };
  }


  @DataProvider(name = "Post Get Locations Others User Test Data For 401")
  public Object[][] getDealByIdTestData401() {
    return new Object[][] {
      {VALID_COMPANY_ID, OTHER_USER_ACCOUNT_ID, OTHER_USER_DEAL_ID, false}
    };
  }

  @DataProvider(name = "Post Get Deal By Id TestData For 404")
  public Object[][] getDealByIdTestData404() {
    return new Object[][] {
      {VALID_COMPANY_ID, INVALID_DATA_INTEGER, VALID_DEAL_ID},
      // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
      {INVALID_DATA_INTEGER, VALID_ACCOUNT_ID, VALID_DEAL_ID},
      // Second iteration: "Incorrect data" to COMPANY_ID, 522313 to EXTRACTEDACCOUNTID
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, INVALID_DATA_INTEGER}
    };
  }

  @DataProvider(name = "Patch DeleteLocation TestData")
  public Object[][] getDeleteLocation() {
    return new Object[][] {
      {VALID_COMPANY_ID, INVALID_DATA, VALID_DEAL_ID, VALID_LOCATION_ID},
      // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
      {INVALID_DATA, VALID_ACCOUNT_ID, VALID_DEAL_ID, VALID_LOCATION_ID},
      // Second iteration: "Incorrect data" to COMPANY_ID, 522313 to EXTRACTEDACCOUNTID
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, INVALID_DATA, VALID_LOCATION_ID},
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, VALID_DEAL_ID, INVALID_DATA}
    };
  }

  @DataProvider(name = "Patch DeleteLocation TestData For 404")
  public Object[][] getDeleteLocation404() {
    return new Object[][] {
      {VALID_COMPANY_ID, INVALID_DATA_INTEGER, VALID_DEAL_ID, VALID_LOCATION_ID},
      // First iteration: 900 to COMPANY_ID, "qwert" to EXTRACTEDACCOUNTID
      {INVALID_DATA_INTEGER, VALID_ACCOUNT_ID, VALID_DEAL_ID, VALID_LOCATION_ID},
      // Second iteration: "Incorrect data" to COMPANY_ID, 522313 to EXTRACTEDACCOUNTID
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, INVALID_DATA_INTEGER, VALID_LOCATION_ID},
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, VALID_DEAL_ID, INVALID_DATA_INTEGER}
    };
  }

  @DataProvider(name = "Get Prices TestData")
  public static Object[][] GetPricesTestData() {
    return new Object[][] {
      {INVALID_DATA, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, INVALID_DATA}// Invalid COMPANY_ID
    };
  }

  @DataProvider(name = "Get Prices TestData For 404")
  public static Object[][] GetPricesTestData404() {
    return new Object[][] {
      {INVALID_DATA_INTEGER, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, INVALID_DATA_INTEGER}// Invalid COMPANY_ID
    };
  }

  @DataProvider(name = "Get Quote Prices TestData")
  public static Object[][] GetQuotePricesTestData() {
    return new Object[][] {
      {INVALID_DATA, VALID_ACCOUNT_ID, VALID_DEAL_ID, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, INVALID_DATA, VALID_DEAL_ID, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, INVALID_DATA, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, VALID_DEAL_ID, INVALID_DATA}
    };
  }

  @DataProvider(name = "Get Quote Prices TestData For 404")
  public static Object[][] GetQuotePricesTestData404() {
    return new Object[][] {
      {INVALID_DATA_INTEGER, VALID_ACCOUNT_ID, VALID_DEAL_ID, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, INVALID_DATA_INTEGER, VALID_DEAL_ID, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, INVALID_DATA_INTEGER, VALID_QUOTE_ID},
      {VALID_COMPANY_ID, VALID_ACCOUNT_ID, VALID_DEAL_ID, INVALID_DATA_INTEGER}
    };
  }
}