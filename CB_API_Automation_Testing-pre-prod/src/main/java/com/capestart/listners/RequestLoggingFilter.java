package com.capestart.listners;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RequestLoggingFilter implements Filter {

  @Override
  public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                         FilterContext ctx) {
    // Log the request body
    if (requestSpec instanceof RequestSpecificationImpl) {
      RequestSpecificationImpl specImpl = (RequestSpecificationImpl) requestSpec;
      InputStream requestInputStream = (InputStream) specImpl.getBody();
      try {
        String requestBody = IOUtils.toString(requestInputStream, StandardCharsets.UTF_8);
        // Log the request body using your preferred logging framework (e.g., log4j, slf4j, or System.out)
        // For Allure report, you can log it as a test step or add it to your test report somehow.
      } catch (IOException e) {
        // Handle the exception
      }
    }
    // Proceed with the request
    return ctx.next(requestSpec, responseSpec);
  }
}
