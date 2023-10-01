# CB_API_Automation_Testing

# API Automation Framework

This is an API automation framework designed by **Kavin kumar**. The framework is built using Java 11, TestNG, RestAssured, and other libraries to automate API testing and generate Allure reports.

## Dependencies

- Owner: Used for loading properties files.
- Lombok: Provides annotations to reduce boilerplate code.
- RestAssured: Used for API testing.
- TestNG: Testing framework.
- Podam: Used for generating test data.
- AssertJ: Fluent assertions.
- No Exception: Functional-style exception handling.
- Allure RestAssured: Generates Allure reports for API test results.
- TestData Supplier: Provides test data for parameterized tests.

## To run api tests:

- CB_API_Automation_Testing:  mvn clean test

## To generate allure report after execution

- Install Allure in the machine - brew install allure

- Open allure reports - allure serve ./target/allure-results
