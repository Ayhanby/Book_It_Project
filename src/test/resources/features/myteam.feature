@smoke
Feature: Team members

#  @myteam
  Scenario: Team members test

    Given user on the login page
    When user logs in using "jrowesby8h@google.co.uk" and "aldridgegrimsdith"
    And user clicks the login button
    Then user goes to the "my team" page
    And following team members should be displayed:

      | Aldridge    |
      | Shane       |
      | Joya        |
      | Byrann      |
      | Cecil       |