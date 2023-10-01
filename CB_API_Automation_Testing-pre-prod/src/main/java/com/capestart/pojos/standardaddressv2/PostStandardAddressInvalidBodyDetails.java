package com.capestart.pojos.standardaddressv2;

import java.util.List;

import com.capestart.pojos.standardaddressv2.PostStandardAddressDetails.Address;

import lombok.Data;
@Data
public class PostStandardAddressInvalidBodyDetails {

	 private List<Address> addresses;

	    @Data
	    public static class Address {
	        private String address;
	        private String state;
	        private String postal;
	        private String country;
	
}}
