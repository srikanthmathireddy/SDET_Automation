Feature: Loyalty Points Quote API

  Scenario: Get loyalty points quote for NONE tier
    Given I have the following quote request for NONE tier
      | fareAmount   | currency | cabinClass | customerTier | promoCode  |
      | 1234.50      | USD      | ECONOMY    | NONE       | SUMMER25   |
    When I send the quote request to the API for NONE tier
    Then the response should contain the correct points calculation for NONE tier