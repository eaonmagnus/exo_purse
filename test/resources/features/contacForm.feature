Feature: Fill in the contact form
  Scenario: Fill in the contact form with only andatory valid data
    Given I am on the contact form page
    When I fill in the form with only mandatory valid data
    Then I can submit the form