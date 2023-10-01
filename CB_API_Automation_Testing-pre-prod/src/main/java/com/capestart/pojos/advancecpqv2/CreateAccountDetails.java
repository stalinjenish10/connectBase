package com.capestart.pojos.advancecpqv2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class CreateAccountDetails {

  @JsonProperty("company_name")
  String companyName;
}
