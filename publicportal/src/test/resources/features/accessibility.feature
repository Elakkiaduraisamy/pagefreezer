Feature: Accessibility Testing

  Scenario: Check Accessibility on Home Page
    Given User is on the Home Page
    When User perform accessibility check
    Then User should see no accessibility violations
