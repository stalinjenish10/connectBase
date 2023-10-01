package com.capestart.pojos.advancecpqv2;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class CreatePricingDetails {
  private String quoteName;
  private Config config;
  private List<Location> locations;

  @Data
  public static class Config {
    private List<ProductCriteria> productCriteria;
  }

  @Data
  public static class ProductCriteria {
    private String product;
    private List<String> mediaTypes;
    private String channel;
    private String pricingAccountName;
    private List<Object> term;
    private boolean includeOffnet;
    private int smartResultsPerSupplier;
    private SpeedParameter speedParameterDownload;
    private SpeedParameter speedParameterUpload;
    private Selection selection;
  }

  @Data
  public static class SpeedParameter {
    private List<Integer> equal;
  }

  @Data
  public static class Selection {
    private int desiredSpeed;
    private int desiredUploadSpeed;
    private String speedPriority;
    private String desiredTerm;
    private String pricingCriteria;
    private boolean required;
  }

  @Data
  public static class Location {
    private String address;
    private String customerLocationId;
    private String siteCategory;
    private String siteName;
    private String siteId;
  }
}
