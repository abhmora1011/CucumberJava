Feature: Filter Search

  Scenario: Search row
    Given browser is open
    And user input the url
    When user is on the page and scroll on the table
    And input person name on the field 
    Then the product mapped on the user should be displayed

