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
public interface InternationalAddressNegativeTestApiConfig extends Config {
	
	 @Key("international.invalid.address")
	    String getInvalidAddress();

	    @Key("international.address.invalid.ocpkey")
	    String getInvalidOcpKey();
	    

	    @Key("international.address.invalid.endpoint")
	    String getInvalidUrl();
	    
	    @Key("international.invalid.country")
	    String getInvalidCountry();
	    
	   
	    

}
