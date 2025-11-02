Feature: Loyalty Points Quote API

  Scenario: Get loyalty points quote for Gold tier
    Given I have the following quote request for gold tier
      | fareAmount   | currency | cabinClass | customerTier | promoCode  |
      | 1234.50      | USD      | ECONOMY    | GOLD       | SUMMER25   |
    When I send the quote request to the API for gold tier
    Then the response should contain the correct points calculation for gold tier