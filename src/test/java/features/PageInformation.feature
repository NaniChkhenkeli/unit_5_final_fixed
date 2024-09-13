Feature: View Page Information on Wikipedia

  Scenario: View page information of the Bengal tiger article
    Given the Main page is open
    When I search for "Bengal tiger"
    And I view the page information
    Then the page information should be displayed


