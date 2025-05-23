Feature: Retrieve search results

  Scenario: At least 4 relevant results are returned for "Sport in 2023"
    Given I am on the BBC Sport search page
    When I search for "Sport in 2023"
    Then I should see at least 4 relevant results