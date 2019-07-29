Feature: Team information back end

  @wip
  Scenario: Team members database test

    Given user on the login page
    When user logs in using "jrowesby8h@google.co.uk" and "aldridgegrimsdith"
    And user clicks the login button
    Then user goes to the "my team" page
    And team information should match database records