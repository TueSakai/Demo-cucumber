Feature: Check Excel data
  Check for open & successfully getting Excel data

#  Scenario Outline: sample goto Google.com
#    Given Get browser "<Sheetname>" with <RowNumber>
#    When Input keyword: "<Sheetname>" and <RowNumber>
#    And Then click on search button
#    Then Verify search result: "<Sheetname>" and <RowNumber> display
#    And Close test case
#
#  Examples:
#    | Sheetname | RowNumber |
#    | Sheet1    |         0 |
#    | Sheet1    |         1 |
#    | Sheet1    |         2 |
  Scenario Outline: Start test
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click on the login button
    Then I should see the message "<message>"

    Examples:
      | username | password | message |
      | admin    | admin123 | Welcome |
      | user     | user123  | Invalid |
      | guest    | guest123 | Invalid |


