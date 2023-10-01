package com.capestart.pojos.advancecpqv2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataDetails {

  @JsonProperty("account_id")
  private int accountId;
  @JsonProperty("user_account_id")
  private int userAccountId;
  @JsonProperty("company_name")
  private String companyName;
  @JsonProperty("user_id")
  private String userId;
  @JsonProperty("createddate")
  private String createdDate;
  @JsonProperty("is_created_by_corporate_user")
  private int isCreatedByCorporateUser;

  @JsonProperty("deal_name")
  private String dealName;

  @JsonProperty("isbulk_deal")
  private String isBulkDeal;

  private String currency;


  @JsonProperty("deal_id")
  private String dealId;



}
