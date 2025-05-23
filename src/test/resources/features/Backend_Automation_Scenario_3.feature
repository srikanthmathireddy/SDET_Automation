Feature: Validate Languages
  As the Minister of Education
  I want to ensure that South African Sign Language (SASL) is listed as an official language of South Africa

  Scenario: South African Sign Language listed as official language
    Given I fetch all countries from the API
    Then South African Sign Language should be listed as an official language of South Africa