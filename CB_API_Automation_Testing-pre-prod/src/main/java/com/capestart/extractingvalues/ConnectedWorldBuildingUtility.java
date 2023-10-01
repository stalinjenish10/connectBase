package com.capestart.extractingvalues;

import io.restassured.path.json.JsonPath;

public class ConnectedWorldBuildingUtility {
	
	  public static String  extractuniquekey(String responseBody, String keyPath) {
	    	 JsonPath jsonPath = new JsonPath(responseBody);
	    	 return jsonPath.get(keyPath).toString();
	    }

}
