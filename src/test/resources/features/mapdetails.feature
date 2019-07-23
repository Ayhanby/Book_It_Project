@mapdetail @smoke
Feature: Map details


  Scenario: Dark side room -kuzzat's cave

    Given user on the login page
    When user logs in using "username" and "password"
    And user clicks the login button
    Then user should be able to see "kuzzat's cave"

  Scenario: Dark side room- all rooms

    Given user on the login page
    When user logs in using "username" and "password"
    And user clicks the login button
    Then user should be able to see following conference room:

        | kitchen     |
        | kilimanjaro |
        | half dome   |
        | denali      |
        | meru        |
        | lobby       |
        | study area  |
        | 4stay       |
        | ocean view  |










