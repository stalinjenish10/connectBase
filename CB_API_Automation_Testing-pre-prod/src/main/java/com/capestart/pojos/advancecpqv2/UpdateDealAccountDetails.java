package com.capestart.pojos.advancecpqv2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Builder(setterPrefix = "Set")
public class UpdateDealAccountDetails {

  @JsonProperty("deal_name")
  String dealName;
}
