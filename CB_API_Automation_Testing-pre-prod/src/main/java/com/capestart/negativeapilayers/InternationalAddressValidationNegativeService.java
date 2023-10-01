package com.capestart.negativeapilayers;

import com.capestart.apilayers.BaseRequestSpecification;
import com.capestart.factory.ApiConfigFactory;

import io.restassured.response.Response;

public class InternationalAddressValidationNegativeService {

	private InternationalAddressValidationNegativeService() {
		
	}
	
	
	
	
private static final String INTERNATIONAL_ADDRESS_VALIDATION_ENDPOINT = ApiConfigFactory.getInternationalAddressValidationApiConfig().internationalAddressValidationVersionEndpoint();

private static final String INTERNATIONAL_ADDRESS_INVALID_ENDPOINT = ApiConfigFactory.getInternationalAddressNegativeTestApiConfig().getInvalidUrl();

private static final String INTERNATIONAL_ADDRESS_INVALID_COUNTRY = ApiConfigFactory.getInternationalAddressNegativeTestApiConfig().getInvalidCountry();

private static final String INTERNATIONAL_ADDRESS_INVALID_ADDRESS = ApiConfigFactory.getInternationalAddressNegativeTestApiConfig().getInvalidAddress();
	
	public static final String INTERNATIONAL_ADDRESS = ApiConfigFactory.getInternationalAddressValidationApiConfig().internationalAddress();
	
	public static final String INTERNATIONAL_COUNTRY = ApiConfigFactory.getInternationalAddressValidationApiConfig().internationalCountry();
	
	
	 public  static Response getInternationalAddressWithoutQueryParam(String SESSIONTOKEN){
	        return BaseRequestSpecification.getInternationalAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("address", INTERNATIONAL_ADDRESS)
	                .get(INTERNATIONAL_ADDRESS_VALIDATION_ENDPOINT);
	    }

	 public  static Response getInternationalAddressWithInvalidHeader(String SESSIONTOKEN){
	        return BaseRequestSpecification.getInternationalAddressValidationHeaders(SESSIONTOKEN)
	                .queryParam("address", INTERNATIONAL_ADDRESS)
	                .queryParam("country", INTERNATIONAL_COUNTRY)
	                .get(INTERNATIONAL_ADDRESS_VALIDATION_ENDPOINT);
	    }
	 
	 public  static Response getInternationalAddressWithInvalidAddress(String SESSIONTOKEN){
	        return BaseRequestSpecification.getInternationalAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("address", INTERNATIONAL_ADDRESS_INVALID_ADDRESS)
	                .queryParam("country", INTERNATIONAL_ADDRESS_INVALID_COUNTRY)
	                .get(INTERNATIONAL_ADDRESS_VALIDATION_ENDPOINT);
	    }
	 
	 public  static Response getInternationalAddressWithInvalidResources(String SESSIONTOKEN){
	        return BaseRequestSpecification.getInternationalAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("address", INTERNATIONAL_ADDRESS)
	                .queryParam("country", INTERNATIONAL_COUNTRY)
	                .get(INTERNATIONAL_ADDRESS_INVALID_ENDPOINT);
	    }

}
