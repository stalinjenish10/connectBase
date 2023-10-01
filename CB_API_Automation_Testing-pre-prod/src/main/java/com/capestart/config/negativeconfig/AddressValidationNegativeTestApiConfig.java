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
public interface AddressValidationNegativeTestApiConfig extends Config {
	
	 @Key("address.validation.invalid.address")
	    String getInvalidAddress();

	    @Key("address.validation.invalid.ocpkey")
	    String getInvalidOcpKey();
	    

	    @Key("address.validation.invalid.endpoint")
	    String getInvalidUrl();
	    
	    
	    

}
