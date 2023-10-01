package com.capestart.dataproviders;

import com.capestart.factory.ApiConfigFactory;
import org.testng.annotations.DataProvider;

public class NetworkIntelligenceV6DataProvider {
  private static final String INVALID_DATA_STRING = ApiConfigFactory.getCpqNegativeTestApiConfig().getInvalidData();
  private static final String INVALID_DATA_INTEGER = ApiConfigFactory.getCpqNegativeTestApiConfig().getInvalidIntegerData();
  private static final String VALID_LONGT_ID = ApiConfigFactory.getNetworkIntelligenceNegativeTestApiConfig().getValidLongitudeValue();
  private static final String VALID_VALIDATION_TYPE =
    ApiConfigFactory.getNetworkIntelligenceNegativeTestApiConfig().getValidValidationType();
  private static final String VALID_COMPANY_ID = ApiConfigFactory.getCpqNegativeTestApiConfig().getValidCompanyId();

  public static String VALID_ADDRESS_PATH_PARAMETER = ApiConfigFactory.getNetworkIntelligenceConfig().getPathParameterAddressForInput();

  private static final String VALID_LAT_ID = ApiConfigFactory.getNetworkIntelligenceNegativeTestApiConfig().getValidLatitudeValue();

  @DataProvider(name = "Get All Test Data")
  public static Object[][] getAll() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_STRING, VALID_LONGT_ID, VALID_VALIDATION_TYPE},
      {VALID_LAT_ID, INVALID_DATA_STRING, VALID_VALIDATION_TYPE},
      {VALID_LAT_ID, VALID_LONGT_ID, INVALID_DATA_STRING},

    };
  }

  @DataProvider(name = "Get All Test Data For 404")
  public static Object[][] getAll404() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_INTEGER, VALID_LONGT_ID, VALID_VALIDATION_TYPE},
      {VALID_LAT_ID, INVALID_DATA_INTEGER, VALID_VALIDATION_TYPE},
      {VALID_LAT_ID, VALID_LONGT_ID, INVALID_DATA_INTEGER},

    };
  }

  @DataProvider(name = "Get Broad Band Test Data")
  public static Object[][] getBroadBand() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_STRING, VALID_LONGT_ID},
      {VALID_LAT_ID, INVALID_DATA_STRING}
    };
  }

  @DataProvider(name = "Get Broad Band Test Data For 404")
  public static Object[][] getBroadBand404() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_INTEGER, VALID_LONGT_ID},
      {VALID_LAT_ID, INVALID_DATA_INTEGER}
    };
  }

  @DataProvider(name = "Post Bulk Address Test Data")
  public static Object[][] getPostBulkAddress() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_STRING}
    };
  }

  @DataProvider(name = "Post Bulk Address Test Data For 404")
  public static Object[][] getPostBulkAddress404() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_INTEGER}
    };
  }

  @DataProvider(name = "Get Building Provider Test Data")
  public static Object[][] getBuildingProvider() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_STRING, VALID_ADDRESS_PATH_PARAMETER, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, VALID_ADDRESS_PATH_PARAMETER, INVALID_DATA_STRING}
    };
  }

  @DataProvider(name = "Get Building Provider Test Data For 404")
  public static Object[][] getBuildingProvider404() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_INTEGER, VALID_ADDRESS_PATH_PARAMETER, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, INVALID_DATA_INTEGER, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, VALID_ADDRESS_PATH_PARAMETER, INVALID_DATA_INTEGER}

    };
  }

  @DataProvider(name = "Get Near Net Test Data")
  public static Object[][] getNearNet() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_STRING, VALID_LAT_ID, VALID_LONGT_ID, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, INVALID_DATA_STRING, VALID_LONGT_ID, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, VALID_LAT_ID, INVALID_DATA_STRING, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, VALID_LAT_ID, VALID_LONGT_ID, INVALID_DATA_STRING}
    };
  }

  @DataProvider(name = "Get Near Net Test Data For 404")
  public static Object[][] getNearNet404() {
    // Define test scenarios with parameters
    return new Object[][] {
      {INVALID_DATA_INTEGER, VALID_LAT_ID, VALID_LONGT_ID, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, INVALID_DATA_INTEGER, VALID_LONGT_ID, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, VALID_LAT_ID, INVALID_DATA_INTEGER, VALID_VALIDATION_TYPE},
      {VALID_COMPANY_ID, VALID_LAT_ID, VALID_LONGT_ID, INVALID_DATA_INTEGER}
    };
  }

}
