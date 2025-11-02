Feature: Loyalty Points Quote API

  Scenario: Get loyalty points quote for SILVER tier
    Given I have the following quote request:
      | fareAmount   | currency | cabinClass | customerTier | promoCode  |
      | 1234.50      | USD      | ECONOMY    | SILVER       | SUMMER25   |
    When I send the quote request to the API
    Then the response should contain the correct points calculation