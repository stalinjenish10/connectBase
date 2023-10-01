package com.capestart.config.positiveconfig;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/api-config.properties",
  "file:${user.dir}/src/test/resources/api-uat.config.properties",
  "file:${user.dir}/src/test/resources/api-production.config.properties"})
public interface LoginApiConfig extends Config {

  @Key("username")
  String email();

  @Key("password")
  String password();

  @Key("sessionToken")
  String sessionToken();
}
