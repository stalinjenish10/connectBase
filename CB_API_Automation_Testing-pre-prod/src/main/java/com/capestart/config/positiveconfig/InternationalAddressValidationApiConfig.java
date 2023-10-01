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
public interface InternationalAddressValidationApiConfig extends Config {
	
	
	  @DefaultValue("staging")
	    String environment();

	    @Key("${environment}.baseurl")
	    String apiBaseUrl();

	    @Key("${environment}.login-baseurl")
	    String loginBaseUrl();
	
	    @Key("international.address.validation.endpoint")
	    String internationalAddressValidationVersionEndpoint();
	    
	    @Key("international.address.validation.ocpkey")
	    String internationalAddressValidationOcpKey();
	    
	    @Key("international.valid.address")
	    String internationalAddress();
	    
	    @Key("international.country")
	    String internationalCountry();

}
