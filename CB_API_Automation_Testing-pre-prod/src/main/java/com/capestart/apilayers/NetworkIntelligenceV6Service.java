package com.capestart.apilayers;

import com.capestart.factory.ApiConfigFactory;
import com.capestart.pojos.networkintelligence.SetupData;
import io.restassured.response.Response;

public class NetworkIntelligenceV6Service {
  private NetworkIntelligenceV6Service() {
  }

  private static final String GET_ALL_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getAllEndPoint();

  private static final String GET_BROADBAND_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getBroadbandEndPoint();

  private static final String POST_BULK_ADDRESS_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getPostBulkAddressEndPoint();

  private static final String GET_BULK_ADDRESS_CALLBACK_ENDPOINT =
    ApiConfigFactory.getNetworkIntelligenceConfig().getBulkAddressCallBack();

  private static final String GET_CAB_LECO_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getCabLecoEndPoint();

  private static final String GET_CONFORMED_PROVIDER_ENDPOINT =
    ApiConfigFactory.getNetworkIntelligenceConfig().getConformedProviderEndPoint();

  private static final String GET_BUILDING_PROVIDERS_BY_ADDRESS_ENDPOINT =
    ApiConfigFactory.getNetworkIntelligenceConfig().getBuildingProvidersByAddressEndPoint();

  private static final String GET_NEAR_NET_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getNearNetEndPoint();

  private static final String GET_ON_NET_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getOnNetEndPoint();

  private static final String GET_TELCO_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getTelcoEndPoint();

  private static final String GET_WISP_ENDPOINT = ApiConfigFactory.getNetworkIntelligenceConfig().getWispEndPoint();

  private static final String NETWORK_INTELLIGENCE_VERSION_ENDPOINT =
    ApiConfigFactory.getNetworkIntelligenceConfig().getNetworkIntelligenceVersionEndPoint();

  private static final String COMPANY_ID = ApiConfigFactory.getConfig().companyId();

  public static String ADDRESS_PATH_PARAMETER = ApiConfigFactory.getNetworkIntelligenceConfig().getPathParameterAddressForInput();


  private static final String LATITUDE_VALUE = ApiConfigFactory.getNetworkIntelligenceConfig().getLatitudeValue();

  private static final String LONGITUDE_VALUE = ApiConfigFactory.getNetworkIntelligenceConfig().getLongitudeValue();

  private static final String QUERY_PARAMETER_VALUE = ApiConfigFactory.getNetworkIntelligenceConfig().getQueryParameterValue();

  private static final String PATH_PARAMETER_ADDRESS_VALUE =
    ApiConfigFactory.getNetworkIntelligenceConfig().getPathParameterAddressForInput();


  private static final String POSITIVE_VALIDATION = ApiConfigFactory.getNetworkIntelligenceConfig().getPositiveValidation();

  public static Response getAll(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("lat", LATITUDE_VALUE)
      .queryParam("lon", LONGITUDE_VALUE)
      .queryParam("validation", POSITIVE_VALIDATION)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_ALL_ENDPOINT);
  }

  public static Response getBroadBand(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("lat", LATITUDE_VALUE)
      .queryParam("lon", LONGITUDE_VALUE)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_BROADBAND_ENDPOINT);
  }

  public static Response getPostBulkAddress(String SESSIONTOKEN) {
    SetupData req_data = new SetupData();
    String payload = req_data.getBulkAddress();
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .body(payload)
      .queryParam("companyId", COMPANY_ID)
      .post(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + POST_BULK_ADDRESS_ENDPOINT);
  }

  public static Response getBulkAddressCallBack(String SESSIONTOKEN, String extractedRequestId) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("requestId", extractedRequestId)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_BULK_ADDRESS_CALLBACK_ENDPOINT);
  }

  public static Response getCabLeco(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("lat", LATITUDE_VALUE)
      .queryParam("lon", LONGITUDE_VALUE)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_CAB_LECO_ENDPOINT);
  }

  public static Response getConformedProvider(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("name", QUERY_PARAMETER_VALUE)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_CONFORMED_PROVIDER_ENDPOINT);
  }

  public static Response getBuildingProviders(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("companyid", COMPANY_ID)
      .queryParam("address", ADDRESS_PATH_PARAMETER)
      .queryParam("validation", POSITIVE_VALIDATION)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT);
  }

  public static Response getBuildingProvidersByAddress(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .pathParam("address", PATH_PARAMETER_ADDRESS_VALUE)
      .queryParam("companyid", COMPANY_ID)
      .queryParam("validation", POSITIVE_VALIDATION)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_BUILDING_PROVIDERS_BY_ADDRESS_ENDPOINT);
  }

  public static Response getNearNet(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("companyId", COMPANY_ID)
      .queryParam("lat", LATITUDE_VALUE)
      .queryParam("lon", LONGITUDE_VALUE)
      .queryParam("validation", POSITIVE_VALIDATION)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_NEAR_NET_ENDPOINT);
  }

  public static Response getOnNet(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("companyId", COMPANY_ID)
      .queryParam("lat", LATITUDE_VALUE)
      .queryParam("lon", LONGITUDE_VALUE)
      .queryParam("validation", POSITIVE_VALIDATION)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_ON_NET_ENDPOINT);
  }

  public static Response getTelco(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("lat", LATITUDE_VALUE)
      .queryParam("lon", LONGITUDE_VALUE)
      .queryParam("validation", POSITIVE_VALIDATION)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_TELCO_ENDPOINT);
  }

  public static Response getWisp(String SESSIONTOKEN) {
    return BaseRequestSpecification.getNetworkIntelligenceDefaultRequestSpec(SESSIONTOKEN)
      .queryParam("lat", LATITUDE_VALUE)
      .queryParam("lon", LONGITUDE_VALUE)
      .queryParam("validation", POSITIVE_VALIDATION)
      .get(NETWORK_INTELLIGENCE_VERSION_ENDPOINT + GET_WISP_ENDPOINT);
  }
}
