Feature: Confirmation of Country Count

  Scenario: Validate there are 195 countries in the world using RestCountries API
    Given I call the RestCountries API to get all countries
    When I count the number of unique countries returned
    Then the number of countries should be 195