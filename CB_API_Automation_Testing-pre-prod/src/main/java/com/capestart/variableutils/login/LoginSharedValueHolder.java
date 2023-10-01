package com.capestart.variableutils.login;

import lombok.Getter;
import lombok.Setter;


public class LoginSharedValueHolder {

  @Getter
  @Setter
  public static String sessionToken;


  @Getter
  @Setter
  public static Integer userId;


}
