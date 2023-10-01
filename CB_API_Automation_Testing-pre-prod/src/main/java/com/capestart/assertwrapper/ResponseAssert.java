package com.capestart.assertwrapper;

import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

  private SoftAssertions softAssertions;

  private ResponseAssert(Response response) {
    super(response, ResponseAssert.class);
    softAssertions = new SoftAssertions();
  }

  public static ResponseAssert assertthat(Response response) {
    return new ResponseAssert(response);
  }

  public ResponseAssert statusCodeIs(int expectedStatusCode) {
    softAssertions.assertThat(actual.statusCode())
      .isEqualTo(expectedStatusCode);
    return this;
  }

  public ResponseAssert canBeDeserializedTo(Class clazz) {
    softAssertions.assertThatCode(() -> actual.as(clazz))
      .doesNotThrowAnyException();
    return this;
  }

  public ResponseAssert matchingRule(Predicate<Response> condition, String errorMessage) {
    softAssertions.assertThat(condition).withFailMessage(errorMessage).accepts(actual);
    return this;
  }

  public ResponseAssert matchingRule(Predicate<Response> condition) {
    return matchingRule(condition, "Predicate validation failed");
  }

  public ResponseAssert hasKeyWithValue(String Key, String Value) {
    softAssertions.assertThat(actual.getBody().jsonPath().getString(Key))
      .isEqualTo(Value);
    return this;
  }

  public ResponseAssert hasKeyWithValue(Predicate<Response> predicate) {
    softAssertions.assertThat(predicate)
      .accepts(actual);
    return this;
  }

  public String extractValueByKey(Predicate<String> keypredicate) {
    // Use entrySet and streams to find the key based on the predicate
    Map<String, Object> jsonMap = actual.getBody().jsonPath().getMap("");

    String matchingKey = jsonMap.keySet().stream()
      .filter(keypredicate)
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("No key matches the predicate."));

    return jsonMap.get(matchingKey).toString();
  }


  public String extractValueByPredicate(Predicate<Response> predicate, String keyToExtract) {
    softAssertions.assertThat(predicate)
      .accepts(actual);

    return actual.jsonPath().getList("data.companies", Map.class).stream()
      .map(company -> {
        Response companyResponse = new ResponseBuilder()
          .clone(actual)
          .setBody((InputStream) company)
          .build();

        return companyResponse;
      })
      .filter(predicate::test)
      .map(response -> response.jsonPath().get(keyToExtract))
      .filter(Objects::nonNull)
      .findFirst()
      .map(Object::toString)
      .orElse(null);
  }


  public ResponseAssert hasContentType(String contentType) {
    softAssertions.assertThat(actual.getContentType())
      .isEqualTo(contentType);
    return this;
  }


  public void assertAll() {
    softAssertions.assertAll();


  }


}
