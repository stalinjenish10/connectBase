package com.capestart.apilayers;

import com.capestart.factory.ApiConfigFactory;

import io.restassured.response.Response;

public class AddressValidationV4Service {
	
	public AddressValidationV4Service() {}
	
	private static final String ADDRESS_VALIDATION_ENDPOINT = ApiConfigFactory.getAddressValidationApiConfig().addressValidationVersionEndpoint();
	
	public static final String ADDRESS_VALIDATION_ADDRESS1 = ApiConfigFactory.getAddressValidationApiConfig().getAddressValidationAddress1();
	
	public static final String ADDRESS_VALIDATION_ADDRESS2 = ApiConfigFactory.getAddressValidationApiConfig().getAddressValidationAddress2();
	
	
	
	 public  static Response getAddressValidationWithSingleAddress(String SESSIONTOKEN){
	        return BaseRequestSpecification.getAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("address", ADDRESS_VALIDATION_ADDRESS1)
	                .get(ADDRESS_VALIDATION_ENDPOINT);
	    }
	 

	 public  static Response getAddressValidationWithTwoAddress(String SESSIONTOKEN){
	        return BaseRequestSpecification.getAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("address", ADDRESS_VALIDATION_ADDRESS1)
	                .queryParam("address2", ADDRESS_VALIDATION_ADDRESS2)
	                .get(ADDRESS_VALIDATION_ENDPOINT);
	    }
	
	

}
