Feature: Download PDF from Wikipedia

  Scenario: Download Albert Einstein's article as PDF
    Given the Main page is open
    When I search for "Albert Einstein"
    And I download the article as PDF
    Then the PDF file should be downloaded



    Given I prepare environment
    And I prepare test data
    And I prepare credentials

    When I do my testing
    And I generate my test report
    Then I can see my test results
    And Test result is successful
    