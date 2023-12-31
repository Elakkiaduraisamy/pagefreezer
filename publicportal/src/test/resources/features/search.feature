Feature: Search Feature

  Scenario: User can search for a query
    Given User is on the Home Page
    When User searches for "General"
    Then Search results should display an error message

  Scenario: User can search for a query
    Given User is on the Home Page
    And User selects "Social Media" in the select Account
    When User searches for "test"
    Then Search results should display an error message

  Scenario Outline: User can search for a query
    Given User is on the Home Page
    And User selects "<accountsType>" in the select Account
    When User searches for "<searchKeyword>"
    Then Search results should display an error message
    Examples:
      | accountsType| searchKeyword |
      | select All  | Market    |
      | website | road   |
