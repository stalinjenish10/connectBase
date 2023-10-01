package com.capestart.pojos.networkintelligence;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SetupData {


  private static int reqIdCounter = 1678; // Counter for generating unique reqIds

  public static String getBulkAddress() {
    JSONObject jsonObject = new JSONObject();

    // Create addresses JSON array
    JSONArray addressesArray = new JSONArray();

    // Create address 1
    JSONObject address1 = new JSONObject();
    address1.put("address", "7505 John W. Carpenter Freeway");
    address1.put("city", "Lone Tree");
    address1.put("state", "TX");
    address1.put("zipcode", "75247");
    address1.put("country", "USA");

    // Create address 2
    JSONObject address2 = new JSONObject();
    address2.put("address", "10055 Library Way");
    address2.put("city", "Lone Tree");
    address2.put("state", "CO");
    address2.put("zipcode", "80124");
    address2.put("country", "USA");

    // Add addresses to the array
    addressesArray.add(address1);
    addressesArray.add(address2);

    // Increment the reqIdCounter for generating unique request IDs
    reqIdCounter++;

    // Generate a UUID without dashes
    String uuid = java.util.UUID.randomUUID().toString().replace("-", "");

    // Generate a new request ID using timestamp, counter, and UUID
    long timestamp = System.currentTimeMillis();
    String newRequestId = "1001-SA-" + timestamp + "-" + reqIdCounter + "-" + uuid;

    // Add the addresses array and the request_id to the main JSON object
    jsonObject.put("addresses", addressesArray);
    jsonObject.put("request_id", newRequestId);
    return jsonObject.toString();
  }

}
