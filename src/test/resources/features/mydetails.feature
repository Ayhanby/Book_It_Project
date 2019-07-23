@detail
Feature: My details page

  @mydetails
  Scenario: my information

    Given user on the login page
    When user logs in using "jrowesby8h@google.co.uk" and "aldridgegrimsdith"
    And user clicks the login button
    Then user goes to the "my self" page
    Then user should see his information:

      |name   | Aldridge Grimsdith    |
      |role   | student-team-member   |
      |team   | Rangers               |
      |batch  | #7                    |
      |campus | VA                    |




    @roominfo
    Scenario: room information

      Given user on the login page
      When user logs in using "jrowesby8h@google.co.uk" and "aldridgegrimsdith"
      And user clicks the login button
      Then user should be able to see quotes info for each room
      |kilimanjaro|the more the better|
      |half dome  |the more the better|
      |denali     |less is more       |
      |meru       |less is more       |


      @details
      Scenario Outline: my information data driven test

        Given user on the login page
        When user logs in using "<user-email>" and "<user-password>"
        And user clicks the login button
        Then user goes to the "my self" page
        Then user should see his information:

          |name   | <user-name>   |
          |role   | <user-role>   |
          |team   | <user-team>   |
          |batch  | <user-batch>  |
          |campus | <user-campus> |

        Examples:

        |user-email              |user-password     |user-name          |user-role           |user-team  |user-batch  |user-campus  |

        |jrowesby8h@google.co.uk |aldridgegrimsdith |Aldridge Grimsdith |student-team-member |Rangers    |#7          |VA           |

        |jrowesby8h@google.co.uk |aldridgegrimsdith |Aldridge Grimsdith |student-team-member |Rangers    |#7          |VA           |

