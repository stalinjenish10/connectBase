package com.capestart.negativeapilayers;

import com.capestart.apilayers.BaseRequestSpecification;
import com.capestart.factory.ApiConfigFactory;
import com.capestart.pojos.standardaddressv2.PostStandardAddressDetails;
//import com.capestart.pojos.standardaddressv2.PostStandardAddressDetails;
//import com.capestart.pojos.standardaddressv2.PostStandardAddressStringDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressInvalidBodyDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressInvalidInputBodyDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressStringDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressStringInvalidBodyDetails;

import io.restassured.response.Response;

public class StandardAddressV2NegativeService {
	
	private StandardAddressV2NegativeService() {
		
	}

	
	
	
private static final String STANDARD_ADDRESS_GET_ENDPOINT = ApiConfigFactory.getConfig().standardAddressGetCoordsEndpoint();
	
	private static final String STANDARD_ADDRESS_POST_ENDPOINT = ApiConfigFactory.getConfig().standardAddressPostEndpoint();
	
	private static final String STANDARD_ADDRESS_STRING_POST_ENDPOINT = ApiConfigFactory.getConfig().standardAddressStringPostEndpoint();
	
	private static final String LAT_VALUE = ApiConfigFactory.getStandardAddressApiConfig().standardAddressLatValue();
	
	private static final String LON_VALUE = ApiConfigFactory.getStandardAddressApiConfig().standardAddressLonValue();
	
	private static final String INVALID_LAT_VALUE = ApiConfigFactory.getStandardAddressV2NegativeTestApiConfig().getInvalidLat();
	
	private static final String INVALID_LON_VALUE = ApiConfigFactory.getStandardAddressV2NegativeTestApiConfig().getInvalidLon();
	
	private static final String GET_COORDS_INVALID_ENDPOINT = ApiConfigFactory.getStandardAddressV2NegativeTestApiConfig().getCoordsInvalidUrl();
	
	private static final String POST_STANDARD_ADDRESS_INVALID_ENDPOINT = ApiConfigFactory.getStandardAddressV2NegativeTestApiConfig().getPostStandardAddressInvalidUrl();
	
	private static final String POST_STANDARD_ADDRESS_STRING_INVALID_ENDPOINT = ApiConfigFactory.getStandardAddressV2NegativeTestApiConfig().getPostStandardAddressStringInvalidUrl();
	
	public  static Response getCoordsStandardAddressCoordsWithInvalidLat(String SESSIONTOKEN){
        return BaseRequestSpecification.getStandardAddressValidationDefaultRequestSpec(SESSIONTOKEN)
                .queryParam("lat", INVALID_LAT_VALUE)
                .queryParam("lon", LON_VALUE)
                .get(STANDARD_ADDRESS_GET_ENDPOINT);
    }
	
	public  static Response getCoordsStandardAddressCoordsWithInvalidLon(String SESSIONTOKEN){
        return BaseRequestSpecification.getStandardAddressValidationDefaultRequestSpec(SESSIONTOKEN)
                .queryParam("lat", LAT_VALUE)
                .queryParam("lon", INVALID_LON_VALUE)
                .get(STANDARD_ADDRESS_GET_ENDPOINT);
    }
	
	public  static Response getCoordsStandardAddressCoordsWithInvalidHeader(String SESSIONTOKEN){
        return BaseRequestSpecification.getStandardAddressValidationHeaders(SESSIONTOKEN)
                .queryParam("lat", LAT_VALUE)
                .queryParam("lon", LON_VALUE)
                .get(STANDARD_ADDRESS_GET_ENDPOINT);
    }
	
	public  static Response getCoordsStandardAddressCoordsWithInvalidResources(String SESSIONTOKEN){
        return BaseRequestSpecification.getStandardAddressValidationHeaders(SESSIONTOKEN)
                .queryParam("lat", LAT_VALUE)
                .queryParam("lon", LON_VALUE)
                .get(GET_COORDS_INVALID_ENDPOINT);
    }
	
	 public  static Response getPostStandardAddressWithInvalidBody(PostStandardAddressInvalidBodyDetails postStandardAddressDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getStandardAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .body(postStandardAddressDetails)
	                .post(STANDARD_ADDRESS_POST_ENDPOINT);
	    }
	 
	 public  static Response getPostStandardAddressWithInvalidInputBody(PostStandardAddressInvalidInputBodyDetails postStandardAddressDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getStandardAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .body(postStandardAddressDetails)
	                .post(STANDARD_ADDRESS_POST_ENDPOINT);
	    }
	 
	 public  static Response getPostStandardAddressWithInvalidHeader(PostStandardAddressDetails postStandardAddressDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getStandardAddressValidationHeaders(SESSIONTOKEN)
	                .body(postStandardAddressDetails)
	                .post(STANDARD_ADDRESS_POST_ENDPOINT);
	    }
	 
	 public  static Response getPostStandardAddressWithInvalidresources(PostStandardAddressDetails postStandardAddressDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getStandardAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .body(postStandardAddressDetails)
	                .post(POST_STANDARD_ADDRESS_INVALID_ENDPOINT);
	    }
	 
	 
	 public  static Response getPostStandardAddressStringWithInvalidBody(PostStandardAddressStringInvalidBodyDetails postStandardAddressStringDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getStandardAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .body(postStandardAddressStringDetails)
	                .post(STANDARD_ADDRESS_STRING_POST_ENDPOINT);
	    }
	 public  static Response getPostStandardAddressStringWithInvalidHeader(PostStandardAddressStringDetails postStandardAddressStringDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getStandardAddressValidationHeaders(SESSIONTOKEN)
	                .body(postStandardAddressStringDetails)
	                .post(STANDARD_ADDRESS_STRING_POST_ENDPOINT);
	    }
	 public  static Response getPostStandardAddressStringWithInvalidEndpoint(PostStandardAddressStringDetails postStandardAddressStringDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getStandardAddressValidationDefaultRequestSpec(SESSIONTOKEN)
	                .body(postStandardAddressStringDetails)
	                .post(POST_STANDARD_ADDRESS_STRING_INVALID_ENDPOINT);
	    }

}
