@login
Feature: Login Page

  Background:
    Given The user is on login page

  @teamlead
  Scenario: Login as team lead

    When  user logs in as team lead
    And  clicks on login button
    Then homepage should be displayed
    And  title should be correct


  @member
  Scenario: Login as team member

    When  user logs in as "jrowesby8h@google.co.uk" and "aldridgegrimsdith"
    And  clicks on login button
    Then homepage should be displayed
    And  title should be correct


  @teacher
  Scenario: Login as teacher

    When  user logs in as teacher
    And  clicks on login button
    Then homepage should be displayed
    And  title should be correct


    @differentmembers
    Scenario Outline: login as different members

      When  user logs in as <type>
      And  clicks on login button
      Then homepage should be displayed
      And  title should be correct

      Examples:
      |type       |
      |team lead  |
      |team member|
      |teacher    |

