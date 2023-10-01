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
public interface StandardAddressV2NegativeTestApiConfig extends Config {

	 @Key("get.coords.invalid.lat")
	    String getInvalidLat();
	 
	 @Key("get.coords.invalid.lon")
	    String getInvalidLon();

	    @Key("standard.address.invalid.ocpkey")
	    String getInvalidOcpKey();
	    

	    @Key("standard.address.get.coords.invalid.endpoint")
	    String getCoordsInvalidUrl();
	    
	    @Key("standard.address.post.invalid.endpoint")
	    String getPostStandardAddressInvalidUrl();
	    
	    @Key("standard.address.string.post.invalid.endpoint")
	    String getPostStandardAddressStringInvalidUrl();
}
