package com.capestart.pojos.advancecpqv2;


import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class CreateBillingAccountDetails {

  String billingAccountName;
  String banId;
  String currencyCode;
}
