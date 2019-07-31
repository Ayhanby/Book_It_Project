Feature: Team information back end

  @db
  Scenario: Team members database test

    Given user on the login page
    When user logs in using "jrowesby8h@google.co.uk" and "aldridgegrimsdith"
    And user clicks the login button
    Then user goes to the "my team" page
    And team information should match database records


  @wip @db
  Scenario: Verify rooms and clusters
      Given there is a list of clusters in the clusters table
      And all rooms have a clusters id in room table
      Then all the clusters ids must be from the clusters table