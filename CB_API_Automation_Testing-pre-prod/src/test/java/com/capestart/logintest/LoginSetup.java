package com.capestart.logintest;

import com.capestart.apilayers.LoginService;
import com.capestart.factory.ApiConfigFactory;
import com.capestart.pojos.login.LoginDetails;
import com.capestart.pojos.login.LoginResponseDetails;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.util.function.Predicate;

import static com.capestart.assertwrapper.ResponseAssert.assertthat;
import static com.capestart.variableutils.login.LoginSharedValueHolder.sessionToken;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSetup {

  private static final String EMAIL = ApiConfigFactory.getLoginConfig().email();

  private static final String PASSWORD = ApiConfigFactory.getLoginConfig().password();

  @Setter
  @Getter
  public static int UserId;

  @Test
  public static void setUp() {
    //LoginSharedValueHolder.setSessionToken(sessionToken);

    LoginDetails loginDetails = LoginDetails.builder().email(EMAIL).password(PASSWORD).build();
    Response response = LoginService.postLogin(loginDetails);
    String ResponseBody = response.then().log().all().extract().asPrettyString();

    Predicate<Response> emailPredicate = res -> {
      String actualEmail = res.jsonPath().getString("email");
      return actualEmail != null && actualEmail.equalsIgnoreCase(EMAIL);
    };

    Predicate<Response> idPredicate = res -> {
      String actualEmail = res.jsonPath().getString("user.id");
      return actualEmail != null && actualEmail.equalsIgnoreCase("14428");
    };

    Predicate<String> sessionTokenPredicate = key -> key.equals("session_token");

    sessionToken = assertthat(response)
      .statusCodeIs(200)
      .hasContentType("application/json; charset=utf-8")
      .canBeDeserializedTo(LoginResponseDetails.class)
      .hasKeyWithValue(emailPredicate)
      .hasKeyWithValue(idPredicate)
      .extractValueByKey(sessionTokenPredicate);

    assertThat(sessionToken).isNotNull();
    System.out.println("Session Token: " + sessionToken);
  }

  public static String getSessionToken() {

    return sessionToken;
  }

}
