package com.capestart.testdata;

import com.capestart.pojos.networkintelligence.PostBulkAddressDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class NetworkIntelligenceTestData {


  private NetworkIntelligenceTestData() {
  }

  @SneakyThrows
  public static PostBulkAddressDetails getPostBulkAddressDetails() {

    return new ObjectMapper()
      .readValue(
        new File(System.getProperty("user.dir") + "/src/test/resources/requests.networkintelligencebody/post-bulkaddress.json"),
        PostBulkAddressDetails.class)

      // Set the request_id using Podam's UniqueRequestIdStrategy
      .setRequest_id(getPostBulkAddressDetails().request_id);

  }

}
