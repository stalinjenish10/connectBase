package com.capestart.factory;

import com.capestart.config.negativeconfig.AddressValidationNegativeTestApiConfig;
import com.capestart.config.negativeconfig.ConnectedWorldBuildingNegativeTestConfig;
import com.capestart.config.negativeconfig.CpqNegativeTestApiConfig;
import com.capestart.config.negativeconfig.InternationalAddressNegativeTestApiConfig;
import com.capestart.config.negativeconfig.NetworkIntelligenceNegativeTestApiConfig;
import com.capestart.config.negativeconfig.StandardAddressV2NegativeTestApiConfig;
import com.capestart.config.positiveconfig.AddressValidationApiConfig;
import com.capestart.config.positiveconfig.ApiConfig;
import com.capestart.config.positiveconfig.ConnectedWorldBuildingApiConfig;
import com.capestart.config.positiveconfig.InternationalAddressValidationApiConfig;
import com.capestart.config.positiveconfig.LoginApiConfig;
import com.capestart.config.positiveconfig.NetworkIntelligenceApiConfig;
import com.capestart.config.positiveconfig.StandardAddressApiConfig;

import org.aeonbits.owner.ConfigCache;

public final class ApiConfigFactory {
  private ApiConfigFactory() {
  }

  public static CpqNegativeTestApiConfig getCpqNegativeTestApiConfig() {
    return ConfigCache.getOrCreate(CpqNegativeTestApiConfig.class);
  }

  public static NetworkIntelligenceNegativeTestApiConfig getNetworkIntelligenceNegativeTestApiConfig() {
    return ConfigCache.getOrCreate(NetworkIntelligenceNegativeTestApiConfig.class);
  }


  public static ApiConfig getConfig() {
    return ConfigCache.getOrCreate(ApiConfig.class);
  }

  public static LoginApiConfig getLoginConfig() {
    return ConfigCache.getOrCreate(LoginApiConfig.class);
  }

  public static NetworkIntelligenceApiConfig getNetworkIntelligenceConfig() {
    return ConfigCache.getOrCreate(NetworkIntelligenceApiConfig.class);
  }

  public static ConnectedWorldBuildingApiConfig getConnectedWorldBuildingConfig() {return ConfigCache.getOrCreate(ConnectedWorldBuildingApiConfig.class);}
  
  public static AddressValidationApiConfig getAddressValidationApiConfig() { return ConfigCache.getOrCreate(AddressValidationApiConfig.class);}
  
  public static InternationalAddressNegativeTestApiConfig getInternationalAddressNegativeTestApiConfig() { return ConfigCache.getOrCreate(InternationalAddressNegativeTestApiConfig.class);}
  
  public static StandardAddressApiConfig getStandardAddressApiConfig() { return ConfigCache.getOrCreate(StandardAddressApiConfig.class);}
  
  public static ConnectedWorldBuildingNegativeTestConfig getConnectedWorldBuildingNegativeTestConfig() {return ConfigCache.getOrCreate(ConnectedWorldBuildingNegativeTestConfig.class);}
  
  public static AddressValidationNegativeTestApiConfig getAddressValidationNegativeTestApiConfig() {return ConfigCache.getOrCreate(AddressValidationNegativeTestApiConfig.class);}
  
  public static InternationalAddressValidationApiConfig getInternationalAddressValidationApiConfig() { return ConfigCache.getOrCreate(InternationalAddressValidationApiConfig.class);}
  
  public static StandardAddressV2NegativeTestApiConfig getStandardAddressV2NegativeTestApiConfig() { return ConfigCache.getOrCreate(StandardAddressV2NegativeTestApiConfig.class);}
}
