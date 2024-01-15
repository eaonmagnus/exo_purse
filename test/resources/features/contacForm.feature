Feature: Fill in the contact form
  Scenario: Fill in the contact form
    Given I am on the contact form page
    When I fill in the form with mandatory valid data
    Then I can submit the form