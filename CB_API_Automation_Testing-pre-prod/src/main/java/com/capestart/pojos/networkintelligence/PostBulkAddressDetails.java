package com.capestart.pojos.networkintelligence;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@Builder(setterPrefix = "set")
public class PostBulkAddressDetails {


  private List<Address> addresses;

  // Define and initialize newRequestId with your desired value
  @Builder.Default
  public String request_id = generateNewRequestId();

  private static String generateNewRequestId() {
    int reqIdCounter = 0; // Counter for generating unique reqIds


    // Increment the reqIdCounter for generating unique request IDs
    reqIdCounter++;

    // Generate a new request ID using timestamp, counter, and UUID
    long timestamp = System.currentTimeMillis();
    String newRequestId = "1001-SA-" + timestamp + "-" + reqIdCounter;
    return newRequestId;
  }

  @Data
  public static class Address {
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
  }
}
