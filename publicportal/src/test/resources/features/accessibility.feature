Feature: Accessibility Testing

  Scenario: Check Accessibility on Home Page
    Given I am on the home page
    When I perform accessibility check
    Then I should see accessibility violations
