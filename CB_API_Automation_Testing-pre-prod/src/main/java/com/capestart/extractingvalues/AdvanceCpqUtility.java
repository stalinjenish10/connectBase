package com.capestart.extractingvalues;

import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdvanceCpqUtility {

  public static List<Map<String, Object>> extractCompanies(String responseBody, String keyPath) {
    JsonPath jsonPath = new JsonPath(responseBody);
    //return jsonPath.getList("data.companies");
    return jsonPath.getList(keyPath);

  }

  public static Integer findDesiredID(List<Map<String, Object>> companies, String companyName, String keyToFind, String dataToFind) {
    return companies.stream()
      .filter(company -> companyName.equals(company.get(keyToFind).toString().trim()))
      .findFirst()
      .map(company -> (int) company.get(dataToFind))
      .orElse(0);
  }

  public static String findBillingAccountID(List<Map<String, Object>> companies, String billingAccountName) {
    return String.valueOf(companies.stream()
      .filter(company -> billingAccountName.equals(company.get("billingAccountName").toString().trim()))
      .findFirst()
      .map(company -> (int) company.get("id"))
      .orElse(0));

  }

  public static String findDesiredValue(List<Map<String, Object>> companies, String desiredAccountName, String keyToFind,
                                        String dataToFind) {
    return String.valueOf(companies.stream()
      .filter(company -> desiredAccountName.equals(company.get(keyToFind).toString().trim()))
      .findFirst()
      .map(company -> (int) company.get(dataToFind))
      .orElse(0));

  }

  public static List<Integer> findMultipleDesiredValues(List<Map<String, Object>> locations, List<String> locationsNamesToFind,
                                                        String keyToFind, String dataToFind) {
    List<Integer> extractedIds = new ArrayList<>();

    for (String dealName : locationsNamesToFind) {
      Integer id = locations.stream()
        .filter(company -> dealName.equals(company.get(keyToFind).toString().trim()))
        .findFirst()
        .map(company -> (int) company.get(dataToFind))
        .orElse(0);
      extractedIds.add(id);
    }

    return extractedIds;
  }
}
