package com.capestart.testdata;

import java.io.File;
import java.io.IOException;

import com.capestart.pojos.advancecpqv2.CreateAccountDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingForDeleteDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingForDeleteMultipleBuildings;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingWithInvalidBodyDetails;
import com.capestart.pojos.connectedworldbuildingv5.CreateBuildingWithInvalidInputDetails;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.PatchUpdateBuildingInvalidInputDetails;
import com.capestart.pojos.connectedworldbuildingv5.PutUpdateBuildingDetails;
import com.capestart.pojos.connectedworldbuildingv5.PutUpdateBuildingInvalidInputDetails;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class ConnectedWorldBuildingV5TestData {
	
	private ConnectedWorldBuildingV5TestData() {}

	
	 @SneakyThrows
	    public  static CreateBuildingDetails getCreateBuildingDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/post-createbuilding.json"), CreateBuildingDetails.class);

	    }
	 
	 @SneakyThrows
	    public  static CreateBuildingWithInvalidBodyDetails getCreateBuildingWithInvalidBodyDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/post-createbuildinginvalidbody.json"), CreateBuildingWithInvalidBodyDetails.class);

	    }
	 
	 @SneakyThrows
	    public  static CreateBuildingWithInvalidInputDetails getCreateBuildingWithInvalidInputDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/post-createbuildinginvalidinput.json"), CreateBuildingWithInvalidInputDetails.class);

	    }
	 

	 @SneakyThrows
	    public  static CreateBuildingForDeleteDetails getCreateBuildingForDeleteDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/post-createbuildingfordelete.json"), CreateBuildingForDeleteDetails.class);

	    }
	 
	 @SneakyThrows
	    public  static CreateBuildingForDeleteMultipleBuildings getCreateBuildingForDeleteMultipleDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/post-createbuildingformultipledelete.json"), CreateBuildingForDeleteMultipleBuildings.class);

	    }

	 @SneakyThrows
	    public  static PatchUpdateBuildingDetails getPatchUpdateBuildingDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/patch-updatebuilding.json"), PatchUpdateBuildingDetails.class);

	    }
	 
	 @SneakyThrows
	    public  static PatchUpdateBuildingInvalidInputDetails getPatchUpdateBuildingInvalidInputDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/patch-updatebuildinginvalidinput.json"), PatchUpdateBuildingInvalidInputDetails.class);

	    }

	 @SneakyThrows
	    public  static PutUpdateBuildingDetails getPutUpdateBuildingDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/put-updatebuilding.json"), PutUpdateBuildingDetails.class);

	    }
	 
	 @SneakyThrows
	    public  static PutUpdateBuildingInvalidInputDetails getPutUpdateBuildingInvalidInputDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/connectedworldbuildingbody/put-updatebuildinginvalidbody.json"), PutUpdateBuildingInvalidInputDetails.class);

	    }
	 
}
