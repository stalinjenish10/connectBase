package com.capestart.pojos.connectedworldbuildingv5;
import lombok.Data;

import java.util.List;


@Data
public class CreateBuildingDetails {
	
	    private String buildingname;
	    private List<String> buildingCategory;
	    private String street;
	    private String city;
	    private String state;
	    private String country;
	    private String postal;
	    private String latitude;
	    private String longitude;
	    private String networkBuildStatus;
	    private String buildingConnectionStatus;
	}






	
	

