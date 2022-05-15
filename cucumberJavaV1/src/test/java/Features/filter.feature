Feature: Filter Search

  Scenario Outline: Search row
    Given browser is open
    And user input the url
    When user is on the page and scroll on the table
    And filter a record using <name>, <year> and <food>
    Then the product mapped on the user should be displayed

    Examples: 
      | name     | year | food     |
      | Jennifer | 2013 | Banana   |
      | Jennifer | 2013 | Oat meal |
