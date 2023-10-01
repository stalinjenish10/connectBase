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
public interface StandardAddressApiConfig extends Config{

	 @DefaultValue("staging")
	    String environment();

	    @Key("${environment}.baseurl")
	    String apiBaseUrl();

	    @Key("${environment}.login-baseurl")
	    String loginBaseUrl();
	    
	    @Key("standard.address.get.coords.endpoint")
	    String standardAddressGetEndpoint();
	    
	    @Key("standard.address.post.endpoint")
	    String standardAddressPostEndpoint();
	    
	    @Key("standard.address.string.post.endpoint")
	    String standardAddressStringPostEndpoint();
	    
	    @Key("standard.address.ocpkey")
	    String standardAddressOcpKey();
	    
	    @Key("standard.address.lat")
	    String standardAddressLatValue();
	    
	    @Key("standard.address.lon")
	    String standardAddressLonValue();
	    
	    
}
