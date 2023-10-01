package com.capestart.pojos.standardaddressv2;

import java.util.List;

import lombok.Data;
@Data
public class PostStandardAddressDetails {

	 private List<Address> addresses;

	    @Data
	    public static class Address {
	        private String address;
	        private String city;
	        private String state;
	        private String postal;
	        private String country;
	
}}
