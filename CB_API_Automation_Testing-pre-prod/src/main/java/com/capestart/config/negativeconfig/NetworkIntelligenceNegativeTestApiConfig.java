package com.capestart.config.negativeconfig;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/api-config.properties",
  "file:${user.dir}/src/test/resources/api-uat.config.properties",
  "file:${user.dir}/src/test/resources/api-production.config.properties",
  "file:${user.dir}/src/test/resources/api-negative.config.properties"})
public interface NetworkIntelligenceNegativeTestApiConfig extends Config {

  @Key("get.valid.lat_id")
  String getValidLatitudeValue();

  @Key("get.valid.longt_id")
  String getValidLongitudeValue();

  @Key("get.validation.type")
  String getValidValidationType();
}
