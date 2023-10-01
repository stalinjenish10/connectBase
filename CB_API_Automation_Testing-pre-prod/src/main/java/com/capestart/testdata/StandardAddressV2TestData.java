package com.capestart.testdata;

import java.io.File;
import java.io.IOException;

import com.capestart.pojos.standardaddressv2.PostStandardAddressDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressInvalidBodyDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressInvalidInputBodyDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressStringDetails;
import com.capestart.pojos.standardaddressv2.PostStandardAddressStringInvalidBodyDetails;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class StandardAddressV2TestData {
	
	private StandardAddressV2TestData() {
		
	}

	
	 @SneakyThrows
	    public  static PostStandardAddressDetails getPostStandardAddressDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/standardaddressbody/post-standardaddress.json"), PostStandardAddressDetails.class);

	    }
	 
	 @SneakyThrows
	    public  static PostStandardAddressInvalidBodyDetails getPostStandardAddressInvalidBodyDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/standardaddressbody/post-standardaddressinvalidbody.json"), PostStandardAddressInvalidBodyDetails.class);

	    }
	 
	 
	 @SneakyThrows
	    public  static PostStandardAddressInvalidInputBodyDetails getPostStandardAddressInvalidInputBodyDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/standardaddressbody/post-standardaddressinvalidinputbody.json"), PostStandardAddressInvalidInputBodyDetails.class);

	    }
	 

	 @SneakyThrows
	    public  static PostStandardAddressStringDetails getPostStandardAddressStringDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/standardaddressbody/post-standardaddressstring.json"), PostStandardAddressStringDetails.class);

	    }
	 @SneakyThrows
	    public  static PostStandardAddressStringInvalidBodyDetails getPostStandardAddressStringInvalidBodyDetails() throws StreamReadException, DatabindException, IOException  {

	        return new ObjectMapper()
	                .readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/requests/standardaddressbody/post-standardaddressstringinvalidbody.json"), PostStandardAddressStringInvalidBodyDetails.class);

	    }
	 
}
