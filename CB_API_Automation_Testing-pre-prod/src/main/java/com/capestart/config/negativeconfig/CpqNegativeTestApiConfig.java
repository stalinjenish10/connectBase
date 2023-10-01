package com.capestart.config.negativeconfig;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/api-config.properties",
  "file:${user.dir}/src/test/resources/api-uat.config.properties",
  "file:${user.dir}/src/test/resources/api-production.config.properties",
  "file:${user.dir}/src/test/resources/api-negative.config.properties"})


public interface CpqNegativeTestApiConfig extends Config {

  @DefaultValue("uat")
  String environment();

  @Key("get.common.invalid.data")
  String getInvalidData();

  @Key("get.common.invalid.integer.data")
  String getInvalidIntegerData();

  @Key("${environment}.get.valid.data.company_id")
  String getValidCompanyId();

  @Key("${environment}.get.valid.data.account_id")
  String getValidAccountId();

  @Key("${environment}.get.valid.data.deal_id")
  String getValidDealId();

  @Key("${environment}.get.valid.data.quote_id")
  String getValidQuoteId();

  @Key("${environment}.get.valid.data.location_id")
  String getValidLocationId();

  @Key("${environment}.get.other.user.cpq.ocp.key")
  String getOtherUserCpqOcpKey();

  @Key("get.general.invalid.ocp.key")
  String getGeneralInvalidOcpKey();

  @Key("${environment}.get.other.user.valid.data.account_id")
  String getOtherUserValidAccountId();

  @Key("${environment}.get.other.user.valid.data.deal_id")
  String getOtherUserValidDealId();


}
