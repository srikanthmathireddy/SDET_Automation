Feature: Validate Grand Prix Results

  Scenario: Validate top 3 finishers of the 2023 Las Vegas Grand Prix
    Given I am on the BBC Sport results page
    When I view the results table for the 2023 Las Vegas Grand Prix
    Then Max Verstappen should be in 1st place
    And George Russell should be in 2nd place
    And Sergio Perez should be in 3rd place