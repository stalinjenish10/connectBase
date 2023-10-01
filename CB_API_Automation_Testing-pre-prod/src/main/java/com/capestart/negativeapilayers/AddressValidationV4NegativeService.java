package com.capestart.negativeapilayers;

import com.capestart.apilayers.BaseRequestSpecification;
import com.capestart.factory.ApiConfigFactory;

import io.restassured.response.Response;

public class AddressValidationV4NegativeService {
	
	private AddressValidationV4NegativeService() {
		
	}
	
	
private static final String ADDRESS_VALIDATION_ENDPOINT = ApiConfigFactory.getAddressValidationApiConfig().addressValidationVersionEndpoint();
	
	public static final String INVALID_ADDRESS = ApiConfigFactory.getAddressValidationNegativeTestApiConfig().getInvalidAddress();
	
	public static final String ADDRESS_VALIDATION_ADDRESS2 = ApiConfigFactory.getAddressValidationApiConfig().getAddressValidationAddress2();
	
	public static final String INVALID_ENDPOINT = ApiConfigFactory.getAddressValidationNegativeTestApiConfig().getInvalidUrl();
	
	
	
	 public  static Response getAddressValidationWithInvalidData(String SESSIONTOKEN){
	        return BaseRequestSpecification.getAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("address", INVALID_ADDRESS)
	                .get(ADDRESS_VALIDATION_ENDPOINT);
	    }
	 
	 public  static Response getAddressValidationWithInvalidHeader(String SESSIONTOKEN){
	        return BaseRequestSpecification.getAddressValidationHeaders(SESSIONTOKEN)
	                .queryParam("address", INVALID_ADDRESS)
	                .get(ADDRESS_VALIDATION_ENDPOINT);
	    }

	 public  static Response getAddressValidationWithInvalidResources(String SESSIONTOKEN){
	        return BaseRequestSpecification.getAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("address", INVALID_ADDRESS)
	                .get(INVALID_ENDPOINT);
	    }

}
