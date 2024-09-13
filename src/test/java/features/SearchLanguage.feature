Feature: Search Wikipedia in a specific language

  Scenario: Search for Gabriel García Márquez in Spanish
    Given the Main page is open
    When I search for "Gabriel García Márquez" in "Español"
    Then the article page for "Gabriel García Márquez" should be open
