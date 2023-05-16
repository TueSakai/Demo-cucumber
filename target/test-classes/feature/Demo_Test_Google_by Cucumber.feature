Feature: Goto google.com
  Check for open browser & successfully getting google

  Scenario Outline: sample goto Google.com
    Given Get browser "<browser>" with "<url>"
    When Input keyword: "<keyword>"
    And Then click on search button
    Then Verify search result: "<expect>" display
    And Close test case

  Examples:
    | browser   | url                     | keyword     | expect    |
    | chrome    | https://www.google.com  | 123         | 123       |
    | edge      | https://www.google.com  | 321         | 321       |
