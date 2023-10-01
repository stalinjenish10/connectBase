package com.capestart.pojos.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDetails {

  public String email;
  public String password;
}
