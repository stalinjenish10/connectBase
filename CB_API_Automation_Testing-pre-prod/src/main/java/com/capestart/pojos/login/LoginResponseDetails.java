package com.capestart.pojos.login;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseDetails {

  private String session_token;
  private User user;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class User {
    public static int id;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
  }
}
