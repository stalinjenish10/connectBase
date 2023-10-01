package com.capestart.pojos.standardaddressv2;

import java.util.List;

import com.capestart.pojos.standardaddressv2.PostStandardAddressDetails.Address;

import lombok.Data;
@Data
public class PostStandardAddressInvalidInputBodyDetails {
	
	 private List<Address> address;

	    @Data
	    public static class Address {
	        private String address;
	        private String city;
	        private String state;
	        private String postal;
	        private String country;

}}
