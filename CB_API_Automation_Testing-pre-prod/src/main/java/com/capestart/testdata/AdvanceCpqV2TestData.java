package com.capestart.testdata;

import com.capestart.pojos.advancecpqv2.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

public class AdvanceCpqV2TestData {
  private AdvanceCpqV2TestData() {
  }

  @SneakyThrows
  public static CreateAccountDetails getCreateAccountDetails() throws IOException {

    return new ObjectMapper()
      .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/post-createaccount.json"),
        CreateAccountDetails.class);

    // .setCompany_name("Testing Testing test");

  }

  @SneakyThrows
  public static CreateBillingAccountDetails getCreateBillingAccountDetails() {

    return new ObjectMapper()
      .readValue(
        new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/post-createbillingaccount.json"),
        CreateBillingAccountDetails.class);
    //.setCompany_name("Testing Testing test");

  }

  @SneakyThrows
  public static CreateDealAccountDetails getCreateDealAccountDetails() {

    return new ObjectMapper()
      .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/post-createdealaccount.json"),
        CreateDealAccountDetails.class);
    //.setdeal_name("Testing Testing test");

  }

  @SneakyThrows
  public static UpdateDealAccountDetails getUpdateDealAccountDetails() {

    return new ObjectMapper()
      .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/patch-updatedealaccount.json"),
        UpdateDealAccountDetails.class);
    //.setdeal_name("Testing Testing test");

  }

  @SneakyThrows
  public static UpdateAccountDetails getUpdateAccountDetails() {

    return new ObjectMapper()
      .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/patch-updatedaccount.json"),
        UpdateAccountDetails.class);
    //.setdeal_name("Testing Testing test");

  }

  @SneakyThrows
  public static AddLocationDetails getAddLocationDetails() {

    return new ObjectMapper()
      .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/post-addlocation.json"),
        AddLocationDetails.class);
    //.setdeal_name("Testing Testing test");

  }

  @SneakyThrows
  public static CreatePricingDetails getCreatePricingDetails() {

    return new ObjectMapper()
      .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/post-createpricing.json"),
        CreatePricingDetails.class);
    //.setdeal_name("Testing Testing test");

  }

  @SneakyThrows
  public static CreateOrderDetails getCreateOrderDetails() {

    return new ObjectMapper()
      .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/requests/advancecpqbody/post-createorder.json"),
        CreateOrderDetails.class);
    //.setdeal_name("Testing Testing test");

  }
}
