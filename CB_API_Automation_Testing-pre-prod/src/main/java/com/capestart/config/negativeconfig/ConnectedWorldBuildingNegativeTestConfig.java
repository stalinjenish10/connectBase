package com.capestart.config.negativeconfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/api-config.properties",
        "file:${user.dir}/src/test/resources/api-uat.config.properties",
        "file:${user.dir}/src/test/resources/api-production.config.properties",
        "file:${user.dir}/src/test/resources/api-negative.config.properties"})
public interface ConnectedWorldBuildingNegativeTestConfig extends Config {

	
	 @Key("get.connected.world.building.invalid.ocp.key")
	    String getInvalidOcpKey();

	    @Key("connected.world.building.invalid.url")
	    String getInvalidUrl();
	    
	    @Key("connected.world.building.invalid.uniquekey")
	    String getInvalidUniqueKey();
	    
	    @Key("connected.world.building.uniquekey")
	    String getValidUniqueKey();
	    
	    @Key("connected.world.building.invalid.company.id")
	    String getInvalidCompanyId();
	    
	    
}

