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
public interface AddressValidationApiConfig extends Config {
	

	  @DefaultValue("staging")
	    String environment();

	    @Key("${environment}.baseurl")
	    String apiBaseUrl();

	    @Key("${environment}.login-baseurl")
	    String loginBaseUrl();
	    
	    @Key("address.validation.endpoint")
	    String addressValidationVersionEndpoint();
	    
	    @Key("address.validation.ocpkey")
	    String getAddressValidationOcpKey();
	    
	    @Key("address.validation.address1")
	    String getAddressValidationAddress1();
	    
	    @Key("address.validation.address2")
	    String getAddressValidationAddress2();


}
