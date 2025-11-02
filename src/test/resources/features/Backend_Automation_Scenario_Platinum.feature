Feature: Loyalty Points Quote API

  Scenario: Get loyalty points quote for platinum tier
    Given I have the following quote request for platinum tier
      | fareAmount   | currency | cabinClass | customerTier | promoCode  |
      | 1234.50      | USD      | ECONOMY    | PLATINUM       | SUMMER25   |
    When I send the quote request to the API for platinum tier
    Then the response should contain the correct points calculation for platinum tier