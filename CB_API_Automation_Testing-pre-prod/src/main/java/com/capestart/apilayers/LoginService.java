package com.capestart.apilayers;

import com.capestart.factory.ApiConfigFactory;
import com.capestart.pojos.login.LoginDetails;
import io.restassured.response.Response;

public class LoginService {

  private static final String LOGIN_VERSION_ENDPOINT = ApiConfigFactory.getConfig().loginVersionEndpoint();

  public static Response postLogin(LoginDetails loginDetails) {
    return BaseRequestSpecification.getLoginRequestSpec()
      .body(loginDetails)
      .post(LOGIN_VERSION_ENDPOINT);
  }
}
