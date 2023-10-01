package com.capestart.pojos.connectedworldbuildingv5;

import java.util.List;

import lombok.Data;

@Data
public class PatchUpdateBuildingDetails {
	
	 private String buildingname;
	    private String street;
	    private String country;
	    private String state;
	    private String city;
	    private String postal;
	    private String latitude;
	    private String longitude;
	    private String primaryNumber;
	    private String streetName;
	    private String streetSuffix;
	    private List<String> buildingCategory;
	    private String networkBuildStatus;
	    private String buildingConnectionStatus;
	    private double elevation;
	    private String uniqueKey;

}
