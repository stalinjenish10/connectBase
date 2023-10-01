package com.capestart.config.positiveconfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.DefaultValue;
import org.aeonbits.owner.Config.Key;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                  "system:env",
                    "file:${user.dir}/src/test/resources/api-config.properties",
                    "file:${user.dir}/src/test/resources/api-uat.config.properties",
                    "file:${user.dir}/src/test/resources/api-production.config.properties"})
public interface ConnectedWorldBuildingApiConfig extends Config{
	
	  @DefaultValue("staging")
	    String environment();

	    @Key("${environment}.baseurl")
	    String apiBaseUrl();

	    @Key("${environment}.login-baseurl")
	    String loginBaseUrl();

	    @Key("connected.world.building.endpoint")
	    String connectedWorldBuildingVersionEndpoint();

	    @Key("create.account")
	    String createAccountEndpoint();

	    @Key("staging.connectedworldbuilding.ocpkey")
	    String getConnectedWorldBuildingOcpKey();
	    
	    @Key("connected.world.getbuilding.endpoint")
	    String connectedWorldGetBuildingEndpoint();
	    
	    @Key("connected.world.building.patch.update.endpoint")
	    String connectedWorldtBuildingPatchUpdateEndpoint();

	    @Key("connected.world.building.put.update.endpoint")
	    String connectedWorldtBuildingPutUpdateEndpoint();
	    
	    @Key("connected.world.building.page.value")
	    String connectedWorldtBuildingPageValue();
	    
	    @Key("connected.world.building.size.value")
	    String connectedWorldtBuildingSizeValue();
	    
	    @Key("connected.world.building.radius.value")
	    String connectedWorldtBuildingRadiusValue();
	    
	    @Key("connected.world.building.city.value")
	    String connectedWorldtBuildingCityValue();
	    
	    @Key("connected.world.building.getBuildings.address.component.endpoint")
	    String connectedWorldBuildingAddressComponentEndpoint();
	    
	    @Key("connected.world.building.custom.fields.endpoint")
	    String connectedWorldBuildingCustomFieldsEndpoint();
	    
	    @Key("connected.world.delete.building.endpoint")
	    String connectedWorldDeleteBuildingEndpoint();
}
