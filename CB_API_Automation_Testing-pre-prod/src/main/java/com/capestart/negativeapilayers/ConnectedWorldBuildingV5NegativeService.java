package com.capestart.negativeapilayers;

import com.capestart.apilayers.BaseRequestSpecification;
import com.capestart.factory.ApiConfigFactory;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingForDeleteDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingForDeleteMultipleBuildings;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingWithInvalidBodyDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingWithInvalidInputDetails;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingInvalidInputDetails;
import com.capestart.pojos.connectedworldbuildingv5.PutUpdateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.PutUpdateBuildingInvalidInputDetails;

import io.restassured.response.Response;

public class ConnectedWorldBuildingV5NegativeService {

	private ConnectedWorldBuildingV5NegativeService() {
		
	}
	
	private static final String CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldBuildingVersionEndpoint();
	
	private static final String CONNECTED_WORLD_GETBUILDING__ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldGetBuildingEndpoint();
	
	private static final String CONNECTED_WORLD_BUILDING_PATCH_UPDATE_ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldtBuildingPatchUpdateEndpoint();
	
	private static final String CONNECTED_WORLD_BUILDING_PUT_UPDATE_ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldtBuildingPutUpdateEndpoint();
	
	private static final String CONNECTED_WORLD_BUILDING_ADDRESS_COMPONENT_ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldBuildingAddressComponentEndpoint();
	
	private static final String CONNECTED_WORLD_BUILDING_CUSTOM_FIELDS_ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldBuildingCustomFieldsEndpoint();
	
	 private  static  final  String COMPANY_ID = ApiConfigFactory.getConfig().companyId();
	 
	 private static final String PAGE = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldtBuildingPageValue();
	 
	 private static final String SIZE = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldtBuildingSizeValue();
	 
	 private static final String RADIUS = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldtBuildingRadiusValue();
	 
	 private static final String CITY = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldtBuildingCityValue();
	 
	 private static final String CONNECTED_WORLD_DELETE_BUILDING_ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingConfig().connectedWorldDeleteBuildingEndpoint();
	 
	 private static final String INVALID_ENDPOINT = ApiConfigFactory.getConnectedWorldBuildingNegativeTestConfig().getInvalidUrl();
	 
	 public static final String UNIQUEKEY = ApiConfigFactory.getConfig().getValidUniqueKey();
	 
	 public static final String INVALID_UNIQUEKEY = ApiConfigFactory.getConnectedWorldBuildingNegativeTestConfig().getInvalidUniqueKey();
	 
	 public static final String INVALID_COMPANY_ID = ApiConfigFactory.getConnectedWorldBuildingNegativeTestConfig().getInvalidCompanyId(); 
	 
	 public  static Response getPostCreateAccountInvalidHeader(CreateBuildingDetails createBuildingDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .body(createBuildingDetails)
	                .post(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getPostCreateAccountInvalidEndpoint(CreateBuildingDetails createBuildingDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .body(createBuildingDetails)
	                .post(INVALID_ENDPOINT);
	    }
	 public  static Response getPostCreateAccountInvalidBody(CreateBuildingWithInvalidBodyDetails createBuildingWithInvalidBodyDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .body(createBuildingWithInvalidBodyDetails)
	                .post(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getPostCreateAccountInputDetails(CreateBuildingWithInvalidInputDetails createBuildingWithInvalidInputDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .body(createBuildingWithInvalidInputDetails)
	                .post(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getPostCreateAccountForDeleteBuilding(CreateBuildingForDeleteDetails createBuildingForDeleteDetails, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .body(createBuildingForDeleteDetails)
	                .post(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getPostCreateAccountForDeleteMultipleBuildings(CreateBuildingForDeleteMultipleBuildings createBuildingDeleteMultipleBuildings, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .body(createBuildingDeleteMultipleBuildings)
	                .post(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getGetBuildingInvalidData(String UNIQUEKEY, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .get(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_GETBUILDING__ENDPOINT );
	    }
	 public  static Response getGetBuildingInvalidHeader(String UNIQUEKEY, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .get(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_GETBUILDING__ENDPOINT );
	    }
	 
	 public  static Response getGetBuildingInvalidEndpoint(String UNIQUEKEY, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .get(INVALID_ENDPOINT + CONNECTED_WORLD_GETBUILDING__ENDPOINT );
	    }
	 
	 public  static Response getPatchUpdateBuildingInvalidInputDetails(PatchUpdateBuildingInvalidInputDetails patchUpdateBuildingDetails, String SESSIONTOKEN,String UNIQUEKEY){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .body(patchUpdateBuildingDetails)
	                .patch(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_BUILDING_PATCH_UPDATE_ENDPOINT);
	    }
	 
	 public  static Response getPatchUpdateBuildingInvalidOcpKey(PatchUpdateBuildingDetails patchUpdateBuildingDetails, String SESSIONTOKEN,String UNIQUEKEY){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .body(patchUpdateBuildingDetails)
	                .patch(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_BUILDING_PATCH_UPDATE_ENDPOINT);
	    }
	 public  static Response getPatchUpdateBuildingInvalidEndpoint(PatchUpdateBuildingDetails patchUpdateBuildingDetails, String SESSIONTOKEN,String UNIQUEKEY){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .body(patchUpdateBuildingDetails)
	                .patch(INVALID_ENDPOINT + CONNECTED_WORLD_BUILDING_PATCH_UPDATE_ENDPOINT);
	    }
	 
	 
	 public  static Response getPutUpdateBuildingInvalidInput(PutUpdateBuildingInvalidInputDetails putUpdateBuildingDetails, String SESSIONTOKEN,String UNIQUEKEY){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .body(putUpdateBuildingDetails)
	                .put(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_BUILDING_PUT_UPDATE_ENDPOINT);
	    }
	 public  static Response getPutUpdateBuildingInvalidHeader(PutUpdateBuildingDetails putUpdateBuildingDetails, String SESSIONTOKEN,String UNIQUEKEY){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .body(putUpdateBuildingDetails)
	                .put(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_BUILDING_PUT_UPDATE_ENDPOINT);
	    }
	 public  static Response getPutUpdateBuildingInvalidResources(PutUpdateBuildingDetails putUpdateBuildingDetails, String SESSIONTOKEN,String UNIQUEKEY){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .body(putUpdateBuildingDetails)
	                .put(INVALID_ENDPOINT + CONNECTED_WORLD_BUILDING_PUT_UPDATE_ENDPOINT);
	    }
	 
	 public  static Response getAllBuilding(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .get(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getAllBuildingInvalidCompanyId(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", INVALID_COMPANY_ID)
	                .get(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getAllBuildingInvalidHeader(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .get(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getAllBuildingInvalidEndpoint(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .get(INVALID_ENDPOINT);
	    }
	 
	 public  static Response getGetBuildingsByAddressComponentWithoutParameters(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .get(CONNECTED_WORLD_BUILDING_ADDRESS_COMPONENT_ENDPOINT);
	    }
	 
	 public  static Response getGetBuildingsByAddressComponentInvalidHeader(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .queryParam("city", CITY)
	                .get(CONNECTED_WORLD_BUILDING_ADDRESS_COMPONENT_ENDPOINT);
	    }
	 public  static Response getGetBuildingsByAddressComponentInvalidResources(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .queryParam("city", CITY)
	                .get(INVALID_ENDPOINT);
	    }
	 
	 public  static Response getGetBuildingsCustomFieldsInvalidHeader(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .get(CONNECTED_WORLD_BUILDING_CUSTOM_FIELDS_ENDPOINT);
	    }
	 
	 public  static Response getGetBuildingsCustomFieldsInvalidEndpoint(String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .get(INVALID_ENDPOINT);
	    }
	 
	 public  static Response getDeleteBuildingInvalidHeader(String UNIQUEKEY, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .delete(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_DELETE_BUILDING_ENDPOINT );
	    }
	 public  static Response getDeleteBuildingInvalidEndpoint(String UNIQUEKEY, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	        		.pathParam("uniqueKey", UNIQUEKEY)
	                .queryParam("companyId", COMPANY_ID)
	                .delete(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT + CONNECTED_WORLD_DELETE_BUILDING_ENDPOINT );
	    }
	 
	 public  static Response getDeleteMultipleBuildingInvalidHeader(String UNIQUEKEY1, String UNIQUEKEY2, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingHeaders(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .queryParam("uniqueKeys", UNIQUEKEY1,UNIQUEKEY2)
	                .delete(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }
	 
	 public  static Response getDeleteMultipleBuildingInvalidEndpoint(String UNIQUEKEY1, String UNIQUEKEY2, String SESSIONTOKEN){
	        return BaseRequestSpecification.getConnectedWorldBuildingDefaultRequestSpec(SESSIONTOKEN)
	                .queryParam("companyId", COMPANY_ID)
	                .queryParam("uniqueKeys", UNIQUEKEY1,UNIQUEKEY2)
	                .delete(CONNECTED_WORLD_BUILDING_VERSION_ENDPOINT);
	    }

}
