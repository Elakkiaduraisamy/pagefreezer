Feature: Search Feature
  Scenario: User can search for a query
    Given User is on the Home Page
    When User searches for "General"
    Then Search results should be displayed
