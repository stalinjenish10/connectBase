package com.capestart.pojos.advancecpqv2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UpdateAccountDetails {

  @JsonProperty("hq_address")
  String hqAddress;

  String domain;

  @JsonProperty("phone_number")
  String phoneNumber;

  @JsonProperty("contact_name")
  String contactName;

  @JsonProperty("rfx_id")
  String rfxId;

  @JsonProperty("default_currency_code")
  String defaultCurrencyCode;


}
