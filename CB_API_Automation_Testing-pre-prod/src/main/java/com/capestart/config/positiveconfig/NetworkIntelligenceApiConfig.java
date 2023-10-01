package com.capestart.config.positiveconfig;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/api-config.properties",
  "file:${user.dir}/src/test/resources/api-uat.config.properties",
  "file:${user.dir}/src/test/resources/api-production.config.properties"})
public interface NetworkIntelligenceApiConfig extends Config {


  @Key("network.intelligence.version.endpoint")
  String getNetworkIntelligenceVersionEndPoint();

  @Key("ni.v6.get.all.endpoint")
  String getAllEndPoint();

  @Key("network.intelligence.latitude.value")
  String getLatitudeValue();

  @Key("network.intelligence.longitude.value")
  String getLongitudeValue();

  @Key("network.intelligence.positive.validation")
  String getPositiveValidation();

  @Key("ni.v6.get.broadband.endpoint")
  String getBroadbandEndPoint();

  @Key("ni.v6.post.bulk.address.endpoint")
  String getPostBulkAddressEndPoint();

  @Key("ni.v6.get.bulk.address.callback")
  String getBulkAddressCallBack();

  @Key("ni.v6.get.cableco")
  String getCabLecoEndPoint();

  @Key("ni.v6.get.conformed.provider")
  String getConformedProviderEndPoint();

  @Key("ni.v6.get.building.providers.by.address.endpoint")
  String getBuildingProvidersByAddressEndPoint();

  @Key("ni.v6.get.near.net.endpoint")
  String getNearNetEndPoint();

  @Key("ni.v6.get.onnet.endpoint")
  String getOnNetEndPoint();

  @Key("ni.v6.get.telco.endpoint")
  String getTelcoEndPoint();

  @Key("ni.v6.get.wisp.endpoint")
  String getWispEndPoint();

  @Key("conformed.provider.query.parameter.input.value")
  String getQueryParameterValue();

  @Key("get.building.providers.address.path.parameter.input")
  String getPathParameterAddressForInput();

  @Key("ni.v6.get.building.providers.by.address.path.parameter")
  String getAddressPathParameterForBuildingProvidingByAddress();


}
