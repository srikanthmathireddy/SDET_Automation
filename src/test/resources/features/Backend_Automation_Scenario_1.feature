Feature: RestCountries API Schema Validation

  Scenario: Validate the schema of RestCountries API response
    Given the RestCountries API is available
    When a user sends a GET request to fetch all countries
    Then the response should conform to the expected schema